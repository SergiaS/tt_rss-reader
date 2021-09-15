package sk.rssreaderdemo.repository;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Repository;
import sk.rssreaderdemo.model.Feed;
import sk.rssreaderdemo.model.Source;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class FeedRepository {

    private final Map<Integer, Feed> feedRepository;
    private static int ID_FEED_COUNTER = 0;

    public FeedRepository(SourceRepository sourceRepository) {
        feedRepository = new HashMap<>();

        sourceRepository.allSources().forEach(s -> readSourceAndAddAllFeeds(s.getUrl()));
    }

    public List<Feed> getAllFeedsByDate() {
        return sortBy(Comparator.comparing(Feed::getPublicDate).reversed());
    }

    public List<Feed> sortBy(Comparator<Feed> comparator) {
        return feedRepository.values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public void addByFeed(Feed feed) {
        feedRepository.put(feed.getId(), feed);
    }

    public void addBySource(Source source) {
        readSourceAndAddAllFeeds(source.getUrl());
    }

    public boolean delete(int id) {
        return feedRepository.remove(id) != null;
    }

    public void readSourceAndAddAllFeeds(String rssSource) {

        SyndFeed syndFeed = readFeed(rssSource);

        for (SyndEntry e : syndFeed.getEntries()) {
            String title = e.getTitle();
            String description = e.getDescription().getValue();
            String link = e.getLink();
            Long publishedDate = e.getPublishedDate().getTime();
            String author = e.getAuthor();

//                System.out.println("Title: " + title + ", Desc: " + description);

            Feed newFeed = new Feed(++ID_FEED_COUNTER, title, link, description, publishedDate, author);
            addByFeed(newFeed);
        }

    }

    private static SyndFeed readFeed(final String url) {
        SyndFeed build = null;
        try {
            URL feedSource = new URL(url);
            SyndFeedInput input = new SyndFeedInput();
            build = input.build(new XmlReader(feedSource));
        } catch (FeedException | IOException e) {
            e.printStackTrace();
        }
        return build;
    }
}
