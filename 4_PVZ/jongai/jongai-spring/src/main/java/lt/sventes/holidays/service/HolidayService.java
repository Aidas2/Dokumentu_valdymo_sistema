package lt.sventes.holidays.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.sventes.holidays.Holiday;
import lt.sventes.holidays.HolidayData;

@Service
public class HolidayService {

	@Autowired
	private HolidayRepository holidayRepository;
	//GET ALL
	@Transactional(readOnly = true)
	public List<HolidayData> getFullListOfHolidays() {
		return holidayRepository.findAll().stream().map((holiday) ->
		new HolidayData(holiday.getTitle(),
							holiday.getDescription(),
						holiday.getImage(),
						holiday.getType(),
						holiday.isFlag()
						)).collect(Collectors.toList());		
	}
	//GET BY ID
	@Transactional(readOnly = true)
	public HolidayData findHolidayByTitle(String title) {
		// System.out.println("------------------ koks čia produktas? -> " +
		// productRepository.findProductById(id).toString());
		Holiday currentHoliday = holidayRepository.findHolidayByTitle(title);
		HolidayData holidayToController = new HolidayData(currentHoliday.getTitle(),
				currentHoliday.getDescription(), currentHoliday.getImage(), currentHoliday.getType(),
				currentHoliday.isFlag());
		return holidayToController;
	}
	//CREATE
	@Transactional
	public void createHoliday(String title, String description, String image, String type, boolean flag) {
		Holiday newHoliday = new Holiday(title, description, image, type, flag);
		holidayRepository.save(newHoliday);
	}
	//UPDATE
	@Transactional
	public void updateInstitution(String currentTitle, String title, String description, String image, String type, boolean flag) {
		System.out.println("--------------------Atėjau iki čia. Esamas Name yra - " + currentTitle);
		Holiday holidayToUpdate = holidayRepository.findHolidayByTitle(currentTitle);
		System.out.println("------------------Surastos institucijos vardas yra " + holidayToUpdate.getTitle());
		holidayToUpdate.setTitle(title);
		holidayToUpdate.setDescription(description);
		holidayToUpdate.setImage(image);
		holidayToUpdate.setType(type);
		holidayToUpdate.setFlag(flag);
		holidayRepository.save(holidayToUpdate);
	}
	//DELETE (metodas aprašytas Repositorijoje)
	@Transactional
	public void deleteHoliday(String title) {
		holidayRepository.deleteHolidayByTitle(title);
	}
}
