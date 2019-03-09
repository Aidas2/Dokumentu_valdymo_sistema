package lt.akademijait.bronza.services;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;

    //private  final static Logger logger = LoggerFactory.getLogger(DocumentService.class);
    //private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
    //GET ALL DOCUMENTS V1 (by P.C.) ====================================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocuments() {
        log.info("Gotten all documents");

        List<DocumentGetCommand> allDocuments = new ArrayList<>();
        for (Document document : documentRepository.findAll()) {
            String reviewerUsername = null;
            if (document.getReviewer() != null) {
                reviewerUsername = document.getReviewer().getUsername();
            }
            allDocuments.add(new DocumentGetCommand(
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
                    reviewerUsername,
                    document.getRejectionReason(),
                    document.getPath(),
                    document.getAttachments()));
        }


//        return documentRepository.findAll()
//                .stream()
//                .map((document) -> new DocumentGetCommand(
//                        document.getId(),
//                        document.getAuthor().getUsername(),
//                        document.getDocumentState().toString(),
//                        document.getDocumentType().getTitle(),
//                        document.getTitle(),
//                        document.getDescription(),
//                        document.getCreationDate(),
//                        document.getSubmissionDate(),
//                        document.getConfirmationDate(),
//                        document.getRejectionDate(),
//
//                        document.getReviewer().getUsername(),
//                        document.getRejectionReason(),
//                        document.getPath(),
//                        document.getAttachments()
//                )).collect(Collectors.toList());
        return allDocuments;


    }
