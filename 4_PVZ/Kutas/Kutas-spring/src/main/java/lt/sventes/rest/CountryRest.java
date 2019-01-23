package lt.sventes.rest;

import lt.sventes.entities.HolidaySpecific;

import javax.persistence.*;
import java.util.List;

public class CountryRest {
    private String title;
    private String imageUrl;
    private String president;

    public CountryRest() {
    }

    public CountryRest(String title, String imageUrl, String president) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.president = president;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }
}
