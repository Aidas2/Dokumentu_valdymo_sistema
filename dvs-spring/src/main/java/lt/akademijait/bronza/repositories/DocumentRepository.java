package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    //Document findById(Long id);
    //void deleteById(Long id);


}
