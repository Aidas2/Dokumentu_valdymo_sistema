package lt.sventes.entities;

import lt.sventes.enums.HolidayType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries", uniqueConstraints = {@UniqueConstraint( columnNames = "title")})

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String title;
    private String imageUrl;
    private String president;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    private List<HolidaySpecific> holidaySpecificList;

    public Country() {
    }

    public Country(String title, String imageUrl, String president, List<HolidaySpecific> holidaySpecificList) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.president = president;
        this.holidaySpecificList = holidaySpecificList;
    }

    public void addHoliday(HolidaySpecific holidaySpecific) {
        holidaySpecificList.add(holidaySpecific);
    }

    public void removeHoliday(HolidaySpecific holidaySpecific) {
        holidaySpecificList.remove(holidaySpecific);
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

    public List<HolidaySpecific> getHolidaySpecificList() {
        return holidaySpecificList;
    }

    public void setHolidaySpecificList(List<HolidaySpecific> holidaySpecificList) {
        this.holidaySpecificList = holidaySpecificList;
    }

    ;
}
