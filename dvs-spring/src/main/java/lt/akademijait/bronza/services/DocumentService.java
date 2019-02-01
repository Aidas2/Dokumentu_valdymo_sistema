package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.document.DocumentGetCommand;
import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
//    @Autowired
//    private DocTypeRepository docTypeRepository;
//    @Autowired
//    private UserRepository userRepository;

    //GET ALL
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAll() {
        return documentRepository.findAll()
                .stream()
                .map((document) -> new DocumentGetCommand(
                        document.getId(),
                        document.getAuthor(),
                        document.getDocumentType(),
                        document.getTitle(),
                        document.getDescription(),
                        document.getCreationDate(),
                        document.getSubmissionDate(),
                        document.getConfirmationDate(),
                        document.getRejectionDate(),
                        document.getReviewer(),
                        document.getRejectionReason(),
                        document.getAttachments()
                )).collect(Collectors.toList());
    }

    //FIND BY ID
    @Transactional(readOnly = true)
    public DocumentGetCommand getById(Long id) {
        Document document = documentRepository.findById(id).orElse(null);
        return new DocumentGetCommand(
                document.getId(),
                document.getAuthor(),
                document.getDocumentType(),
                document.getTitle(),
                document.getDescription(),
                document.getCreationDate(),
                document.getSubmissionDate(),
                document.getConfirmationDate(),
                document.getRejectionDate(),
                document.getReviewer(),
                document.getRejectionReason(),
                document.getAttachments()
        );
    }


    //CREATE


    //UPDATE


    //DELETE


}
