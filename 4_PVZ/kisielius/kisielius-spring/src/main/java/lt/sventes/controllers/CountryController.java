package lt.sventes.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
import lt.sventes.dto.CreateCountryDTO;
import lt.sventes.dto.ReturnCountryDTO;
import lt.sventes.entities.Country;
import lt.sventes.services.CountryService;

@RestController
@Api(value = "countries")
@RequestMapping(value = "/api/countries")
public class CountryController {

	private CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}
	//READ
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get countries", notes = "Returns countries")
	public List<ReturnCountryDTO> getCountries() {
		return countryService.getCountries().stream()
				.map(country -> new ReturnCountryDTO(
						country.getName(),
						country.getFlag(),
						country.getPresident()))
				.collect(Collectors.toList());
	}
	//READ BY NAME
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ApiOperation(value = "Get country", notes = "Returns country")
	public ReturnCountryDTO getCountry(@ApiParam(value = "Country name", required = true) @PathVariable("name") final String name) {
		Country country = countryService.getCountry(name);
		return new ReturnCountryDTO(country.getName(), country.getFlag(), country.getPresident());
	}
	//CREATE
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create country", notes = "Creates new country")
	public void createHoliday(
			@ApiParam(value = "COuntry data", required = true) @RequestBody @Valid final CreateCountryDTO createCountryDTO) {
		countryService.createCountry(createCountryDTO);
	}
	//DELETE
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete country", notes = "Deletes country")
	public void deleteCountry(
			@ApiParam(value = "Country name", required = true) @PathVariable("name") final String name) {
		countryService.deleteCountry(name);
	}
	//UPDATE
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update country", notes = "Updates existing country info")
	public void updateProduct(
			@ApiParam(value = "Country data", required = true) @RequestBody @Valid final CreateCountryDTO createCountryDTO,
			@ApiParam(value = "Country name", required = true) @PathVariable("name") final String name) {
		countryService.updateCountry(createCountryDTO);
	}

}
