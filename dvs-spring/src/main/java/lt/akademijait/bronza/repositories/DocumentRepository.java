package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    //Document findById(Long id);
    //Document getById(Long id);
    //void deleteById(Long id);


}
