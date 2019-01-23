package lt.sventes.dto;

import javax.validation.constraints.NotNull;

public class CreateHolidayDTO {

	@NotNull
	private String title;
	@NotNull
	private String description;
	@NotNull
	private String image;
	@NotNull
	private String type;
	@NotNull
	private Boolean flagRaise;

	public CreateHolidayDTO(@NotNull String title, @NotNull String description,
			@NotNull String image,
			@NotNull String type, @NotNull Boolean flagRaise) {
		super();
		this.title = title;
		this.description = description;
		this.image = image;
		this.type = type;
		this.flagRaise = flagRaise;

	}

	public Boolean getFlagRaise() {
		return flagRaise;
	}

	public void setFlagRaise(Boolean flagRaise) {
		this.flagRaise = flagRaise;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
