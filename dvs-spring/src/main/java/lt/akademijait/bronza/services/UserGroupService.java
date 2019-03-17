package lt.akademijait.bronza.services;

import lombok.extern.slf4j.Slf4j;
import lt.akademijait.bronza.dto.usergroup.UserGroupCreateCommand;
import lt.akademijait.bronza.dto.usergroup.UserGroupGetCommand;
import lt.akademijait.bronza.dto.usergroup.UserGroupUpdateCommand;
import lt.akademijait.bronza.dto.usergroup.UserGroupUpdateDocTypeCommand;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.UserGroup;
import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserGroupService {

//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserGroupRepository userGroupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Transactional
    public List<UserGroupGetCommand> getAllGroups() {

        List<UserGroupGetCommand> allGroups = new ArrayList<>();

        for (UserGroup userGroup : userGroupRepository.findAll()) {

            Set<String> submitDocTypes = new HashSet<>();
            for (DocumentType documentType : userGroup.getSubmissionDocumentType()) {
                submitDocTypes.add(documentType.getTitle());
            }

            Set<String> reviewDocTypes = new HashSet<>();
            for (DocumentType documentType : userGroup.getReviewDocumentType()) {
                reviewDocTypes.add(documentType.getTitle());
            }

            UserGroupGetCommand uggc = new UserGroupGetCommand(
                    userGroup.getTitle(),
                    submitDocTypes,
                    reviewDocTypes);
            allGroups.add(uggc);
        }
        log.info("Info about all the user groups was gotten");
        return allGroups;
    }



    @Transactional
    public void createNewGroup(UserGroupCreateCommand ugcc){

        Set<DocumentType> docTypesToSubmit = new HashSet<>();
        for (String submitDocType: ugcc.getSubmitDocumentType()) {
            docTypesToSubmit.add(documentTypeRepository.findByTitle(submitDocType));
        }

        Set<DocumentType> docTypesToReview = new HashSet<>();
        for (String reviewDocType: ugcc.getReviewDocumentType()) {
            docTypesToReview.add(documentTypeRepository.findByTitle(reviewDocType));
        }

        UserGroup newGroup = new UserGroup(
                ugcc.getTitle(),
                docTypesToSubmit,
                docTypesToReview);
        userGroupRepository.save(newGroup);
        log.info("New user group " + newGroup.getTitle() + " was created");
    }

    @Transactional
    public void updateUserGroupInfo(String userGroupName, UserGroupUpdateCommand uguc){

        UserGroup userGroupToUpdate = userGroupRepository.findByTitle(userGroupName);

        Set<DocumentType> docTypesToSubmit = new HashSet<>();
        for (String submitDocType: uguc.getSubmitDocumentType()) {
            docTypesToSubmit.add(documentTypeRepository.findByTitle(submitDocType));
        }

        Set<DocumentType> docTypesToReview = new HashSet<>();
        for (String reviewDocType: uguc.getReviewDocumentType()) {
            docTypesToReview.add(documentTypeRepository.findByTitle(reviewDocType));
        }

        userGroupToUpdate.setTitle(uguc.getTitle());
        userGroupToUpdate.setSubmissionDocumentType(docTypesToSubmit);
        userGroupToUpdate.setReviewDocumentType(docTypesToReview);

        userGroupRepository.save(userGroupToUpdate);
        log.info("The info of the group " + userGroupName + " was updated");
    }

    @Transactional
    public void addDocTypeToReview(String userGroup, UserGroupUpdateDocTypeCommand userGroupUpdateDocTypeCommand){

        UserGroup groupToUpdate = userGroupRepository.findByTitle(userGroup);
        for (String documentType: userGroupUpdateDocTypeCommand.getDocumentType()){
            if (!groupToUpdate.getReviewDocumentType().contains(documentTypeRepository.findByTitle(documentType))){
                groupToUpdate.getReviewDocumentType().add(documentTypeRepository.findByTitle(documentType));
            }
        }
        userGroupRepository.save(groupToUpdate);
        log.info(userGroupUpdateDocTypeCommand.getDocumentType() + "was added for review to the " + userGroup + " group");
    }

    @Transactional
    public void addDocTypeToSubmit(String userGroup, UserGroupUpdateDocTypeCommand userGroupUpdateDocTypeCommand){

        UserGroup groupToUpdate = userGroupRepository.findByTitle(userGroup);
        for (String documentType: userGroupUpdateDocTypeCommand.getDocumentType()){
            if (!groupToUpdate.getSubmissionDocumentType().contains(documentTypeRepository.findByTitle(documentType))){
                groupToUpdate.getSubmissionDocumentType().add(documentTypeRepository.findByTitle(documentType));
            }
        }
        userGroupRepository.save(groupToUpdate);
        log.info(userGroupUpdateDocTypeCommand.getDocumentType() + "was added for submit to the " + userGroup + " group");

    }

    @Transactional
    public void removeDocTypeToReview(String userGroup, UserGroupUpdateDocTypeCommand userGroupUpdateDocTypeCommand){

        UserGroup groupToUpdate = userGroupRepository.findByTitle(userGroup);
        for (String documentType: userGroupUpdateDocTypeCommand.getDocumentType()){
            if (groupToUpdate.getReviewDocumentType().contains(documentTypeRepository.findByTitle(documentType))){
                groupToUpdate.getReviewDocumentType().remove(documentTypeRepository.findByTitle(documentType));
            }
        }
        userGroupRepository.save(groupToUpdate);
        log.info(userGroupUpdateDocTypeCommand.getDocumentType() + "was removed for reviewing for the " + userGroup + " group");

    }

    @Transactional
    public void removeDocTypeToSubmit(String userGroup, UserGroupUpdateDocTypeCommand userGroupUpdateDocTypeCommand){

        UserGroup groupToUpdate = userGroupRepository.findByTitle(userGroup);
        for (String documentType: userGroupUpdateDocTypeCommand.getDocumentType()){
            if (groupToUpdate.getSubmissionDocumentType().contains(documentTypeRepository.findByTitle(documentType))){
                groupToUpdate.getSubmissionDocumentType().remove(documentTypeRepository.findByTitle(documentType));
            }
        }
        userGroupRepository.save(groupToUpdate);
        log.info(userGroupUpdateDocTypeCommand.getDocumentType() + "was removed for submitting for to the " + userGroup + " group");

    }

    @Transactional
    public void deleteGroup(String title){
        userGroupRepository.deleteByTitle(title);
        log.info("The user group " + title + " was deleted");
    }



    @Transactional
    public UserGroupGetCommand getUserGroupInfo (String groupName){
        UserGroup userGroup = userGroupRepository.findByTitle(groupName);

        Set<String> reviewDocType = new HashSet<>();
        for (DocumentType documentType: userGroup.getReviewDocumentType()) {
            reviewDocType.add(documentType.getTitle());
        }

        Set<String> submitDocType = new HashSet<>();
        for (DocumentType documentType: userGroup.getSubmissionDocumentType()) {
            submitDocType.add(documentType.getTitle());
        }
        log.info("Info about the group " + groupName + " was gotten");
        return new UserGroupGetCommand(
                userGroup.getTitle(),
                submitDocType,
                reviewDocType
                );
    }




}
