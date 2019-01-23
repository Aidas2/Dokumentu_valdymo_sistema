package lt.sventes.rest;

import lt.sventes.enums.HolidayType;

import javax.persistence.*;

public class HolidayRest {
    private String title;
    private String description;
    private String imageUrl;
    private HolidayType type;
    private boolean isFlagRaised;

    public HolidayRest() {
    }

    public HolidayRest(String title, String description, String imageUrl, HolidayType type, boolean isFlagRaised) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.type = type;
        this.isFlagRaised = isFlagRaised;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public HolidayType getType() {
        return type;
    }

    public void setType(HolidayType type) {
        this.type = type;
    }

    public boolean isFlagRaised() {
        return isFlagRaised;
    }

    public void setFlagRaised(boolean flagRaised) {
        isFlagRaised = flagRaised;
    }
}
