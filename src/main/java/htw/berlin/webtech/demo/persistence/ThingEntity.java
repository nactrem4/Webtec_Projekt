package htw.berlin.webtech.demo.persistence;


import javax.persistence.*;

@Entity(name = "things")
public class ThingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "film_name")
    private String filmName;
    @Column(name = "film_genre")
    private String filmGenre;
    @Column(name = "film_description")
    private String filmDescription;

    public ThingEntity(String filmName, String filmGenre, String filmDescription) {
        this.filmName = filmName;
        this.filmGenre = filmGenre;
        this.filmDescription = filmDescription;
    }

    protected ThingEntity() {}

    public long getId() {
        return id;
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
