package lt.sventes.repositories;

import lt.sventes.entities.Country;
import lt.sventes.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository <Country, Long> {
}
