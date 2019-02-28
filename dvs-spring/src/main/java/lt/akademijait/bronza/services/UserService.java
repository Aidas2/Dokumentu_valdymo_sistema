package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.user.UserAddToGroupCommand;
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

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;


    @Transactional(readOnly = true)
    public List<UserGetCommand> getAllUsers() {
        List<UserGetCommand> allUsers = new ArrayList<>();

        for (User user : userRepository.findAll()) {
            Set<String> userGroupsTitles = new HashSet<>();

            for (UserGroup userGroup : user.getUserGroups()) {
                userGroupsTitles.add(userGroup.getTitle());
            }
            UserGetCommand ugc = new UserGetCommand(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.isAdministrator(),
                    user.getPassword(),
                    user.getUsername(),
                    user.getEmailAddress(),
                    user.getHireDate(),
                    userGroupsTitles);
            allUsers.add(ugc);
        }
        return allUsers;
    }

//        return userRepository.findAll().stream().map(
//                (user) ->
//                    new UserGetCommand(
//                            user.getId(),
//                            user.getFirstName(),
//                            user.getLastName(),
//                            user.isAdministrator(),
//                            user.getPassword(),
//                            user.getUsername(),
//                            user.getEmailAddress(),
//                            user.getHireDate(),
//                            userGroupsTitles))
//                .collect(Collectors.toList());


    @Transactional(readOnly = true)
    public UserGetCommand getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        Set<String> userGroupsTitles = new HashSet<>();

        for (UserGroup userGroup : user.getUserGroups()) {
            userGroupsTitles.add(userGroup.getTitle());
        }
        return new UserGetCommand(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.isAdministrator(),
                user.getPassword(),
                user.getUsername(),
                user.getEmailAddress(),
                user.getHireDate(),
                userGroupsTitles);
    }

    @Transactional
    public void createNewUser(UserCreateCommand ucc) {

        Set<UserGroup> userGroupsToSet = new HashSet<>();

        for (String userGroupTitle : ucc.getUserGroupTitle()) {
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
        );
        //newUser.getUserGroups().add()


//        newUser.setUserGroups(userGroupsToSet);
        userRepository.save(newUser);


    }

    @Transactional
    public void updateUsersData(String oldUserName, UserUpdateCommand uuc) {

        Set<UserGroup> userGroupsToSet = new HashSet<>();

        for (String userGroupTitle : uuc.getUserGroupTitle()) {
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
    public void addUserToNewUserGroup(String username, UserAddToGroupCommand userAddToGroupCommand) {

        User userToUpdate = userRepository.findByUsername(username);
        for (String userGroupTitle : userAddToGroupCommand.getUserGroupTitle()) {
            if (!userToUpdate.getUserGroups().contains(userGroupRepository.findByTitle(userGroupTitle))) {
                userToUpdate.getUserGroups().add(userGroupRepository.findByTitle(userGroupTitle));
            }
        }
        userRepository.save(userToUpdate);
    }

    @Transactional
    public void removeUserFromUserGroup(String username, UserAddToGroupCommand userAddToGroupCommand) {
        User userToUpdate = userRepository.findByUsername(username);
        for (String userGroupTitle : userAddToGroupCommand.getUserGroupTitle()) {
            if (userToUpdate.getUserGroups().contains(userGroupRepository.findByTitle(userGroupTitle))) {
                userToUpdate.getUserGroups().remove(userGroupRepository.findByTitle(userGroupTitle));
            }
        }
        userRepository.save(userToUpdate);
    }


    @Transactional
    public List<UserGetCommand> getUsersByGroup(String groupName){
        List<UserGetCommand> allUsersInGroup = new ArrayList<>();

        for (User user : userRepository.findAll()) {
            Set<String> userGroupsTitles = new HashSet<>();

            if (user.getUserGroups().contains(userGroupRepository.findByTitle(groupName))) {
                for (UserGroup userGroup : user.getUserGroups()) {
                    userGroupsTitles.add(userGroup.getTitle());
                }
                UserGetCommand ugc = new UserGetCommand(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.isAdministrator(),
                        user.getPassword(),
                        user.getUsername(),
                        user.getEmailAddress(),
                        user.getHireDate(),
                        userGroupsTitles);
                allUsersInGroup.add(ugc);
            }
        }
        return allUsersInGroup;
    }


    @Transactional
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }


}






