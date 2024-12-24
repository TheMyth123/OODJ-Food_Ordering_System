package oodj.food_ordering_system.models;

public class Notification {
    private String timestamp;
    private String title;
    private String content;
    private String actionLink;

    public Notification(String timestamp, String title, String content, String actionLink) {
        this.timestamp = timestamp;
        this.title = title;
        this.content = content;
        this.actionLink = actionLink;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getActionLink() {
        return actionLink;
    }

    public void setActionLink(String actionLink) {
        this.actionLink = actionLink;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "timestamp='" + timestamp + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", actionLink='" + actionLink + '\'' +
                '}';
    }
}
