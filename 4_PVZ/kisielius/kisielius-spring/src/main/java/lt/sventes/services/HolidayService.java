package lt.sventes.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.sventes.dto.CreateHolidayDTO;
import lt.sventes.entities.Holiday;
import lt.sventes.interfaces.HolidayRepository;

@Service
public class HolidayService {

	private HolidayRepository holidayRepository;

	@Autowired
	public HolidayService(HolidayRepository holidayRepository) {
		super();
		this.holidayRepository = holidayRepository;
	}

	public HolidayRepository getHolidayRepository() {
		return holidayRepository;
	}

	public void setHolidayRepository(HolidayRepository holidayRepository) {
		this.holidayRepository = holidayRepository;
	}

//GET ALL
	@Transactional
	public List<Holiday> getHolidays() {
		return holidayRepository.findAll();
	}
//GET BY TITLE
	@Transactional
	public Holiday getHoliday(String title) {
		return holidayRepository.findByTitle(title);
	}
//CREATE
	@Transactional
	public void createHoliday(CreateHolidayDTO createHolidayDTO) {
		Holiday holiday = new Holiday(
				createHolidayDTO.getTitle(),
				createHolidayDTO.getDescription(),
				createHolidayDTO.getImage(),
				createHolidayDTO.getType(),
				createHolidayDTO.getFlagRaise());
		holidayRepository.save(holiday);
	}
//DELETE
	@Transactional
	public void deleteHoliday(String title) {
		holidayRepository.deleteByTitle(title);
	}
}
