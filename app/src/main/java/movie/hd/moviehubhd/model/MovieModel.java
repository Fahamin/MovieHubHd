package movie.hd.moviehubhd.model;

public class MovieModel {

    String key_id;
    String title;
    String description;
    String length;
    String date;
    String link;

    public MovieModel(String key_id, String title, String description, String length, String date, String link) {
        this.key_id = key_id;
        this.title = title;
        this.description = description;
        this.length = length;
        this.date = date;
        this.link = link;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
