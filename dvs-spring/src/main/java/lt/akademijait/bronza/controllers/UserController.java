package lt.akademijait.bronza.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.user.UserCreateCommand;
import lt.akademijait.bronza.dto.user.UserGetCommand;
import lt.akademijait.bronza.dto.user.UserUpdateCommand;
import lt.akademijait.bronza.services.DocumentService;
import lt.akademijait.bronza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "users")
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DocumentService documentService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all users", notes = "Returns all users")
    public List<UserGetCommand> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create new user", notes = "Creates new user")
    public void createUser (@ApiParam(value = "User data", required = true)
                                @Valid @RequestBody final UserCreateCommand ucc){
        userService.createNewUser(ucc);
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Delete user", notes = "Deletes an existing user")
    public void deleteUserByUsername(@ApiParam(value = "User username", required = true) @PathVariable final String username){
        userService.deleteUser(username);
    }


    @RequestMapping(path = "/{username}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update user", notes = "Updates user's data")
    public void updateUserData(
            @ApiParam(value = "Username", required = true) @PathVariable final String username,
            @ApiParam(value =  "new data", required = true) @RequestBody UserUpdateCommand uuc){
        userService.updateUsersData(username, uuc);
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    @ApiOperation(value = "Get user by username", notes = "Returns certain user by username")
    public UserGetCommand getUserByUsername(
            @ApiParam(value = "username", required = true) @Valid @PathVariable final String username){
        return userService.getUserByUsername(username);
    }

//    @RequestMapping(path = "/group/{username}", method = RequestMethod.PUT)
//    @ApiOperation(value = "Add user to userGroup", notes = "Adds user to new userGroup")
//    public void addUserToUserGroup(
//            @ApiParam(value = "Username", required = true) @PathVariable final String username,
//            @ApiParam(value = "New usergroup", required = true) @RequestBody String newUserGroup){
//        userService.addUserToNewUserGroup(username, newUserGroup);
//    }


}
