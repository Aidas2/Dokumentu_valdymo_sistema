package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository <Attachment, Long> {

    Attachment findByTitle (String title);

}
