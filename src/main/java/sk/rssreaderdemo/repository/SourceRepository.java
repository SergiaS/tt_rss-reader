package sk.rssreaderdemo.repository;

import org.springframework.stereotype.Repository;
import sk.rssreaderdemo.model.Source;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SourceRepository {

    private final List<Source> sourceRepository;

    public SourceRepository() {
        sourceRepository = new ArrayList<>(List.of(
                new Source("Road.cc", "https://road.cc/rss"),
                new Source("BikeRadar.com", "https://www.bikeradar.com/feed/atom/")
        ));
    }

    public List<Source> allSources() {
        return sourceRepository;
    }

    public void add(String name, String rssUrl) {
        sourceRepository.add(new Source(name, rssUrl));
    }

    public boolean deleteByName(String rssUrl) {
        return sourceRepository.removeIf(rss -> rss.getName().equals(rssUrl));
    }
}
