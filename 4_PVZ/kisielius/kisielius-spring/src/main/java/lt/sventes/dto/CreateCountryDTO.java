package lt.sventes.dto;

import javax.validation.constraints.NotNull;

public class CreateCountryDTO {

	@NotNull
	private String name;
	@NotNull
	private String flag;
	@NotNull
	private String president;

	public CreateCountryDTO(@NotNull String name, @NotNull String flag,
			@NotNull String president) {
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
