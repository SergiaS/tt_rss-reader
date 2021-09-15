package sk.rssreaderdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.rssreaderdemo.model.Feed;
import sk.rssreaderdemo.repository.FeedRepository;

import java.util.List;

@Service
public class FeedService {

    private final FeedRepository repository;

    @Autowired
    public FeedService(FeedRepository repository) {
        this.repository = repository;
    }

    public List<Feed> showAll() {
        return repository.getAllFeedsByDate();
    }

    public void addNew(Feed feed) {
        repository.addByFeed(feed);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }


}
