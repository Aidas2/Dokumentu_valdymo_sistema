package lt.sventes.countries.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.sventes.countries.Country;
import lt.sventes.countries.CountryData;
import lt.sventes.holidays.Holiday;
import lt.sventes.holidays.HolidayData;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
//GET ALL
	@Transactional(readOnly = true)
	public List<CountryData> getFullListOfCountries() {
		return countryRepository.findAll().stream().map((country) ->
		new CountryData(country.getTitle(),	
						country.getImage(),
						country.getPresident()
						)).collect(Collectors.toList());		
	}
//GET BY ID
	@Transactional(readOnly = true)
	public CountryData findCountryByTitle(String title) {
		// System.out.println("------------------ koks čia produktas? -> " +
		// productRepository.findProductById(id).toString());
		Country currentCountry = countryRepository.findCountryByTitle(title);
		CountryData countryToController = new CountryData(currentCountry.getTitle(),
				currentCountry.getImage(), currentCountry.getPresident());
		return countryToController;
	}
//CREATE
	@Transactional
	public void createCountry(String title, String image, String president) {
		Country newCountry = new Country(title, image, president);
		countryRepository.save(newCountry);
	}
//UPDATE
	@Transactional
	public void updateCountry(String currentTitle, String title, String image, String president) {
		System.out.println("--------------------Atėjau iki čia. Esamas Name yra - " + currentTitle);
		Country countryToUpdate = countryRepository.findCountryByTitle(currentTitle);
		//System.out.println("------------------Surastos institucijos vardas yra " + holidayToUpdate.getTitle());
		countryToUpdate.setTitle(title);
		countryToUpdate.setImage(image);
		countryToUpdate.setPresident(president);
		countryRepository.save(countryToUpdate);
	}
// DELETE (metodas aprašytas Repositorijoje)
	@Transactional
	public void deleteCountry(String title) {
		countryRepository.deleteCountryByTitle(title);
	}
}
