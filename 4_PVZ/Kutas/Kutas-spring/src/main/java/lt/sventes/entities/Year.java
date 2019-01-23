package lt.sventes.entities;

import lt.sventes.enums.Zodiac;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "years", uniqueConstraints = {@UniqueConstraint( columnNames = "year")})
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private int year;
    private int month;
    private int day;
    @Enumerated(EnumType.STRING)
    private Zodiac zodiac;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    private List<HolidaySpecific> holidaySpecificList;

    public Year() {
    }

    public Year(int year, int month, int day, Zodiac zodiac, List<HolidaySpecific> holidaySpecificList) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.zodiac = zodiac;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Zodiac getZodiac() {
        return zodiac;
    }

    public void setZodiac(Zodiac zodiac) {
        this.zodiac = zodiac;
    }

    public List<HolidaySpecific> getHolidaySpecificList() {
        return holidaySpecificList;
    }

    public void setHolidaySpecificList(List<HolidaySpecific> holidaySpecificList) {
        this.holidaySpecificList = holidaySpecificList;
    }
}
