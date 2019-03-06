package lt.akademijait.bronza.services;

import lombok.extern.slf4j.Slf4j;
import lt.akademijait.bronza.dto.documenttype.DocumentTypeCreateCommand;
import lt.akademijait.bronza.dto.documenttype.DocumentTypeGetCommand;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    //private  final static Logger logger = LoggerFactory.getLogger(DocumentTypeService.class);
    //private Logger logger = LoggerFactory.getLogger(this.getClass());

    //GET ALL ==========================================================================================================
    @Transactional(readOnly = true)
    public List<DocumentTypeGetCommand> getDocumentTypes() {
        log.info("Geted all document types");
        return documentTypeRepository.findAll()
                .stream()
                .map((documentType) -> new DocumentTypeGetCommand(
                        documentType.getId(),
                        documentType.getTitle()
                )).collect(Collectors.toList());
    }

    //GET BY ID ========================================================================================================
    @Transactional(readOnly = true)
    public DocumentTypeGetCommand getDocumentTypeById(Long id) {
        DocumentType documentType = documentTypeRepository.findById(id).orElse(null);
        log.info("Geted all document types by this id: " + id);
        return new DocumentTypeGetCommand(
                    documentType.getId(),
                    documentType.getTitle()
        );
    }

    //GET BY TITLE =====================================================================================================
    @Transactional(readOnly = true)
    public DocumentTypeGetCommand getDocumentsTypeByTitle(String title) {
        DocumentType documentType = documentTypeRepository.findByTitle(title);
        log.info("Geted all document types by this title: " + title);
        return new DocumentTypeGetCommand(
                documentType.getId(),
                documentType.getTitle()
        );
    }

    //CREATE ===========================================================================================================
    //galbut nereikia  kurti getId
    @Transactional
    public void createDocumentType (DocumentTypeCreateCommand documentTypeCreateCommand) {
        DocumentType newDocumentType = new DocumentType();
        //newDocumentType.setId(documentTypeCreateCommand.getId());
        newDocumentType.setTitle(documentTypeCreateCommand.getTitle());
        documentTypeRepository.save(newDocumentType);
        log.info("New document type created - {} Everything is OK", documentTypeCreateCommand.getTitle());
    }

    //UPDATE ===========================================================================================================
    @Transactional
    public void updateDocumentType (Long id, DocumentTypeCreateCommand documentTypeCreateCommand) {
        DocumentType documentTypeToUpdate = documentTypeRepository.findById(id).orElseThrow(null);
        //documentTypeToUpdate.setId(documentTypeCreateCommand.getId());
        documentTypeToUpdate.setTitle(documentTypeCreateCommand.getTitle());
        //documentTypeToUpdate.setId(id);
        documentTypeRepository.save(documentTypeToUpdate);
        log.info("Document type updated to - {} Everything is OK", documentTypeCreateCommand.getTitle());
    }

    //DELETE ===========================================================================================================
    @Transactional
    public void deleteDocumentType (Long id) {
        documentTypeRepository.deleteById(id);
        log.info("Document type with id = " + id + " was deleted");
    }

}
