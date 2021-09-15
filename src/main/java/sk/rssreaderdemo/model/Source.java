package sk.rssreaderdemo.model;

public class Source {
    private final String name;
    private final String url;

    public Source(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
