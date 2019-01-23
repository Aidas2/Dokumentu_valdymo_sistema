package lt.sventes.dto;

public class ReturnCountryDTO {

	private String name;
	private String flag;
	private String president;

	public ReturnCountryDTO(String name, String flag, String president) {
		super();
		this.name = name;
		this.flag = flag;
		this.president = president;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

}
