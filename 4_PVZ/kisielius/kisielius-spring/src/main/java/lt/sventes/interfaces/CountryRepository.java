package lt.sventes.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.sventes.entities.Country;

public interface CountryRepository extends JpaRepository<Country, String>{
	void deleteByName(String name);
	Country findByName(String name);

}
