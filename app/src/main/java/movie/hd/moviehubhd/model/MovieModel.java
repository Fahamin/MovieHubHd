package movie.hd.moviehubhd.model;

public class MovieModel {

    int id;
    String key_id;
    String name;
    String description;
    String length;
    String date;
    String link;

    public MovieModel(int id, String key_id, String name, String description, String length, String date, String link) {
        this.id = id;
        this.key_id = key_id;
        this.name = name;
        this.description = description;
        this.length = length;
        this.date = date;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
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
