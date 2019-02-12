package lt.akademijait.bronza.repositories;


import lt.akademijait.bronza.entities.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    DocumentType findByTitle(String title);
    //void deleteByTitle(String title);
}
