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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private  final static Logger logger = LoggerFactory.getLogger(DocumentService.class);
    //private Logger logger = LoggerFactory.getLogger(this.getClass());

    //GET ALL DOCUMENTS ================================================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocuments() {
        logger.info("Gotten all documents");
        return documentRepository.findAll()
                .stream()
                .map((document) -> new DocumentGetCommand(
                        document.getId(),
                        document.getAuthor().getUsername(),
                        document.getDocumentState().toString(),
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

    //GET DOCUMENTS BY DOCUMENT_ID =====================================================================================
    @Transactional(readOnly = true)
    public DocumentGetCommand getDocumentById(Long id) {
        Document document = documentRepository.findById(id).orElse(null);
        logger.info("Gotten all documents by this id: " + id);
        //logger.error("null "); try/catch; luzimo pvz: skirtingi duomenu tipai (Long ir string)
        return new DocumentGetCommand(
                document.getId(),
                document.getAuthor().getUsername(),
                document.getDocumentState().toString(),
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

    //GET SUBMITTED DOCUMENTS (with filter) ============================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getSubmittedDocuments() {
        logger.info("Gotten all documents by this state: " + DocumentState.SUBMITTED);
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentState().equals(DocumentState.SUBMITTED))
                .map((document) -> new DocumentGetCommand(
                        document.getId(),
                        //document.getAuthor(),
                        document.getAuthor().getUsername(),
                        document.getDocumentState().toString(),
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

    //GET CONFIRMED DOCUMENTS (with filter) ============================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getConfirmedDocuments() {
        logger.info("Gotten all documents by this state: " + DocumentState.CONFIRMED);
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentState().equals(DocumentState.CONFIRMED))
                .map((document) -> new DocumentGetCommand(
                        document.getId(),
                        document.getAuthor().getUsername(),
                        document.getDocumentState().toString(),
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

    //GET REJECTED DOCUMENTS (with filter) ============================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getRejectedDocuments() {
        logger.info("Gotten all documents by this state: " + DocumentState.REJECTED);
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentState().equals(DocumentState.REJECTED))
                .map((document) -> new DocumentGetCommand(
                        document.getId(),
                        document.getAuthor().getUsername(),
                        document.getDocumentState().toString(),
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


    //GET DOCUMENTS BY SPECIFIED STATE (with filter) ===========================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByDocumentState(DocumentState documentState) {
        logger.info("Gotten all documents by this state: " + documentState);
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentState().equals(documentState))
                .map((document) -> new DocumentGetCommand(
                        document.getId(),
                        document.getAuthor().getUsername(),
                        document.getDocumentState().toString(),
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

    //GET DOCUMENTS OF SPECIFIC DOCUMENT_TYPE. Version_01 (passing object) ================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByDocumentType1(DocumentType documentType) {
    logger.info("Gotten all documents by this type: " + documentType);
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentType().equals(documentType))
                //.filter(document -> document.getDocumentType().getTitle().equals(documentType.getTitle()))
                .map((document) -> new DocumentGetCommand(
                        document.getId(),
                        document.getAuthor().getUsername(),
                        document.getDocumentState().toString(),
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


    //GET DOCUMENTS OF SPECIFIC DOCUMENT_TYPE. Version_02 (passing String) ====================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByDocumentType2(String documentTypeTitle) {
        logger.info("Gotten all documents by this type: " + documentTypeTitle);
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getDocumentType().equals(documentTypeRepository.findByTitle(documentTypeTitle)))
                .map((document) -> new DocumentGetCommand(
                        document.getId(),
                        document.getAuthor().getUsername(),
                        document.getDocumentState().toString(),
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
    //GET DOCUMENTS OF SPECIFIC USER_GROUP (OR AUTHOR ID ?) ============================================================
    // (with filter and with filter of permissions (which documents this UserGroup can manage)

        @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByAuthorId(Long authorId) {
            logger.info("Gotten all documents by this author id: " + authorId);
        return  documentRepository.findAll()
                .stream()
                .filter(document -> document.getAuthor().getId().equals(authorId))
                .map((document) -> new DocumentGetCommand(
                        document.getId(),
                        document.getAuthor().getUsername(),
                        document.getDocumentState().toString(),
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

    //CREATE ===========================================================================================================
    @Transactional
    public void createDocument(DocumentCreateCommand documentCreateCommand) {

        Document newDocument = new Document();
        newDocument.setCreationDate(new Date());

        User user = userRepository.findByUsername(documentCreateCommand.getUsername());
        if (user == null) {
            logger.error("User not found (when trying to create document");
            throw new ResourceNotFoundException("My dear Friend, you entered not existing User (you should create that User first) !");
        } else {
            newDocument.setAuthor(user);
        }


        DocumentType documentType = documentTypeRepository.findByTitle(documentCreateCommand.getDocumentTypeTitle());
        if (documentType == null) {
            logger.error("DocumentType not found (when trying to create document");
            throw new ResourceNotFoundException("My dear Friend, you entered not existing DocumentType (you should create that DocumentType first) !");
        } else {
            newDocument.setDocumentType(documentType);
        }

        newDocument.setTitle(documentCreateCommand.getTitle());
        newDocument.setDescription(documentCreateCommand.getDescription());
        newDocument.setDocumentState(DocumentState.CREATED);
        documentRepository.save(newDocument);
        logger.info("New document created - {} Everything is OK", newDocument.toString());
    }



    //SET DOCUMENT STATE. Version_01 (by my) ===========================================================================
    @Transactional
    public void setDocumentStateV1 (DocumentSetStateCommand documentSetStateCommand) {


        //Document documentToSetState = documentRepository.findById(id).orElse(null);
        Document documentToSetState = documentRepository.getOne(documentSetStateCommand.getDocumentId());


        User user = userRepository.findByUsername(documentSetStateCommand.getReviewerUsername());


        Set<UserGroup> userGroupsBelongingToUser = user.getUserGroups();
        boolean canSetState = false; //ATENTION: 1. reikia koreguoti si patikrinima, nes nepraeina pro ji (galbut neduoda niekad true)
                                                //2. Rejection reason swageryje isiraso tik kai yra nustatyta paciame pirmame if

        for (UserGroup userGroup : userGroupsBelongingToUser) {
            if (userGroup.getReviewDocumentType().contains(documentToSetState.getDocumentType())) {
                canSetState = true;
                logger.info("User belongs to the group, which can set document state. OK");
                //break;
            } else {
                logger.info("User doesn't belong to the group, which can set document state. No good");
            }
        }

        if(canSetState) {
            documentToSetState.setReviewer(user);
        }

//        Reikia patikrinti, ar Reviewer turi permission acceptinti arba rejectinti.
//         Tą reikia daryti, tikrinant User reviewer kitamąjį List<UserGroup> userGroup.
//         Reikia eiti per kiekvieną listo elementą ir žiūrėti, ar kuris nors iš elementų
//         turi Liste reviewDocumentTYpe būtent tą tipą, kurį jis bando acceptinti arba rejectinti.
//         Jei turi, tada tik leisti setDocumentStatus(rejectet arba accepted priskirti).
//         Ir tik tada priskirti paciam documentEntičiui reviewerį, jei jam leista pakeisti statą.



        //papildyti validacija ar DocumentState jau nera toks koki norim suteikti.

        //papildyti kad jeigu neranda DocumentType tai reikia handlint errora
        // (pvz. iseiti is metodo, arba responseEntity arba ResourceNotFoundException)
        // nes priesingu atveju programa nulus.

        if (canSetState) {
            logger.info("User belongs to the group, which can set document state. OK");
        } else if (canSetState == false) {
            logger.info("User doesn't belong to the group, which can set document state. No good");
        } else if (canSetState &&
                !documentSetStateCommand.getDocumentState().equals(DocumentState.CREATED.name())  //&&
                //documentSetStateCommand.getDocumentState() != DocumentState.SUBMITTED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.CONFIRMED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.REJECTED &&
                //documentToSetState.getRejectionReason() == null
        ) {
            //documentToSetState.setDocumentState(DocumentState.CREATED);     //version A (hardcoded ? Yes, hardcoded because User in UI or swagger cannot choose)
            documentToSetState.setDocumentState(DocumentState.valueOf(documentSetStateCommand.getDocumentState())); //version B
            //documentToSetState.setRejectionReason(documentSetStateCommand.getRejectionReason());
        } else if (canSetState &&
                documentSetStateCommand.getDocumentState().equals(DocumentState.CREATED.name()) //&&
                //documentSetStateCommand.getDocumentState() != DocumentState.SUBMITTED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.CONFIRMED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.REJECTED &&
                //documentToSetState.getRejectionReason() == null
                ) {
            //documentToSetState.setDocumentState(DocumentState.SUBMITTED);   //version A
            documentToSetState.setDocumentState(DocumentState.valueOf(documentSetStateCommand.getDocumentState())); //version B
            //documentToSetState.setRejectionReason(documentSetStateCommand.getRejectionReason());
        } else if (canSetState &&
                //documentSetStateCommand.getDocumentState() == DocumentState.CREATED &&
                documentSetStateCommand.getDocumentState().equals(DocumentState.SUBMITTED.name()) &&
                //documentSetStateCommand.getDocumentState() != DocumentState.CONFIRMED &&
                !documentSetStateCommand.getDocumentState().equals(DocumentState.REJECTED.name()) //&&
                //documentToSetState.getRejectionReason() == null
            ) {
            //documentToSetState.setDocumentState(DocumentState.CONFIRMED);   //version A
            documentToSetState.setDocumentState(documentToSetState.getDocumentState()); //version B
            documentToSetState.setRejectionReason(documentSetStateCommand.getRejectionReason());
        } else if (canSetState &&
                //documentSetStateCommand.getDocumentState() == DocumentState.CREATED &&
                documentSetStateCommand.getDocumentState().equals(DocumentState.SUBMITTED.name()) &&
                !documentSetStateCommand.getDocumentState().equals(DocumentState.CONFIRMED.name()) //&&
                //documentSetStateCommand.getDocumentState() != DocumentState.REJECTED &&
                //documentToSetState.getRejectionReason() != null
        ) {
            //documentToSetState.setDocumentState(DocumentState.REJECTED);    //version A
            documentToSetState.setDocumentState(DocumentState.valueOf(documentSetStateCommand.getDocumentState()));  //version B
            documentToSetState.setRejectionReason(documentSetStateCommand.getRejectionReason());
        } else {
            throw new ResourceNotFoundException("My dear Friend, non of the IF case was proceeded.");
        }

        documentRepository.save(documentToSetState);
        logger.info("Document state set to: " + DocumentState.valueOf(documentSetStateCommand.getDocumentState()));

    }


    //SET DOCUMENT STATE. Version_02 (by J.C.) =========================================================================
    //to make working, change 'private DocumentState documentState' --> 'private String documentState' ((DocumentSetStateCommand.java)
    @Transactional
    public void setDocumentStateV2 ( DocumentSetStateCommand documentSetStateCommand) {

        User user = userRepository.findByUsername(documentSetStateCommand.getAuthorUsername());
        Document documentToSetState = documentRepository.getOne(documentSetStateCommand.getDocumentId());
        User reviewerUser = userRepository.findByUsername(documentSetStateCommand.getReviewerUsername());

        switch (documentSetStateCommand.getDocumentState()){
            case "CREATED":{
                logger.info("User tried to set document state to CREATED");
                throw new ResourceNotFoundException("There is no need to set state to CREATED (this state is already set during document creation).");
            }
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
            case "CONFIRMED" :{
                documentToSetState.setReviewer(reviewerUser);
                documentToSetState.setDocumentState(DocumentState.CONFIRMED);
                documentToSetState.setConfirmationDate(new Date());
                break;
            }
            default:
                throw new ResourceNotFoundException("My dear Friend, non of the SWITCH case was proceeded.");

        }
        documentRepository.save(documentToSetState);
        logger.info("Document state set to: " + documentSetStateCommand.getDocumentState());
    }


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
        logger.info("Document data updated - {} Everything is OK" + documentToUpdate.toString());
    }

    //DELETE ===========================================================================================================
    @Transactional
    public void deleteDocument(long id) {
        documentRepository.deleteById(id);
        logger.info("Document with id = " + id + " was deleted");
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
            throw new ResourceNotFoundException("My dear Friend, you entered not existing DocumentType (you should create that DocumentType first) !");
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
