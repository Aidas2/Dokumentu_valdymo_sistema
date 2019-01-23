package lt.sventes.entities;


import lt.sventes.enums.HolidayType;

import javax.persistence.*;

@Entity
@Table(name = "holidays", uniqueConstraints = {@UniqueConstraint( columnNames = "title")})
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String title;
    private String description;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private HolidayType type;
    private boolean isFlagRaised;

    public Holiday() {
    }

    public Holiday(String title, String description, String imageUrl, HolidayType type, boolean isFlagRaised) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.isFlagRaised = isFlagRaised;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
