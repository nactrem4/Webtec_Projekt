package htw.berlin.webtech.demo.web.api;

public class Thing {

    private long id;
    private String filmName;
    private String filmGenre;
    private String filmDescription;

    public Thing(long id, String name, String description, String genre) {
        this.id = id;
        filmName = name;
        filmDescription = description;
        filmGenre = genre;
    }

    public long getId() {
        return id;
    }

    public String getGenre() {
        return filmGenre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return filmName;
    }

    public void setName(String name) {
        filmName = name;
    }

    public String getDescription() {
        return filmDescription;
    }

    public void setDescription(String description) {
        filmDescription = description;
    }

    public void setGenre(String genre) {
        filmGenre = genre;
    }
}
