package lt.sventes.countries.controller;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class EditCountryCommand {
	@NotNull
	@Length(min = 1, max = 30)
	private String oldName;
	@NotNull
	@Length(min = 1, max = 30)
	private String name;
	@NotNull
	@Length(min = 1, max = 30)
	private String city;
	@NotNull
	@Length(min = 1, max = 30)
	private String image;
	@NotNull
	@Length(min = 1, max = 30)
	private String category;
	@NotNull
	@Length(min = 1, max = 30)
	private String type;
	@NotNull
	@Length(min = 1, max = 30)
	private String typeOfType;
	@NotNull
	@Length(min = 1, max = 30)
	
	public EditCountryCommand () {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeOfType() {
		return typeOfType;
	}

	public void setTypeOfType(String typeOfType) {
		this.typeOfType = typeOfType;
	}

}
