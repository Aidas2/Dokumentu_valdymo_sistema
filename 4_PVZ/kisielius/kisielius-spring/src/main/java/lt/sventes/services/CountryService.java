package lt.sventes.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.sventes.dto.CreateCountryDTO;
import lt.sventes.entities.Country;
import lt.sventes.interfaces.CountryRepository;

@Service
public class CountryService {

	private CountryRepository countryRepository;

	@Autowired
	public CountryService(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}

	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
//GET ALL
	@Transactional
	public List<Country> getCountries() {
		return countryRepository.findAll();
	}
//GET BY NAME
	@Transactional
	public Country getCountry(String name) {
		return countryRepository.findByName(name);
	}

//CREATE
	@Transactional
	public void createCountry(@Valid CreateCountryDTO createCountryDTO) {
		Country country = new Country(
				createCountryDTO.getName(),
				createCountryDTO.getFlag(),
				createCountryDTO.getPresident());
		countryRepository.save(country);
	}
//UPDATE
	@Transactional
	public void updateCountry(CreateCountryDTO createCountryDTO) {
		Country country = countryRepository.findByName(createCountryDTO.getName());
		country.setFlag(createCountryDTO.getFlag());
		country.setPresident(createCountryDTO.getPresident());
		countryRepository.save(country);
	}
//DELETE
	@Transactional
	public void deleteCountry(String name) {
		countryRepository.deleteByName(name);
	}

}
