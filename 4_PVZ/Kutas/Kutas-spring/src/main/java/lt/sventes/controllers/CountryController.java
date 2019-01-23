package lt.sventes.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.sventes.rest.CountryRest;
import lt.sventes.rest.CountryRestResponse;
import lt.sventes.rest.HolidayRest;
import lt.sventes.rest.HolidayRestResponse;
import lt.sventes.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "countries")
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    //READ
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all countries", notes="Returns all countries")
    public List<CountryRestResponse> getAll() {
        return countryService.getAll();
    }
    //READ BY ID
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ApiOperation(value = "Get country info", notes="Returns country info")
    public CountryRestResponse getById(
            @ApiParam(value = "Country id", required = true)
            @PathVariable Long id) {
        return countryService.getById(id);
    }
    //CREATE
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add new country", notes="Adds new country")
    public void create(
            @ApiParam(value = "User data", required = true)
            @RequestBody
            final CountryRest countryRest) {
        countryService.create(countryRest);
    }
    //DELETE
    @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Delete country")
    public void delete(
            @ApiParam(value="Country id", required = true)
            @PathVariable final Long id) {
        countryService.delete(id);
    }
    //UPDATE
    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update country info", notes="Updates country by id")
    public void update(
            @ApiParam(value = "User data", required = true)
            @RequestBody
            final CountryRest countryRest,
            @ApiParam(value="Country id", required = true)
            @PathVariable Long id) {
        countryService.update(id, countryRest);
    }
}
