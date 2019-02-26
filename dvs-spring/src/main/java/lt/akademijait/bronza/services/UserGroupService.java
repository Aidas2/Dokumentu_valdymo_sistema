package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.usergroup.UserGroupCreateCommand;
import lt.akademijait.bronza.dto.usergroup.UserGroupUpdateDocTypeCommand;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.UserGroup;
import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

//    @Transactional
//    public List<UserGroupGetCommand> getAllGroups(){
//        return userGroupRepository.findAll().stream().map((userGroup) ->
//                new UserGroupGetCommand(
//                        userGroup.getTitle(),
//                        userGroup.getSubmissionDocumentType(),
//                        userGroup.getReviewDocumentType()))
//                .collect(Collectors.toList());
//    }

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
    }

    @Transactional
    public void deleteGroup(String title){userGroupRepository.deleteByTitle(title);}



}
