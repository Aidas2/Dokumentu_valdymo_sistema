package it.akademija.repositories;

import it.akademija.db.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Long> {
    Service findOneByTitle(String title);

    void deleteOneByTitle(String title);

    boolean existsByTitle(String title);

    List<Service> getByTitleContaining(String title);

    @Query("SELECT s FROM Service s WHERE "+
            "LOWER(s.title) LIKE LOWER(CONCAT('%',:title, '%')) OR " +
            "LOWER(s.description) LIKE LOWER(CONCAT('%',:description, '%'))")
    List<Service> findBySeacrhTitleDescription(@Param("title") String title, @Param("description") String description);

}