*/
    //if there is a need to filter:
    // version A: insert if (username == current userName) --> then do some action
    // version B: allDocuments.filter()
    // version C: use ternary if operator (line 151) and optional use
    // look in DocumentGetCommand, line 59-63 (separate method getReviewer() );


    //GET ALL DOCUMENTS V2 (by G.G.) ===================================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocuments() {
        log.info("Gotten all documents");
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
                        document.getReviewer() != null ? document.getReviewer().getUsername() : null,
                        document.getRejectionReason(),
                        document.getPath(),
                        document.getAttachments()
                )).collect(Collectors.toList());


    }

    /*
    //GET DOCUMENTS BY DOCUMENT_ID V1 (by P.C.) ========================================================================
    @Transactional(readOnly = true)
    public DocumentGetCommand getDocumentById(Long id) {
        Document document = documentRepository.findById(id).orElse(null);
        log.info("Gotten all documents by this id: " + id);
        //logger.error("null "); try/catch; luzimo pvz: skirtingi duomenu tipai (Long ir string)
        String reviewerUsername = null;
        if (document.getReviewer() != null) {
            reviewerUsername = document.getReviewer().getUsername();
        }
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
                reviewerUsername, document.getRejectionReason(),
                document.getPath(),
                document.getAttachments()
        );
    }
*/

    //GET DOCUMENTS BY DOCUMENT_ID V2 (by G.G.) ========================================================================
    @Transactional(readOnly = true)
    public DocumentGetCommand getDocumentById(Long id) {
        Document document = documentRepository.findById(id).orElse(null);
        log.info("Gotten all documents by this id: " + id);
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
                document.getReviewer() != null ? document.getReviewer().getUsername() : null,
                document.getRejectionReason(),
                document.getPath(),
                document.getAttachments()
        );
    }


    //GET SUBMITTED DOCUMENTS (with filter) ============================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getSubmittedDocuments() {
        log.info("Gotten all documents by this state: " + DocumentState.SUBMITTED);
        return documentRepository.findAll()
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
                        document.getReviewer() != null ? document.getReviewer().getUsername() : null,
                        document.getRejectionReason(),
                        document.getPath(),
                        document.getAttachments()
                )).collect(Collectors.toList());
    }

    //

    //GET CONFIRMED DOCUMENTS (with filter) ============================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getConfirmedDocuments() {
        log.info("Gotten all documents by this state: " + DocumentState.CONFIRMED);
        return documentRepository.findAll()
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
                        document.getReviewer() != null ? document.getReviewer().getUsername() : null,
                        document.getRejectionReason(),
                        document.getPath(),
                        document.getAttachments()
                )).collect(Collectors.toList());
    }

    //GET REJECTED DOCUMENTS (with filter) ============================================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getRejectedDocuments() {
        log.info("Gotten all documents by this state: " + DocumentState.REJECTED);
        return documentRepository.findAll()
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
                        document.getReviewer() != null ? document.getReviewer().getUsername() : null,
                        document.getRejectionReason(),
                        document.getPath(),
                        document.getAttachments()
                )).collect(Collectors.toList());
    }


    //GET DOCUMENTS BY SPECIFIED STATE (with filter) ===========================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByDocumentState(DocumentState documentState) {
        log.info("Gotten all documents by this state: " + documentState);
        return documentRepository.findAll()
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
                        document.getReviewer() != null ? document.getReviewer().getUsername() : null,
                        document.getRejectionReason(),
                        document.getPath(),
                        document.getAttachments()
                )).collect(Collectors.toList());
    }

    //GET DOCUMENTS OF SPECIFIC DOCUMENT_TYPE. Version_01 (passing object) ================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByDocumentType1(DocumentType documentType) {
        log.info("Gotten all documents by this type: " + documentType);
        return documentRepository.findAll()
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
                        document.getReviewer() != null ? document.getReviewer().getUsername() : null,
                        document.getRejectionReason(),
                        document.getPath(),
                        document.getAttachments()
                )).collect(Collectors.toList());
    }


    //GET DOCUMENTS OF SPECIFIC DOCUMENT_TYPE. Version_02 (passing String) ====================================================
    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByDocumentType2(String documentTypeTitle) {
        log.info("Gotten all documents by this type: " + documentTypeTitle);
        return documentRepository.findAll()
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
                        document.getReviewer() != null ? document.getReviewer().getUsername() : null,
                        document.getRejectionReason(),
                        document.getPath(),
                        document.getAttachments()
                )).collect(Collectors.toList());
    }
    //GET DOCUMENTS OF SPECIFIC USER_GROUP (OR AUTHOR ID ?) ============================================================
    // (with filter and with filter of permissions (which documents this UserGroup can manage)

    @Transactional(readOnly = true)
    public List<DocumentGetCommand> getAllDocumentsByAuthorId(Long authorId) {
        log.info("Gotten all documents by this author id: " + authorId);
        return documentRepository.findAll()
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
                        document.getReviewer() != null ? document.getReviewer().getUsername() : null,
                        document.getRejectionReason(),
                        document.getPath(),
                        document.getAttachments()
                )).collect(Collectors.toList());
    }

    //CREATE ===========================================================================================================
    @Transactional
    public void createDocument(DocumentCreateCommand documentCreateCommand) {

        Document newDocument = new Document();
        newDocument.setCreationDate(new Date());

        User user = userRepository.findByUsername(documentCreateCommand.getUsername());
        if (user == null) {
            log.error("User not found (when trying to create document");
            throw new ResourceNotFoundException("My dear Friend, you entered not existing User (you should create that User first) !");
        } else {
            newDocument.setAuthor(user);
        }


        DocumentType documentType = documentTypeRepository.findByTitle(documentCreateCommand.getDocumentTypeTitle());
        if (documentType == null) {
            log.error("DocumentType not found (when trying to create document");
            throw new ResourceNotFoundException("My dear Friend, you entered not existing DocumentType (you should create that DocumentType first) !");
        } else {
            newDocument.setDocumentType(documentType);
        }

        newDocument.setTitle(documentCreateCommand.getTitle());
        newDocument.setDescription(documentCreateCommand.getDescription());
        newDocument.setDocumentState(DocumentState.CREATED);
        documentRepository.save(newDocument);
        log.info("New document created - {} Everything is OK", newDocument.toString());
    }

