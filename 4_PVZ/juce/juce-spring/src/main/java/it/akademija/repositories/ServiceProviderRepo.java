package it.akademija.repositories;

import it.akademija.db.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceProviderRepo extends JpaRepository<ServiceProvider, Long> {
    ServiceProvider findOneByTitle(String title);
    void deleteOneByTitle(String title);
    boolean existsByTitle(String title);

}


