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
import lt.sventes.dto.CreateHolidayDTO;
import lt.sventes.dto.ReturnHolidaysDTO;
import lt.sventes.entities.Holiday;
import lt.sventes.services.HolidayService;

@RestController
@Api(value = "holiday")
@RequestMapping(value = "/api/holidays")
public class HolidayController {

	private HolidayService holidayService;

	@Autowired
	public HolidayController(HolidayService holidayService) {
		super();
		this.holidayService = holidayService;
	}

	public HolidayService getHolidayService() {
		return holidayService;
	}

	public void setHolidayService(HolidayService holidayService) {
		this.holidayService = holidayService;
	}
	//READ
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get holidays", notes = "Returns holidays")
	public List<ReturnHolidaysDTO> getHolidays() {
		return holidayService.getHolidays().stream()
				.map(holiday -> new ReturnHolidaysDTO(
						holiday.getTitle(), holiday.getDescription(), holiday.getImage(),
						holiday.getType(), holiday.getFlagRaise()))
				.collect(Collectors.toList());
	}
	//READ BY TITLE
	@RequestMapping(value = "/{title}", method = RequestMethod.GET)
	@ApiOperation(value = "Get holiday", notes = "Returns holiday")
	public ReturnHolidaysDTO getHoliday(@ApiParam(value = "Holiday title", required = true) @PathVariable("title") final String title) {
		Holiday holiday = holidayService.getHoliday(title);
		return new ReturnHolidaysDTO(
				holiday.getTitle(),
				holiday.getDescription(),
				holiday.getImage(),
				holiday.getType(),
				holiday.getFlagRaise()
				);
	}
	//CREATE
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create holiday", notes = "Creates new holiday")
	public void createHoliday(
			@ApiParam(value = "Holiday data", required = true) @RequestBody @Valid final CreateHolidayDTO createHolidayDTO) {
		holidayService.createHoliday(createHolidayDTO);

	}
	//DELETE
	@RequestMapping(value = "/{title}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete holiday", notes = "Deletes holiday")
	public void deleteHoliday(
			@ApiParam(value = "Holiday title", required = true) @PathVariable("title") final String title) {
		holidayService.deleteHoliday(title);
	}

}
