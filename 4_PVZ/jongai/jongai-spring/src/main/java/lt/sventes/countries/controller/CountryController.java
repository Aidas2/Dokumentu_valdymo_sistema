package lt.sventes.countries.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.sventes.countries.CountryData;
import lt.sventes.countries.service.CountryService;
import lt.sventes.holidays.HolidayData;

@RestController
@Api(value = "country")
@RequestMapping(value = "/countries")
public class CountryController {

	private final CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	//READ
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get country list", notes = "Returns list of existing countries")
	public List<CountryData> getCountryList() {
		return countryService.getFullListOfCountries();
	}
	//READ BY TITLE
	@RequestMapping(path = "/{title}", method = RequestMethod.GET)
	@ApiOperation(value = "Get country", notes = "Returns selected country")
	public CountryData getCountryByTitle(
			@ApiParam(value = "Country title", required = true) @Valid @PathVariable final String title) {

		return countryService.findCountryByTitle(title);
	}
	//CREATE
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new country", notes = "Creates new country with provided data")
	public void createHoliday(
			@ApiParam(value = "Country data", required = true) @Valid @RequestBody final CreateCountryCommand ccc) {

		countryService.createCountry(ccc.getTitle(), ccc.getImage(), ccc.getPresident());
	}
	//UPDATE
	@RequestMapping(path = "/{oldTitle}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Edit country", notes = "Change selected country's data")

	public void updateProduct(
			@ApiParam(value = "Country title", required = true) @Valid @PathVariable final String oldTitle,
			@ApiParam(value = "Country data", required = true) @Valid @RequestBody final CreateCountryCommand ccc) {

		countryService.updateCountry(oldTitle, ccc.getTitle(), ccc.getImage(), ccc.getPresident());
	}
	//DELETE šalies trynimas------------------------------------------
	@RequestMapping(path = "/{title}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete country", notes = "Deletes selected contry")
	public void deleteInstitution(@PathVariable final String title) {
		countryService.deleteCountry(title);
		System.out.println("Deleting country: " + title);
	}
}
