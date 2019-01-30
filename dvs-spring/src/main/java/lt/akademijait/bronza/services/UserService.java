package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.user.UserGetCommand;
import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.entities.UserGroup;
import lt.akademijait.bronza.repositories.UserGroupRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;


    @Transactional
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

    @Transactional
    public void createNewUser(long id, String firstName, String lastName,
                              LocalDate hireDate, boolean administrator, String password,
                              String username, String emailAddress, List<UserGroup> userGroups, List<Document> documents){
        User newUser = new User(id, firstName, lastName, hireDate, administrator, password, username, emailAddress, userGroups, documents);
        userRepository.save(newUser);
    }

    @Transactional
    public void updateUsersPassword(String username, String password){
        User userToUpdate = userRepository.findByUsername(username);
        userToUpdate.setPassword(password);
        userRepository.save(userToUpdate);
    }

    @Transactional
    public void addUserToGroup(String username, List<UserGroup> userGroups){
        User addToGroup = userRepository.findByUsername(username);
        addToGroup.setUserGroups(userGroups);
        userRepository.save(addToGroup);

    }

    @Transactional
    public void deleteUser(String username){
        userRepository.deleteByUsername(username);
    }

}






