package lt.sventes.holidays.controller;

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
import lt.sventes.holidays.HolidayData;
import lt.sventes.holidays.service.HolidayService;

@RestController
@Api(value = "holiday")
@RequestMapping(value = "/holidays")
public class HolidayController {

	private final HolidayService holidayService;

	@Autowired
	public HolidayController(HolidayService holidayService) {
		this.holidayService = holidayService;
	}

	//READ
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get holiday list", notes = "Returns list of existing holidays")
	public List<HolidayData> getHolidayList() {
		return holidayService.getFullListOfHolidays();
	}

	//READ BY TITLE
	@RequestMapping(path = "/{title}", method = RequestMethod.GET)
	@ApiOperation(value = "Get holiday", notes = "Returns selected holiday")
	public HolidayData getHolidayByTitle(
			@ApiParam(value = "Holiday title", required = true) @Valid @PathVariable final String title) {
		return holidayService.findHolidayByTitle(title);
	}
	//CREATE
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new holiday", notes = "Creates new holiday with provided data")
	public void createHoliday(
			@ApiParam(value = "Holiday data", required = true) @Valid @RequestBody final CreateHolidayCommand chc) {

		holidayService.createHoliday(chc.getTitle(), chc.getDescription(), chc.getImage(), chc.getType(), chc.isFlag());
	}
	//UPDATE
	@RequestMapping(path = "/{oldTitle}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Edit holiday", notes = "Change selected holiday's data")

	public void updateProduct(
			@ApiParam(value = "Holiday title", required = true) @Valid @PathVariable final String oldTitle,
			@ApiParam(value = "Holiday data", required = true) @Valid @RequestBody final CreateHolidayCommand chc) {
		holidayService.updateInstitution(oldTitle, chc.getTitle(), chc.getDescription(), chc.getImage(),
				chc.getType(), chc.isFlag());
	}
	//DELETE ------------------------------------------
	@RequestMapping(path = "/{title}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete holiday", notes = "Deletes selected holiday")
	public void deleteInstitution(@PathVariable final String title) {
		holidayService.deleteHoliday(title);
		System.out.println("Deleting holiday: " + title);
	}
}
