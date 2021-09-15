package sk.rssreaderdemo.to;

import java.time.LocalDateTime;

public class FeedTo {
    private final int id;
    private final String title;
    private final String link;
    private final String description;
    private final LocalDateTime publicDate;
    private final String author;

    public FeedTo(int id, String title, String link, String description, LocalDateTime publicDate, String author) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.publicDate = publicDate;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getPublicDate() {
        return publicDate;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "FeedTo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", publicDate=" + publicDate +
                ", author='" + author + '\'' +
                '}';
    }
}
