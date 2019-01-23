package lt.sventes.countries.service;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.sventes.countries.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
	Country findCountryByTitle(String title);
	void deleteCountryByTitle(String title);
	
	
}
