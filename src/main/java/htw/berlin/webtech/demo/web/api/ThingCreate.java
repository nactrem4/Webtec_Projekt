package htw.berlin.webtech.demo.web.api;

public class ThingCreate {
    private String filmName;
    private String filmGenre;
    private String filmDescription;

    public ThingCreate(String name, String description, String genre) {
        filmName = name;
        filmDescription = description;
        filmGenre = genre;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }
}
