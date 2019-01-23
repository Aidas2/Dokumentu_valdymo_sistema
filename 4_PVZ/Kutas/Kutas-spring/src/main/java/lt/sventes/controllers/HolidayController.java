package lt.sventes.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.sventes.rest.HolidayRest;
import lt.sventes.rest.HolidayRestResponse;
import lt.sventes.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "holidays")
@RequestMapping("/api/holidays")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    //READ
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all holidays", notes="Returns all holidays")
    public List<HolidayRestResponse> getAll() {
        return holidayService.getAll();
    }
    //READ BY ID
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ApiOperation(value = "Get holiday info", notes="Returns holiday info")
    public HolidayRestResponse getById(
            @ApiParam(value = "Holiday id", required = true)
            @PathVariable Long id) {
        return holidayService.getById(id);
    }
    //CREATE
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new holiday", notes="Creates new holiday")
    public void create(
            @ApiParam(value = "User data", required = true)
            @RequestBody
            final HolidayRest holidayRest) {
        holidayService.create(holidayRest);
    }
    //DELETE
    @RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    @ApiOperation(value="Delete holiday")
    public void delete(
            @ApiParam(value="Holiday id", required = true)
            @PathVariable final Long id) {
        holidayService.delete(id);
    }
    //UPDATE
    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Update holiday info", notes="Updates holiday by id")
    public void update(
            @ApiParam(value = "User data", required = true)
            @RequestBody
            final HolidayRest holidayRest,
            @ApiParam(value="Holiday id", required = true)
            @PathVariable Long id) {
        holidayService.update(id, holidayRest);
    }
    //ASSIGN COUNTRY
    @RequestMapping(path="/{id}/country/{id}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Assign country to holiday")
    public void addCountryToHoliday (
            @ApiParam(value="Holiday id", required = true)
            @PathVariable Long holidayId,
            @ApiParam(value="Country id", required = true)
            @PathVariable Long countryId){
        holidayService.addCountry(holidayId, countryId);
    }
}
