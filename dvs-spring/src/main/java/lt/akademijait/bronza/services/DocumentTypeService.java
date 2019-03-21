package lt.akademijait.bronza.services;

import lombok.extern.slf4j.Slf4j;
import lt.akademijait.bronza.dto.documenttype.DocumentTypeCreateCommand;
import lt.akademijait.bronza.dto.documenttype.DocumentTypeGetCommand;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.entities.UserGroup;
import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    //GET ALL ==========================================================================================================
    @Transactional(readOnly = true)
    public List<DocumentTypeGetCommand> getDocumentTypes() {
        log.info("Gotten all document types");
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
        log.info("Gotten all document types by this id: " + id);
        return new DocumentTypeGetCommand(
                    documentType.getId(),
                    documentType.getTitle()
        );
    }

    //GET BY TITLE =====================================================================================================
    @Transactional(readOnly = true)
    public DocumentTypeGetCommand getDocumentsTypeByTitle(String title) {
        DocumentType documentType = documentTypeRepository.findByTitle(title);
        log.info("Gotten all document types by this title: " + title);
        return new DocumentTypeGetCommand(
                documentType.getId(),
                documentType.getTitle()
        );
    }

    //GET BY STATE (READY FOR SUBMITTING) AND USER (SPECIFIED) V_02 (with DTO) ======================================
    @Transactional (readOnly = true)
     public List<DocumentTypeGetCommand> getDocumentTypeTitlesOfSubmittingUser2 () {
        List<DocumentTypeGetCommand> documentTypesDtoOfSubmittingUser = new ArrayList<>();
        User submittingUser = userRepository.findByUsername(getLoggedInUsername());
        Set<UserGroup> userGroupsOfSubmittingUser = submittingUser.getUserGroups();

        for (UserGroup userGroup: userGroupsOfSubmittingUser
        ) {
            Set<DocumentType> submissionDocumentTypeOfSubmittingUser = userGroup.getSubmissionDocumentType();

            for (DocumentType documentType: submissionDocumentTypeOfSubmittingUser
            ) {
                DocumentTypeGetCommand docTypeDTO = new DocumentTypeGetCommand(documentType.getId(),documentType.getTitle());

                if(!documentTypesDtoOfSubmittingUser.contains(docTypeDTO)) {
                    documentTypesDtoOfSubmittingUser.add(docTypeDTO);
                }
            }
        }
        log.info("Gotten all document type titles which user " + getLoggedInUsername() + " can submit");
        return documentTypesDtoOfSubmittingUser;
    }

    //GET BY STATE (READY FOR REVIEwING) AND USER (SPECIFIED) (with DTO) ===============================================
    @Transactional (readOnly = true)
    public List<DocumentTypeGetCommand> getDocumentTypeTitlesOfReviewingUser () {
        List<DocumentTypeGetCommand> documentTypesDtoOfReviewingUser = new ArrayList<>();
        User reviewingUser = userRepository.findByUsername(getLoggedInUsername());
        Set<UserGroup> userGroupsOfReviewingUser = reviewingUser.getUserGroups();

        for (UserGroup userGroup: userGroupsOfReviewingUser
        ) {
            Set<DocumentType> reviewingDocumentTypeOfSubmittingUser = userGroup.getReviewDocumentType();

            for (DocumentType documentType: reviewingDocumentTypeOfSubmittingUser
            ) {
                DocumentTypeGetCommand docTypeDTO = new DocumentTypeGetCommand(documentType.getId(),documentType.getTitle());

                if(!documentTypesDtoOfReviewingUser.contains(docTypeDTO)) {
                    documentTypesDtoOfReviewingUser.add(docTypeDTO);
                }
            }
        }
        log.info("Gotten all document type titles which user " + getLoggedInUsername() + " can review");
        return documentTypesDtoOfReviewingUser;
    }

    //CREATE ===========================================================================================================
    @Transactional
    public void createDocumentType (DocumentTypeCreateCommand documentTypeCreateCommand) {
        DocumentType newDocumentType = new DocumentType();
        newDocumentType.setTitle(documentTypeCreateCommand.getTitle());
        documentTypeRepository.save(newDocumentType);
        log.info("New document type created - {} Everything is OK", documentTypeCreateCommand.getTitle());
    }

    //UPDATE ===========================================================================================================
    @Transactional
    public void updateDocumentType (Long id, DocumentTypeCreateCommand documentTypeCreateCommand) {
        DocumentType documentTypeToUpdate = documentTypeRepository.findById(id).orElseThrow(null);
        documentTypeToUpdate.setTitle(documentTypeCreateCommand.getTitle());
        documentTypeRepository.save(documentTypeToUpdate);
        log.info("Document type updated to - {} Everything is OK", documentTypeCreateCommand.getTitle());
    }

    //DELETE ===========================================================================================================
    @Transactional
    public void deleteDocumentType (Long id) {
        documentTypeRepository.deleteById(id);
        log.info("Document type with id = " + id + " was deleted");
    }

    //Method to get logged user username ===============================================================================
    public String getLoggedInUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return "not logged";
    }

}
