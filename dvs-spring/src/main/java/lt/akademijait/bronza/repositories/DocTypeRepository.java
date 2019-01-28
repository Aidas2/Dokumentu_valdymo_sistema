package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.DocType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocTypeRepository extends JpaRepository<DocType, Long> {
    DocType findByTitle(String title);
    void deleteByTitle(String title);
}
