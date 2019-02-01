package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.usergroup.UserGroupGetCommand;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.UserGroup;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Transactional
    public List<UserGroupGetCommand> getAllGroups(){
        return userGroupRepository.findAll().stream().map((userGroup) ->
                new UserGroupGetCommand(userGroup.getTitle())).collect(Collectors.toList());
    }


    @Transactional
    public void createNewGroup (String title, List<DocumentType> submissionDocumentType, List<DocumentType> reviewDocumentType){
        UserGroup newGroup = new UserGroup(title, submissionDocumentType, reviewDocumentType);
        userGroupRepository.save(newGroup);

    }


}
