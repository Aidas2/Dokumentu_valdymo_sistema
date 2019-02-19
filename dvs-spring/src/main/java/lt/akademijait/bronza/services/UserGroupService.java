package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.usergroup.UserGroupCreateCommand;
import lt.akademijait.bronza.dto.usergroup.UserGroupGetCommand;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.UserGroup;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<UserGroupGetCommand> getAllGroups(){
        return userGroupRepository.findAll().stream().map((userGroup) ->
                new UserGroupGetCommand(userGroup.getTitle())).collect(Collectors.toList());
    }

    @Transactional
    public void createNewGroup(UserGroupCreateCommand ugcc){
        UserGroup newGroup = new UserGroup(
                ugcc.getTitle(),
                Collections.emptyList(),
                Collections.emptyList());
 //               ugcc.getSubmissionDocumentType(),
 //               ugcc.getReviewDocumentType());
        userGroupRepository.save(newGroup);
    }

    @Transactional
    public void deleteGroup(String title){userGroupRepository.deleteByTitle(title);}










}
