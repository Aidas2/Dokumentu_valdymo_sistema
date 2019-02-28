package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.documenttype.DocumentTypeCreateCommand;
import lt.akademijait.bronza.dto.documenttype.DocumentTypeGetCommand;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    private  final static Logger logger = LoggerFactory.getLogger(DocumentTypeService.class);
    //private Logger logger = LoggerFactory.getLogger(this.getClass());

    //GET ALL ==========================================================================================================
    @Transactional(readOnly = true)
    public List<DocumentTypeGetCommand> getDocumentTypes() {
        logger.info("Geted all document types");
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
        logger.info("Geted all document types by this id: " + id);
        return new DocumentTypeGetCommand(
                    documentType.getId(),
                    documentType.getTitle()
        );
    }

    //GET BY TITLE =====================================================================================================
    @Transactional(readOnly = true)
    public DocumentTypeGetCommand getDocumentsTypeByTitle(String title) {
        DocumentType documentType = documentTypeRepository.findByTitle(title);
        logger.info("Geted all document types by this title: " + title);
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
        logger.info("New document type created - {} Everything is OK", documentTypeCreateCommand.getTitle());
    }

    //UPDATE ===========================================================================================================
    @Transactional
    public void updateDocumentType (Long id, DocumentTypeCreateCommand documentTypeCreateCommand) {
        DocumentType documentTypeToUpdate = documentTypeRepository.findById(id).orElseThrow(null);
        //documentTypeToUpdate.setId(documentTypeCreateCommand.getId());
        documentTypeToUpdate.setTitle(documentTypeCreateCommand.getTitle());
        //documentTypeToUpdate.setId(id);
        documentTypeRepository.save(documentTypeToUpdate);
        logger.info("Document type updated to - {} Everything is OK", documentTypeCreateCommand.getTitle());
    }

    //DELETE ===========================================================================================================
    @Transactional
    public void deleteDocumentType (Long id) {
        documentTypeRepository.deleteById(id);
        logger.info("Document type with id = " + id + " was deleted");
    }

}
