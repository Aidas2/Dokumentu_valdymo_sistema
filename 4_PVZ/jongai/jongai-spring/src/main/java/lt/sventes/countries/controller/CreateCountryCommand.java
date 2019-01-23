package lt.sventes.countries.controller;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateCountryCommand {
	@NotNull
	@Length(min = 1, max = 30)
	private String title;
	@NotNull
	@Length(min = 1, max = 30)
	private String image;
	@NotNull
	@Length(min = 1, max = 30)
	private String president;

	public CreateCountryCommand() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

}