package lt.sventes.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.sventes.entities.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, String>{
	Holiday findByTitle(String title);
	void deleteByTitle(String title);

}
