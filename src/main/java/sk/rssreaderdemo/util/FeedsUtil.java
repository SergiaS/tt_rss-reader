package sk.rssreaderdemo.util;

import sk.rssreaderdemo.model.Feed;
import sk.rssreaderdemo.to.FeedTo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class FeedsUtil {

    public static List<FeedTo> getTos(List<Feed> feeds) {
        return feeds.stream()
                .map(FeedsUtil::createTo)
                .collect(Collectors.toList());
    }

    private static FeedTo createTo(Feed feed) {
        return new FeedTo(
                feed.getId(),
                feed.getTitle(),
                feed.getLink(),
                feed.getDescription(),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(feed.getPublicDate()), TimeZone.getDefault().toZoneId()),
                feed.getAuthor());
    }
}
