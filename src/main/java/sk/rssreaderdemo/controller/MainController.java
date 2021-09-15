package sk.rssreaderdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.rssreaderdemo.service.FeedService;
import sk.rssreaderdemo.service.SourceService;
import sk.rssreaderdemo.to.FeedTo;
import sk.rssreaderdemo.util.FeedsUtil;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final FeedService feedService;
    private final SourceService sourceService;

    @Autowired
    public MainController(FeedService feedService, SourceService sourceService) {
        this.feedService = feedService;
        this.sourceService = sourceService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("sources", sourceService.showAll());
        List<FeedTo> tos = FeedsUtil.getTos(feedService.showAll());
        model.addAttribute("feedToList", tos);
        return "index";
    }



}