/*
    //SET DOCUMENT STATE. Version_01 (by my) ===========================================================================
    @Transactional
    public void setDocumentStateV1(DocumentSetStateCommand documentSetStateCommand) {

        //Document documentToSetState = documentRepository.findById(id).orElse(null);
        Document documentToSetState = documentRepository.getOne(documentSetStateCommand.getDocumentId());
        User reviewerUser = userRepository.findByUsername(documentSetStateCommand.getReviewerUsername());

//          Reikia patikrinti, ar Reviewer turi permission acceptinti arba rejectinti.
//         Tą reikia daryti, tikrinant User reviewer kitamąjį List<UserGroup> userGroup.
//         Reikia eiti per kiekvieną listo elementą ir žiūrėti, ar kuris nors iš elementų
//         turi Liste reviewDocumentTYpe būtent tą tipą, kurį jis bando acceptinti arba rejectinti.
//         Jei turi, tada tik leisti setDocumentStatus(rejectet arba accepted priskirti).
//         Ir tik tada priskirti paciam documentEntičiui reviewerį, jei jam leista pakeisti statą.

        // checking if user have permission to set state:
        Set<UserGroup> userGroupsBelongingToUser = reviewerUser.getUserGroups();
        boolean canSetState = false;
        for (UserGroup userGroup : userGroupsBelongingToUser) {
            if (userGroup.getReviewDocumentType().contains(documentToSetState.getDocumentType())) {
                canSetState = true;
                log.info("Checked if user can review document. Positive (yes, he can).");
            }
        }

        // setting checked user as reviewer:
//        if(canSetState) {
//            documentToSetState.setReviewer(reviewerUser);
//            log.info("Checked if user can review document. Positive (yes, he can).");
//        } else {
//            log.info("Checked if user can review document. Negative (No, he can't).");
//        }

        //checking if document already have that state, which we want to set:
        if (canSetState &&
                !documentSetStateCommand.getDocumentState().equals(documentToSetState.getDocumentState().toString())) {
            log.info("Document new state differs from old state. Operation wil bee proceeded.");
            documentToSetState.setReviewer(reviewerUser);
            log.info("Checked if user can review document. Positive (yes, he can).");
            documentToSetState.setDocumentState(DocumentState.valueOf(documentSetStateCommand.getDocumentState())); //version B
            documentToSetState.setRejectionReason(documentSetStateCommand.getRejectionReason());
            log.info("Document state set to: " + DocumentState.valueOf(documentSetStateCommand.getDocumentState()));
            documentRepository.save(documentToSetState);
            log.info("Document with new state saved to repository");
        } else {
            log.info("Document already have this state. Operation not proceeded.");
            throw new ResourceNotFoundException("My dear Friend, Document already have this state.");
        }

        /*  //old version, do not use (working not corectly)
        if (canSetState &&
                !documentSetStateCommand.getDocumentState().equals(DocumentState.CREATED.name())  //&&
                //documentSetStateCommand.getDocumentState() != DocumentState.SUBMITTED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.CONFIRMED &&
                //documentSetStateCommand.getDocumentState() != DocumentState.REJECTED &&
                //documentToSetState.getRejectionReason() == null
        ) {
            //documentToSetState.setDocumentState(DocumentState.CREATED);     //version A (hardcoded ? Yes, hardcoded because User in UI or swagger cannot choose)
            documentToSetState.setDocumentState(DocumentState.valueOf(documentSetStateCommand.getDocumentState())); //version B
            //documentToSetState.setRejectionReason(documentSetStateCommand.getRejectionReason());
            log.info("1-st IF: Document state set to: " + DocumentState.valueOf(documentSetStateCommand.getDocumentState()));
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
            log.info("2-nd IF: Document state set to: " + DocumentState.valueOf(documentSetStateCommand.getDocumentState()));
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
            log.info("3rd IF: Document state set to: " + DocumentState.valueOf(documentSetStateCommand.getDocumentState()));
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
            log.info("4th IF: Document state set to: " + DocumentState.valueOf(documentSetStateCommand.getDocumentState()));
        } else {
            log.info("5th IF: non of the IF case was proceeded.");
            throw new ResourceNotFoundException("My dear Friend, non of the IF case was proceeded.");

        }

        documentRepository.save(documentToSetState);
        log.info("Last logger: Document state set to: " + DocumentState.valueOf(documentSetStateCommand.getDocumentState()));


    }
*/

    //SET DOCUMENT STATE. Version_02 (by J.C.) =========================================================================
    @Transactional
    public void setDocumentStateV2(DocumentSetStateCommand documentSetStateCommand) {

        //User user = userRepository.findByUsername(documentSetStateCommand.getAuthorUsername());
        Document documentToSetState = documentRepository.getOne(documentSetStateCommand.getDocumentId());
        User reviewerUser = userRepository.findByUsername(documentSetStateCommand.getReviewerUsername());

        // checking if user can set state:
        Set<UserGroup> userGroupsBelongingToUser = reviewerUser.getUserGroups();

        boolean canSetState = false;
        for (UserGroup userGroup : userGroupsBelongingToUser) {

            // patikrinimas ar useris nurodytas/ivestas, nifiga nepagauna :(
            if (reviewerUser == null) {
                log.info("My dear Friend, you haven't entered valid username");
                throw new ResourceNotFoundException("My dear Friend, you haven't entered valid username");

                //patikrinimas ar grupei yra priskirtas tas dokumento tipas, kuriam planuojama keisti bukle. Su || leidzia accepinti/rejectinti bet kam :(
            } else if (userGroup.getReviewDocumentType().contains(documentToSetState.getDocumentType()) ||
                    userGroup.getSubmissionDocumentType().contains(documentToSetState.getDocumentType())) {
                log.info("Yes, this UserGroup can submit/review this type of document");
                canSetState = true;
            }
        }

        //jei esama state yra REJECTED arba ACCEPTED  tai nustatyti kad keisti bukles nebegalima (pvz. iseiti is metodo)
        //arba nustatyti kad galima keisti tik jei esama bukle yra CONFIRMED

        //jei esama state yra CREATED, o siuloma bukle nera SUBMITED tai nustatyti kad keisti bukles nebegalima (pvz. iseiti is metodo)
        ///arba nustatyti kad galima keisti tik jei siuloma bukle yra CONFIRMED

        //jei yra SUBMITED, o siuloma bukle nera REJECTED || CONFIRMED tai nustatyti kad keisti bukles nebegalima (pvz. iseiti is metodo;


        // setting checked user as reviewer:
        if (canSetState) {

            switch (documentSetStateCommand.getDocumentState()) {
                case "CREATED": {
                    log.info("C1. Not proceeded. User tried to set document state to CREATED");
                    throw new ResourceNotFoundException("C1. User tried to set document state to CREATED");
                }
                case "SUBMITTED": {
                    if (documentToSetState.getDocumentState().equals(DocumentState.CREATED)) {
                        documentToSetState.setDocumentState(DocumentState.SUBMITTED);
                        documentToSetState.setSubmissionDate(new Date());
                        break;
                    } else {
                        log.info("C2. Not proceeded. Document state must be CREATED");
                        throw new ResourceNotFoundException("C2. Not proceeded. Document state must be CREATED");
                    }
                }
                case "REJECTED": {
                    if (documentToSetState.getDocumentState().equals(DocumentState.SUBMITTED)) {
                        documentToSetState.setReviewer(reviewerUser);
                        documentToSetState.setDocumentState(DocumentState.REJECTED);
                        documentToSetState.setRejectionDate(new Date());
                        documentToSetState.setRejectionReason(documentSetStateCommand.getRejectionReason());
                        break;
                    } else {
                        log.info("C3. Not proceeded. Document state must be SUBMITTED (plus CONFIRMED document can't become REJECTED)");
                        throw new ResourceNotFoundException("C3. Not proceeded. Document state must be SUBMITTED (plus CONFIRMED document can't become REJECTED)");
                    }
                }
                case "CONFIRMED": {
                    if (documentToSetState.getDocumentState().equals(DocumentState.SUBMITTED)) {
                        documentToSetState.setReviewer(reviewerUser);
                        documentToSetState.setDocumentState(DocumentState.CONFIRMED);
                        documentToSetState.setConfirmationDate(new Date());
                        break;
                    } else {
                        log.info("C4. Not proceeded. Document state must be SUBMITTED (plus REJECTED document can't become CONFIRMED)");
                        throw new ResourceNotFoundException("C4. Not proceeded. Document state must be SUBMITTED (plus REJECTED document can't become CONFIRMED)");
                    }
                }
                default:
                    throw new ResourceNotFoundException("My dear Friend, non of the SWITCH case was proceeded.");

            }
            documentRepository.save(documentToSetState);
            log.info("Document state set to: " + documentSetStateCommand.getDocumentState());
        }
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
    public void updateDocument(Long id, DocumentUpdateCommand documentUpdateCommand) {
        Document documentToUpdate = documentRepository.findById(id).orElse(null);

        DocumentType documentType = documentTypeRepository.findByTitle(documentUpdateCommand.getDocumentTypeTitle());
        documentToUpdate.setDocumentType(documentType);


        documentToUpdate.setTitle(documentUpdateCommand.getTitle());
        documentToUpdate.setDescription(documentUpdateCommand.getDescription());
        documentRepository.save(documentToUpdate);
        log.info("Document data updated - {} Everything is OK" + documentToUpdate.toString());
    }

    //DELETE ===========================================================================================================
    @Transactional
    public void deleteDocument(long id) {
        documentRepository.deleteById(id);
        log.info("Document with id = " + id + " was deleted");
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
