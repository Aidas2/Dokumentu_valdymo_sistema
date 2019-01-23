package lt.sventes.holidays;

import javax.persistence.Column;

public class HolidayData {
	private String title;
	private String description;
	private String image;
	private String type;
	boolean flag;
	
	public HolidayData(String title, String description, String image, String type, boolean flag) {
		super();
		this.title = title;
		this.description = description;
		this.image = image;
		this.type = type;
		this.flag = flag;
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	

}
