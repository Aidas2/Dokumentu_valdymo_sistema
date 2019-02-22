package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    //Document findById(Long id);
    //Document getById(Long id);
    //void deleteById(Long id);
    List<Document> findByAuthor(User author);
    List<Document> findByDocumentType(DocumentType documentType);


}
