package lt.akademijait.bronza.services;

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
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    //GET
    @Transactional(readOnly = true)
    public List<DocumentTypeGetCommand> getDocumentTypes() {
        return documentTypeRepository.findAll()
                .stream()
                .map((documentType) -> new DocumentTypeGetCommand(
                        documentType.getId(),
                        documentType.getTitle()
                )).collect(Collectors.toList());
    }

    //GET BY ID
    @Transactional(readOnly = true)
    public DocumentTypeGetCommand getDocumentsTypeById(Long id) {
        DocumentType documentType = documentTypeRepository.findById(id).orElseThrow(null);
        return new DocumentTypeGetCommand(
                    documentType.getId(),
                    documentType.getTitle()
        );
    }

    //CREATE
    //galbut nereikia  kurti getId
    @Transactional
    public void createDocumentType (DocumentTypeCreateCommand documentTypeCreateCommand) {
        DocumentType newDocumentType = new DocumentType();
        newDocumentType.setId(documentTypeCreateCommand.getId());
        newDocumentType.setTitle(documentTypeCreateCommand.getTitle());
        documentTypeRepository.save(newDocumentType);
    }

    //UPDATE
    @Transactional
    public void updateDocumentType (Long id, DocumentTypeCreateCommand documentTypeCreateCommand) {
        DocumentType documentTypeToUpdate = documentTypeRepository.findById(id).orElseThrow(null);
        documentTypeToUpdate.setId(documentTypeCreateCommand.getId());
        documentTypeToUpdate.setTitle(documentTypeCreateCommand.getTitle());
        //documentTypeToUpdate.setId(id);
        documentTypeRepository.save(documentTypeToUpdate);
    }

/*
    //CREATE (old version, not working)
    @Transactional
    public void createDocumentType (DocumentTypeCreateCommand documentTypeCreateCommand) {
        documentTypeRepository.save(new DocumentType (
                documentTypeCreateCommand.getId(),
                documentTypeCreateCommand.getTitle()
        ));
    }


    //UPDATE (old version, not working)
    @Transactional
    public void updateDocumentType (Long id, DocumentTypeCreateCommand documentTypeCreateCommand) {
        DocumentType documentType = documentTypeRepository.findById(id).orElseThrow(null);
        DocumentType updatedDocumentType = new DocumentType(
          documentTypeCreateCommand.getId(),
          documentTypeCreateCommand.getTitle()
        );
        updatedDocumentType.setId(id);
        documentTypeRepository.save(updatedDocumentType);
    }
*/
    //DELETE
    @Transactional
    public void deleteDocumentType (Long id) {
        documentTypeRepository.deleteById(id);
    }

}
