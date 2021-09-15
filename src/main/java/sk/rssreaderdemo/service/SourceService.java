package sk.rssreaderdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.rssreaderdemo.model.Source;
import sk.rssreaderdemo.repository.SourceRepository;

import java.util.List;

@Service
public class SourceService {

    private final SourceRepository sourceRepository;

    @Autowired
    public SourceService(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    public List<Source> showAll() {
        return sourceRepository.allSources();
    }

    public void addNew(String name, String rssUrl) {
        sourceRepository.add(name, rssUrl);
    }

    public boolean delete(String rssUrl) {
        return sourceRepository.deleteByName(rssUrl);
    }

}
