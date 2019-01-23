package lt.sventes.repositories;

import lt.sventes.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository <Holiday, Long> {
}
