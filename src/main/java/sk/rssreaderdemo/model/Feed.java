package sk.rssreaderdemo.model;

public class Feed {

    private final int id;
    private final String title;
    private final String link;
    private final String description;
    private final Long publicDate;
    private final String author;

    public Feed(int id, String title, String link, String description, Long publicDate, String author) {
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

    public Long getPublicDate() {
        return publicDate;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", publicDate='" + publicDate + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
