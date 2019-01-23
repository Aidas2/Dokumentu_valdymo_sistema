package lt.sventes.services;

import lt.sventes.entities.Country;
import lt.sventes.entities.Holiday;
import lt.sventes.entities.HolidaySpecific;
import lt.sventes.repositories.CountryRepository;
import lt.sventes.rest.CountryRest;
import lt.sventes.rest.CountryRestResponse;
import lt.sventes.rest.HolidayRest;
import lt.sventes.rest.HolidayRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;
//GET ALL
    @Transactional(readOnly = true)
    public List<CountryRestResponse> getAll() {
        return countryRepository.findAll()
                .stream()
                .map((country) -> new CountryRestResponse(
                        country.getId(),
                        country.getTitle(),
                        country.getImageUrl(),
                        country.getPresident()
                )).collect(Collectors.toList());
    }
//GET BY ID
    @Transactional(readOnly = true)
    public CountryRestResponse getById(Long id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        return new CountryRestResponse(
                country.getId(),
                country.getTitle(),
                country.getImageUrl(),
                country.getPresident()
        );
    }
//CREATE
    @Transactional
    public void create(CountryRest countryRest) {
        countryRepository.save(new Country (
                countryRest.getTitle(),
                countryRest.getImageUrl(),
                countryRest.getPresident(),
                Collections.emptyList()
        ));
    }

//UPDATE
    @Transactional
    public void update(Long id, CountryRest countryRest) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        List<HolidaySpecific> holidaySpecificList = country.getHolidaySpecificList();
        Country updatedCountry = new Country (
           countryRest.getTitle(),
           countryRest.getImageUrl(),
           countryRest.getPresident(),
           holidaySpecificList
        );
        updatedCountry.setId(id);
        countryRepository.save(updatedCountry);
    }
//DELETE
    @Transactional
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
