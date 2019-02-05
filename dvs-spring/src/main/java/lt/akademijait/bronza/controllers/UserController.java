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

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update user info", notes = "Updates user by id")
    public void updateUser(
            @ApiParam(value = "User id", required = true) @PathVariable final Long id,
            @ApiParam(value = "User info", required = true) @RequestBody UserUpdateCommand uuc){
        userService.updateUserInfo(uuc);
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update user password", notes = "Updates user's password")
    public void updateUserPassword(
            @ApiParam(value = "Username", required = true) @PathVariable final String username,
            @ApiParam(value =  "new password", required = true) @RequestBody UserCreateCommand userCreateCommand){
        userService.updateUsersPassword(username, userCreateCommand.getPassword());
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    @ApiOperation(value = "Get user by username", notes = "Returns certain user by username")
    public UserGetCommand getUserByUsername(
            @ApiParam(value = "username", required = true) @Valid @PathVariable final String username){
        return userService.getUserByUsername(username);
    }


}
