package lt.sventes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "years")
public class Year {

	@Id
	@Column(unique = true, nullable = false)
	private Integer year;
	private Integer daysCount;
	private String horoscope;

	public Year() {

	}

	public Year(Integer year, Integer daysCount, String horoscope) {
		super();
		this.year = year;
		this.daysCount = daysCount;
		this.horoscope = horoscope;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(Integer daysCount) {
		this.daysCount = daysCount;
	}

	public String getHoroscope() {
		return horoscope;
	}

	public void setHoroscope(String horoscope) {
		this.horoscope = horoscope;
	}

}
