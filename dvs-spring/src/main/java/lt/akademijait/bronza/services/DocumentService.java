package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.document.DocumentCreateCommand;
import lt.akademijait.bronza.dto.document.DocumentGetCommand;
import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.enums.DocumentState;
import lt.akademijait.bronza.repositories.DocumentRepository;
import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;

    //GET ALL DOCUMENTS
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocuments() {
        return documentRepository.findAll()
                .stream()
                .map((document) -> new DocumentGetCommand(
                        document.getAuthor(),
                        document.getDocumentState(),
                        document.getDocumentType(),
                        document.getTitle(),
                        document.getDescription(),
                        document.getCreationDate(),
                        document.getSubmissionDate(),
                        document.getConfirmationDate(),
                        document.getRejectionDate(),
                        document.getReviewer(),
                        document.getRejectionReason(),
                        document.getPath()
                )).collect(Collectors.toList());
    }

    //GET All SUBMITTED DOCUMENTS (with filter)
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getSubmittedDocuments() {
        return  documentRepository.findAll()
                .stream()
                .filter(document -> !document.getDocumentState().equals(DocumentState.CREATED))
                .map((document) -> new DocumentGetCommand(
                        document.getAuthor(),
                        document.getDocumentState(),
                        document.getDocumentType(),
                        document.getTitle(),
                        document.getDescription(),
                        document.getCreationDate(),
                        document.getSubmissionDate(),
                        document.getConfirmationDate(),
                        document.getRejectionDate(),
                        document.getReviewer(),
                        document.getRejectionReason(),
                        document.getPath()
                )).collect(Collectors.toList());
    }

    //GET All DOCUMENTS TO REVIEW (with filter)
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getDocumentsToReview() {
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentState().equals(DocumentState.SUBMITTED))
                .map((document) -> new DocumentGetCommand(
                        document.getAuthor(),
                        document.getDocumentState(),
                        document.getDocumentType(),
                        document.getTitle(),
                        document.getDescription(),
                        document.getCreationDate(),
                        document.getSubmissionDate(),
                        document.getConfirmationDate(),
                        document.getRejectionDate(),
                        document.getReviewer(),
                        document.getRejectionReason(),
                        document.getPath()
                )).collect(Collectors.toList());
    }

    //GET DOCUMENTS BY ID
    @Transactional(readOnly = true)
    public DocumentGetCommand getDocumentById(Long id) {
        Document document = documentRepository.findById(id).orElse(null);
        return new DocumentGetCommand(
                document.getAuthor(),
                document.getDocumentState(),
                document.getDocumentType(),
                document.getTitle(),
                document.getDescription(),
                document.getCreationDate(),
                document.getSubmissionDate(),
                document.getConfirmationDate(),
                document.getRejectionDate(),
                document.getReviewer(),
                document.getRejectionReason(),
                document.getPath()
        );
    }

    //CREATE
    @Transactional
    public void createDocument(DocumentCreateCommand documentCreateCommand) {

        Document newDocument = new Document();
        newDocument.setCreationDate(new Date());

        User user = userRepository.findByUsername(documentCreateCommand.getUsername());
        if (user == null) {
            throw new ResourceNotFoundException("You should create that User first (and write him in field username) !");
        } else {
            newDocument.setAuthor(user);
        }


        DocumentType documentType = documentTypeRepository.findByTitle(documentCreateCommand.getDocumentTypeTitle());
        if (documentType == null) {
            throw new ResourceNotFoundException("You should create that DocymentType first (and write him in field documentTypeTitle) !");
        }
        newDocument.setDocumentType(documentType);

        newDocument.setTitle(documentCreateCommand.getTitle());
        newDocument.setDescription(documentCreateCommand.getDescription());
        documentRepository.save(newDocument);
    }

    //SUBMITT ?



    //UPDATE
    @Transactional
    public void updateDocument (Long id, DocumentCreateCommand documentCreateCommand) {
        Document documentToUpdate = documentRepository.findById(id).orElse(null);

        User user = userRepository.findByUsername(documentCreateCommand.getUsername());
        documentToUpdate.setAuthor(user);

        DocumentType documentType = documentTypeRepository.findByTitle(documentCreateCommand.getDocumentTypeTitle());
        documentToUpdate.setDocumentType(documentType);


        documentToUpdate.setTitle(documentCreateCommand.getTitle());
        documentToUpdate.setDescription(documentCreateCommand.getDescription());
        //documentToUpdate.setId(id);
        documentRepository.save(documentToUpdate);
    }
/*
    //CREATE (old version, not working)
    @Transactional
    public void createDocument(DocumentCreateCommand documentCreateCommand) {
        documentRepository.save(new Document(
           documentCreateCommand.getAuthor(),
           documentCreateCommand.getDocumentType(),
           documentCreateCommand.getTitle(),
           documentCreateCommand.getDescription()
        ));
    }


    //UPDATE (old version, not working)
    @Transactional
    public void updateDocument (Long id, DocumentCreateCommand documentCreateCommand) {
        Document document = documentRepository.findById(id).orElse(null);
        Document updatedDocument = new Document(
                documentCreateCommand.getAuthor(),
                documentCreateCommand.getDocumentType(),
                documentCreateCommand.getTitle(),
                documentCreateCommand.getDescription()
        );
        updatedDocument.setId(id);
        documentRepository.save(updatedDocument);
    }
*/

    //DELETE
    @Transactional
    public void deleteDocument(long id) {
        documentRepository.deleteById(id);
    }

}
