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

    //private  final static Logger logger = LoggerFactory.getLogger(DocumentTypeService.class);
    //private Logger logger = LoggerFactory.getLogger(this.getClass());

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

/*  //commented as not necessary (but useful if you want to return only String)
    //GET BY STATE (READY FOR SUBMITTING) AND USER (SPECIFIED) V_01 (without dto) ======================================
    @Transactional (readOnly = true)
    //public List <DocumentTypeGetCommand> getDocumentTypeTitlesOfSubmittingUser1 (String username) {
    public List<String> getDocumentTypeTitlesOfSubmittingUser1 (String username) {
        List <String> documentTypesTitlesOfSubmittingUser = new ArrayList<>();   // is anksto sukuriam Stringu Lista i kuri addinsim rezultatus;
        User submittingUser = userRepository.findByUsername(username);  // pasirinkti useri (is repositorijos ir t.t.)
        Set<UserGroup> userGroupsOfSubmittingUser = submittingUser.getUserGroups(); // gettinam kokios userGroups jam priskirtos, gaunam masyva userGroups'u [Administracija, Gamyba];

        // einam foreach'u per kiekviena masyvo userGroups elementa ir gettinam kokios yra submissionDoctype, gaunam dar viena masyva [Instrukcija, Prasymas, Isakymas]
        for (UserGroup userGroup: userGroupsOfSubmittingUser
             ) {
            Set<DocumentType> submissionDocumentTypeOfSubmittingUser = userGroup.getSubmissionDocumentType(); //gavom [Instrukcija, Prasymas, Isakymas]

            // einam foreach'u per kiekviena masyvo documentType elementa, getinam Title, kuri addinsim i is anksto susikurta Lista (bet tik tuo atveju jei dar neaddintas)
            for (DocumentType documentType: submissionDocumentTypeOfSubmittingUser
                 ) {
                if(!documentTypesTitlesOfSubmittingUser.contains(documentType.getTitle())) { //(bet tik tuo atveju jei dar neaddintas)
                    documentTypesTitlesOfSubmittingUser.add(documentType.getTitle());
                }
            }
        }
        log.info("Gotten all document type titles which user " + username + " can submit");
        return documentTypesTitlesOfSubmittingUser;
    }
*/
    //GET BY STATE (READY FOR SUBMITTING) AND USER (SPECIFIED) V_02 (with DTO) ======================================
    @Transactional (readOnly = true)
     public List<DocumentTypeGetCommand> getDocumentTypeTitlesOfSubmittingUser2 () {
        List<DocumentTypeGetCommand> documentTypesDtoOfSubmittingUser = new ArrayList<>();   // is anksto sukuriam DTO Lista i kuri addinsim DTO kaip OBJEKTUS;
        User submittingUser = userRepository.findByUsername(getLoggedInUsername());  // pasirinkti useri (is repositorijos ir t.t.)
        Set<UserGroup> userGroupsOfSubmittingUser = submittingUser.getUserGroups(); // gettinam kokios userGroups jam priskirtos, gaunam masyva userGroups'u [Administracija, Gamyba];

        // einam foreach'u per kiekviena masyvo userGroups elementa ir gettinam kokios yra submissionDoctype, gaunam dar viena masyva [Instrukcija, Prasymas, Isakymas]
        for (UserGroup userGroup: userGroupsOfSubmittingUser
        ) {
            Set<DocumentType> submissionDocumentTypeOfSubmittingUser = userGroup.getSubmissionDocumentType(); //gavom [Instrukcija, Prasymas, Isakymas]

            // einam foreach'u per kiekviena masyvo documentType elementa,  getinam viska (id, title), ir pridedam i nauja DTO, kuri addinsim i is anksto susikurta  objektu Lista
            for (DocumentType documentType: submissionDocumentTypeOfSubmittingUser
            ) {
                DocumentTypeGetCommand docTypeDTO = new DocumentTypeGetCommand(documentType.getId(),documentType.getTitle()); // gavom nauja DTO su paduotomis reiksmemis

                if(!documentTypesDtoOfSubmittingUser.contains(docTypeDTO)) { //(bet tik tuo atveju jei dar neaddintas, zr. @Override)
                    documentTypesDtoOfSubmittingUser.add(docTypeDTO);
                }
            }
        }
        log.info("Gotten all document type titles which user " + getLoggedInUsername() + " can submit");
        return documentTypesDtoOfSubmittingUser;
    }

    //GET BY STATE (READY FOR REVIEwING) AND USER (SPECIFIED) (with DTO) ======================================
    @Transactional (readOnly = true)
    public List<DocumentTypeGetCommand> getDocumentTypeTitlesOfReviewingUser () {
        List<DocumentTypeGetCommand> documentTypesDtoOfReviewingUser = new ArrayList<>();   // is anksto sukuriam DTO Lista i kuri addinsim DTO kaip OBJEKTUS;
        User reviewingUser = userRepository.findByUsername(getLoggedInUsername());  // pasirinkti useri (is repositorijos ir t.t.)
        Set<UserGroup> userGroupsOfReviewingUser = reviewingUser.getUserGroups(); // gettinam kokios userGroups jam priskirtos, gaunam masyva userGroups'u [Administracija, Gamyba];

        // einam foreach'u per kiekviena masyvo userGroups elementa ir gettinam kokios yra submissionDoctype, gaunam dar viena masyva [Instrukcija, Prasymas, Isakymas]
        for (UserGroup userGroup: userGroupsOfReviewingUser
        ) {
            Set<DocumentType> reviewingDocumentTypeOfSubmittingUser = userGroup.getReviewDocumentType(); //gavom [Instrukcija, Prasymas, Isakymas]

            // einam foreach'u per kiekviena masyvo documentType elementa,  getinam viska (id, title), ir pridedam i nauja DTO, kuri addinsim i is anksto susikurta  objektu Lista
            for (DocumentType documentType: reviewingDocumentTypeOfSubmittingUser
            ) {
                DocumentTypeGetCommand docTypeDTO = new DocumentTypeGetCommand(documentType.getId(),documentType.getTitle()); // gavom nauja DTO su paduotomis reiksmemis

                if(!documentTypesDtoOfReviewingUser.contains(docTypeDTO)) { //(bet tik tuo atveju jei dar neaddintas, zr. @Override)
                    documentTypesDtoOfReviewingUser.add(docTypeDTO);
                }
            }
        }
        log.info("Gotten all document type titles which user " + getLoggedInUsername() + " can review");
        return documentTypesDtoOfReviewingUser;
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
