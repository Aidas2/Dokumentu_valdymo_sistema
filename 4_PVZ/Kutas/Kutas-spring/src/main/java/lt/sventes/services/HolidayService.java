package lt.sventes.services;

import lt.sventes.entities.Country;
import lt.sventes.entities.Holiday;
import lt.sventes.entities.HolidaySpecific;
import lt.sventes.repositories.CountryRepository;
import lt.sventes.repositories.HolidayRepository;
import lt.sventes.rest.HolidayRest;
import lt.sventes.rest.HolidayRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;
    @Autowired
    private CountryRepository countryRepository;
//GET ALL
    @Transactional(readOnly = true)
    public List<HolidayRestResponse> getAll() {
        return holidayRepository.findAll()
                .stream()
                .map((holiday) -> new HolidayRestResponse(
                        holiday.getId(),
                        holiday.getTitle(),
                        holiday.getDescription(),
                        holiday.getImageUrl(),
                        holiday.getType(),
                        holiday.isFlagRaised()
                )).collect(Collectors.toList());
    }
//GET BY ID
    @Transactional(readOnly = true)
    public HolidayRestResponse getById(Long id) {
        Holiday holiday = holidayRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        return new HolidayRestResponse(
                holiday.getId(),
                holiday.getTitle(),
                holiday.getDescription(),
                holiday.getImageUrl(),
                holiday.getType(),
                holiday.isFlagRaised()
        );
    }
//CREATE
    @Transactional
    public void create(HolidayRest holidayRest) {
        holidayRepository.save(new Holiday (
                holidayRest.getTitle(),
                holidayRest.getDescription(),
                holidayRest.getImageUrl(),
                holidayRest.getType(),
                holidayRest.isFlagRaised()
        ));
    }
//UPDATE
    @Transactional
    public void update(Long id, HolidayRest holidayRest) {
        Holiday holiday = new Holiday (
                holidayRest.getTitle(),
                holidayRest.getDescription(),
                holidayRest.getImageUrl(),
                holidayRest.getType(),
                holidayRest.isFlagRaised()
        );
        holiday.setId(id);
        holidayRepository.save(holiday);
    }
//DELETE
    @Transactional
    public void delete(Long id) {
        holidayRepository.deleteById(id);
    }
//PUT
    @Transactional
    public void addCountry(Long holidayId, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException());
        Holiday holiday = holidayRepository.findById(holidayId).orElseThrow(() -> new ResourceNotFoundException());

        HolidaySpecific holidaySpecific = new HolidaySpecific(holiday, country, null);
        country.addHoliday(holidaySpecific);
        countryRepository.save(country);
    }
}
