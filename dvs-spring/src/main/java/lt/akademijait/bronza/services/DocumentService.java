package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.document.DocumentCreateCommand;
import lt.akademijait.bronza.dto.document.DocumentGetCommand;
import lt.akademijait.bronza.dto.document.DocumentSetStateCommand;
import lt.akademijait.bronza.dto.document.DocumentUpdateCommand;
import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.entities.UserGroup;
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
import java.util.Set;
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

    //GET ALL DOCUMENTS ================================================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocuments() {
        return documentRepository.findAll()
                .stream()
                .map((document) -> new DocumentGetCommand(
                        document.getAuthor().getUsername(),
                        document.getDocumentState(),
                        document.getDocumentType().getTitle(),
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

    //GET DOCUMENTS BY ID ==============================================================================================
    @Transactional(readOnly = true)
    public DocumentGetCommand getDocumentById(Long id) {
        Document document = documentRepository.findById(id).orElse(null);
        return new DocumentGetCommand(
                document.getAuthor().getUsername(),
                document.getDocumentState(),
                document.getDocumentType().getTitle(),
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

    //GET All SUBMITTED DOCUMENTS (with filter) ========================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getSubmittedDocuments() {
        return  documentRepository.findAll()
                .stream()
                .filter(document -> !document.getDocumentState().equals(DocumentState.CREATED))
                .map((document) -> new DocumentGetCommand(
                        //document.getAuthor(),
                        document.getAuthor().getUsername(),
                        document.getDocumentState(),
                        document.getDocumentType().getTitle(),
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

    //GET All DOCUMENTS TO REVIEW (with filter) ========================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getDocumentsToReview() {
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentState().equals(DocumentState.SUBMITTED))
                .map((document) -> new DocumentGetCommand(
                        document.getAuthor().getUsername(),
                        document.getDocumentState(),
                        document.getDocumentType().getTitle(),
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

    //GET All DOCUMENTS OF SPECIFIC DOCUMENT_STATE (with filter) =======================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByDocumentState(DocumentState documentState) {
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentState().equals(documentState))
                .map((document) -> new DocumentGetCommand(
                        document.getAuthor().getUsername(),
                        document.getDocumentState(),
                        document.getDocumentType().getTitle(),
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

    //GET All DOCUMENTS OF SPECIFIC DOCUMENT_TYPE (with filter) ========================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByDocumentType(DocumentType documentType) {
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentType().equals(documentType))
                .map((document) -> new DocumentGetCommand(
                        document.getAuthor().getUsername(),
                        document.getDocumentState(),
                        document.getDocumentType().getTitle(),
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



    //GET All DOCUMENTS OF SPECIFIC USER_GROUP =========================================================================
    // (with filter and with filter of permissions (which documents this UserGroup can manage)

    // attach loggers everywhere !






    //CREATE ===========================================================================================================
    @Transactional
    public void createDocument(DocumentCreateCommand documentCreateCommand) {

        Document newDocument = new Document();
        newDocument.setCreationDate(new Date());

        User user = userRepository.findByUsername(documentCreateCommand.getUsername());
        if (user == null) {
            throw new ResourceNotFoundException("My dear Friend, you entered not existing User (you should create that User first) !");
        } else {
            newDocument.setAuthor(user);
        }


        DocumentType documentType = documentTypeRepository.findByTitle(documentCreateCommand.getDocumentTypeTitle());
        if (documentType == null) {
            throw new ResourceNotFoundException("My dear Friend, you entered not existing DocumentType (you should create that DocymentType first) !");
        } else {
            newDocument.setDocumentType(documentType);
        }

        newDocument.setTitle(documentCreateCommand.getTitle());
        newDocument.setDescription(documentCreateCommand.getDescription());
        newDocument.setDocumentState(DocumentState.CREATED);
        documentRepository.save(newDocument);
    }


    //SET DOCUMENT STATE. Version_01 (by my) ===========================================================================
    @Transactional
    public void setDocumentState (Long id, DocumentSetStateCommand documentSetStateCommand) {

        Document documentToSetState = documentRepository.findById(id).orElse(null);

        User user = userRepository.findByUsername(documentSetStateCommand.getReviewerUsername());


        Set<UserGroup> userGroupsBelongingToUser = user.getUserGroups();
        boolean canSetState = false;

        for (UserGroup userGroup : userGroupsBelongingToUser) {
            if (userGroup.getReviewDocumentType().contains(documentToSetState.getDocumentType())) {
                canSetState = true;
                break;
            }
        }

        if(canSetState) {
            documentToSetState.setReviewer(user);
        }
        /*
        2. Reikia patikrinti, ar Reviewer turi permission acceptinti arba rejectinti.
         Tą reikia daryti, tikrinant User reviewer kitamąjį List<UserGroup> userGroup.
         Reikia eiti per kiekvieną listo elementą ir žiūrėti, ar kuris nors iš elementų
         turi Liste reviewDocumentTYpe būtent tą tipą, kurį jis bando acceptinti arba rejectinti.
         Jei turi, tada tik leisti setDocumentStatus(rejectet arba accepted priskirti).
         Ir tik tada priskirti paciam documentEntičiui reviewerį, jei jam leista pakeisti statą.
         */


        //papildyti validacija ar DocumentState jau nera toks koki norim suteikti.

        //papildyti kad jeigu neranda DocumentType tai reikia handlint errora
        // (pvz. iseiti is metodo, arba responseEntity arba ResourceNotFoundException)
        // nes priesingu atveju programa nulus.

        if (canSetState &&
                documentSetStateCommand.getDocumentState() != DocumentState.CREATED //&&
                //documentSetStateCommand.getDocumentState() != DocumentState.SUBMITTED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.CONFIRMED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.REJECTED &&
                //documentToSetState.getRejectionReason() == null
        ) {
            //documentToSetState.setDocumentState(DocumentState.CREATED);     //version A (hardcoded ? Yes, hardcoded because User in UI or swagger cannot choose)
            documentToSetState.setDocumentState(documentSetStateCommand.getDocumentState()); //version B
        } else if (canSetState &&
                documentSetStateCommand.getDocumentState() == DocumentState.CREATED //&&
                //documentSetStateCommand.getDocumentState() != DocumentState.SUBMITTED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.CONFIRMED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.REJECTED &&
                //documentToSetState.getRejectionReason() == null
                ) {
            //documentToSetState.setDocumentState(DocumentState.SUBMITTED);   //version A
            documentToSetState.setDocumentState(documentSetStateCommand.getDocumentState()); //version B
        } else if (canSetState &&
                //documentSetStateCommand.getDocumentState() == DocumentState.CREATED &&
                documentSetStateCommand.getDocumentState() == DocumentState.SUBMITTED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.CONFIRMED &&
                documentSetStateCommand.getDocumentState() != DocumentState.REJECTED //&&
                //documentToSetState.getRejectionReason() == null
            ) {
            //documentToSetState.setDocumentState(DocumentState.CONFIRMED);   //version A
            documentToSetState.setDocumentState(documentToSetState.getDocumentState()); //version B
        } else if (canSetState &&
                //documentSetStateCommand.getDocumentState() == DocumentState.CREATED &&
                documentSetStateCommand.getDocumentState() == DocumentState.SUBMITTED &&
                documentSetStateCommand.getDocumentState() != DocumentState.CONFIRMED //&&
                //documentSetStateCommand.getDocumentState() != DocumentState.REJECTED &&
                //documentToSetState.getRejectionReason() != null
        ) {
            //documentToSetState.setDocumentState(DocumentState.REJECTED);    //version A
            documentToSetState.setDocumentState(documentSetStateCommand.getDocumentState());  //version B
            documentToSetState.setRejectionReason(documentSetStateCommand.getRejectionReason());
        }

        documentRepository.save(documentToSetState);
    }

/*
    //SET DOCUMENT STATE. Version_02 (by J.C.) =========================================================================
    //to make working, change 'private DocumentState documentState' --> 'private String documentState' ((DocumentSetStateCommand.java)
    @Transactional
    public void setDocumentState2 ( DocumentSetStateCommand documentSetStateCommand) {

        User user = userRepository.findByUsername(documentSetStateCommand.getAuthorUsername());
        Document documentToSetState = documentRepository.getOne(documentSetStateCommand.getDocumentId());
        User reviewerUser = userRepository.findByUsername(documentSetStateCommand.getReviewerUsername());

        switch (documentSetStateCommand.getDocumentState()){
            case "SUBMITTED" :{
                documentToSetState.setDocumentState(DocumentState.SUBMITTED);
                documentToSetState.setSubmissionDate(new Date());
                break;

            }
            case "REJECTED" :{
                documentToSetState.setReviewer(reviewerUser);
                documentToSetState.setDocumentState(DocumentState.REJECTED);
                documentToSetState.setRejectionDate(new Date());
                documentToSetState.setRejectionReason(documentSetStateCommand.getRejectionReason());

                break;
            }
            case "COMFIRMED" :{
                documentToSetState.setReviewer(reviewerUser);
                documentToSetState.setDocumentState(DocumentState.CONFIRMED);
                documentToSetState.setConfirmationDate(new Date());
            }
        }
    }
*/

/*
    //UPDATE. Version_01. ==============================================================================================
    // Commented, because is not logical to update username  + it should be DocumentUpdateCommand used.
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
*/

    //UPDATE. Version_02. ==============================================================================================
    @Transactional
    public void updateDocument (Long id, DocumentUpdateCommand documentUpdateCommand) {
        Document documentToUpdate = documentRepository.findById(id).orElse(null);

        DocumentType documentType = documentTypeRepository.findByTitle(documentUpdateCommand.getDocumentTypeTitle());
        documentToUpdate.setDocumentType(documentType);


        documentToUpdate.setTitle(documentUpdateCommand.getTitle());
        documentToUpdate.setDescription(documentUpdateCommand.getDescription());
        documentRepository.save(documentToUpdate);
    }

    //DELETE ===========================================================================================================
    @Transactional
    public void deleteDocument(long id) {
        documentRepository.deleteById(id);
    }

/*
    // commented as not necessary (?);
    // dar reikia paduoti username kad patikrinti ar jis turi permission'a
    // tada paduoti setDocumentState
    //ASSIGN DOCUMENT_TYPE TO DOCUMENT =================================================================================
    @Transactional
    public void assignDocumentTypeToDocument(Long id, String title) {
        //DocumentType documentType = documentTypeRepository.findById(id).orElseThrow(null);
        DocumentType documentType = documentTypeRepository.findByTitle(title);
        Document document = documentRepository.findById(id).orElse(null);
        if (documentType == null) {
            throw new ResourceNotFoundException("My dear Friend, you entered not existing DocumentType (you should create that DocymentType first) !");
        } else {
            //documentType.getDocuments().add(document); //
            document.setDocumentType(documentType); //jei norim pakeisti tai tiesiog settini is naujo (.remove nereikia).
        }
    }

    //DE-ASSIGN DOCUMENT_TYPE TO DOCUMENT ==============================================================================
    @Transactional
    public void deassignDocumentTypeToDocument(Long id, String title) {
        //DocumentType documentType = documentTypeRepository.findById(id).orElseThrow(null);
        DocumentType documentType = documentTypeRepository.findByTitle(title);
        Document document = documentRepository.findById(id).orElse(null);
        if (documentType == null) {
            throw new ResourceNotFoundException("My dear Friend, you entered not existing DocumentType (you should create that DocymentType first) !");
        } else {
            documentType.getDocuments().remove(document);
        }
    }
*/

}
