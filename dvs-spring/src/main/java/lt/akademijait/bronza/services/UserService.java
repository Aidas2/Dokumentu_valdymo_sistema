package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.user.UserCreateCommand;
import lt.akademijait.bronza.dto.user.UserGetCommand;
import lt.akademijait.bronza.dto.user.UserUpdateCommand;
import lt.akademijait.bronza.dto.usergroup.UserGroupGetCommand;
import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.entities.UserGroup;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;


    @Transactional(readOnly = true)
    public List<UserGetCommand> getAllUsers() {
        return userRepository.findAll().stream().map(
                (user) ->
                        new UserGetCommand(
                                user.getId(),
                                user.getFirstName(),
                                user.getLastName(),
                                user.isAdministrator(),
                                user.getPassword(),
                                user.getUsername(),
                                user.getEmailAddress(),
                                user.getHireDate(),
                                user.getUserGroups())).collect(Collectors.toList() );

    }

    @Transactional(readOnly = true)
    public UserGetCommand getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return new UserGetCommand(
                user.getId(),

                user.getFirstName(),
                user.getLastName(),
                user.isAdministrator(),
                user.getPassword(),
                user.getUsername(),
                user.getEmailAddress(),
                user.getHireDate(),
                user.getUserGroups()
        );
    }

    @Transactional
    public void createNewUser(UserCreateCommand ucc) {

        Set<UserGroup> userGroupsToSet = new HashSet<>();

        for (String userGroupTitle: ucc.getUserGroupTitle()) {
            userGroupsToSet.add(userGroupRepository.findByTitle(userGroupTitle));
        }
        User newUser = new User(
                ucc.getFirstName(),
                ucc.getLastName(),
                ucc.getHireDate(),
                ucc.isAdministrator(),
                ucc.getUsername(),
                ucc.getPassword(),
                ucc.getEmailAddress(),
                userGroupsToSet
                //Collections.emptyList()

        );
        //newUser.getUserGroups().add()


//        newUser.setUserGroups(userGroupsToSet);
        userRepository.save(newUser);


    }

    @Transactional
    public void updateUsersData(String oldUserName, UserUpdateCommand uuc) {

        Set<UserGroup> userGroupsToSet = new HashSet<>();

        for (String userGroupTitle: uuc.getUserGroupTitle()) {
            userGroupsToSet.add(userGroupRepository.findByTitle(userGroupTitle));
        }

        User userToUpdate = userRepository.findByUsername(oldUserName);
        userToUpdate.setFirstName(uuc.getFirstName());
        userToUpdate.setLastName(uuc.getLastName());
        userToUpdate.setHireDate(uuc.getHireDate());
        userToUpdate.setAdministrator(uuc.isAdministrator());
        userToUpdate.setUsername(uuc.getUsername());
        userToUpdate.setPassword(uuc.getPassword());
        userToUpdate.setEmailAddress(uuc.getEmailAddress());
        userToUpdate.setUserGroups(userGroupsToSet);

        userRepository.save(userToUpdate);
    }

    @Transactional
    public void addUserToNewUserGroup(String username, UserGroupGetCommand userGroup){

        User userToUpdate = userRepository.findByUsername(username);
//        UserGroup userGroupToAdd = userGroupRepository.findAllByTitle().contains(username);

        Set<UserGroup> userGroupsToAdd = new HashSet<>();

//        for (String userGroupTitle: .getUserGroupTitle()) {
//            if (!userGroupsToAdd.contains(userToUpdate.getUserGroups())){
//                userGroupsToAdd.add(userGroupRepository.findByTitle(userGroupTitle));
//            }continue;
//        }
        userRepository.save(userToUpdate);
    }


    @Transactional
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }




}






