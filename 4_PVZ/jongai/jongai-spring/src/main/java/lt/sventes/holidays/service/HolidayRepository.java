package lt.sventes.holidays.service;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.sventes.holidays.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
	Holiday findHolidayByTitle(String title);
	void deleteHolidayByTitle(String title);
	
	
}
