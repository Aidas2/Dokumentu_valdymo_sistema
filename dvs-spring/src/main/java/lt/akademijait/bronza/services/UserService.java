package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.user.UserCreateCommand;
import lt.akademijait.bronza.dto.user.UserGetCommand;
import lt.akademijait.bronza.dto.user.UserUpdateCommand;
import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.entities.UserGroup;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;


    @Transactional (readOnly = true)
    public List<UserGetCommand> getAllUsers (){
        return userRepository.findAll().stream().map(
                (user) ->
                new UserGetCommand(
                        user.getFirstName(),
                        user.getLastName(),
                        user.isAdministrator(),
                        user.getPassword(),
                        user.getUsername(),
                        user.getEmailAddress())).collect(Collectors.toList());
    }

    @Transactional (readOnly = true)
    public UserGetCommand getUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        return new UserGetCommand(
                user.getFirstName(),
                user.getLastName(),
                user.isAdministrator(),
                user.getPassword(),
                user.getUsername(),
                user.getEmailAddress()
        );
    }

//    @Transactional
//    public void createNewUser(long id, String firstName, String lastName,
//                              LocalDate hireDate, boolean administrator, String password,
//                              String username, String emailAddress, List<UserGroup> userGroups, List<Document> documents){
//        User newUser = new User(id, firstName, lastName, hireDate, administrator, password, username, emailAddress, userGroups, documents);
//        userRepository.save(newUser);
//    }

    @Transactional
    public void createNewUser(UserCreateCommand ucc){

        User newUser = new User(
                ucc.getId(),
                ucc.getFirstName(),
                ucc.getLastName(),
                ucc.getHireDate(),
                ucc.isAdministrator(),
                ucc.getUsername(),
                ucc.getPassword(),
                ucc.getEmailAddress(),
                Collections.emptySet()
                //Collections.emptyList(),
                //ucc.getUserGroups(),
                //ucc.getDocuments()
                );
        //newUser.getUserGroups().add()
        userRepository.save(newUser);


    }

    @Transactional
    public void updateUsersPassword(String username, String password){
        User userToUpdate = userRepository.findByUsername(username);
        userToUpdate.setPassword(password);
        userRepository.save(userToUpdate);
    }

    @Transactional
    public void addUserToGroup(String username, Set<UserGroup> userGroups){
        User addToGroup = userRepository.findByUsername(username);
        addToGroup.setUserGroups(userGroups);
        userRepository.save(addToGroup);

    }

    @Transactional
    public void updateUserInfo(UserUpdateCommand uuc){
        User user = userRepository.findByUsername(uuc.getUsername());
        user.setAdministrator(uuc.isAdministrator());
        user.setFirstName(uuc.getFirstName());
        user.setLastName(uuc.getLastName());
        user.setUsername(uuc.getUsername());
        user.setEmailAddress(uuc.getEmailAddress());
        user.setUserGroups(uuc.getUserGroups());
        //user.setDocuments(uuc.getDocuments());
        userRepository.save(user);





    }

    @Transactional
    public void deleteUser(String username){
        userRepository.deleteByUsername(username);
    }



}






