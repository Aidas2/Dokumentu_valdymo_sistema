package lt.sventes.dto;

public class ReturnHolidaysDTO {

	private String title;
	private String description;
	private String image;
	private String type;
	private Boolean flagRaise;

	public ReturnHolidaysDTO(String title, String description, String image,
			String type, Boolean flagRaise) {
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
