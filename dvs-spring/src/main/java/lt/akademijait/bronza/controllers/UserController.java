package lt.akademijait.bronza.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.user.UserCreateCommand;
import lt.akademijait.bronza.dto.user.UserGetCommand;
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
    @ApiOperation(value = "Get users", notes = "Returns all users")
    public List<UserGetCommand> getAllUsers(){
        return userService.getAllUsers();
    }

//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ApiOperation(value = "Create new user", notes = "Creates new user")
//    public void createUser (@ApiParam(value = "User data", required = true) @Valid @RequestBody final UserCreateCommand ucc){
//        userService.createNewUser(ucc.getFirstName(), ucc.getLastName(), ucc.getUsername(), ucc.getPassword(), ucc.getEmailAddress());
//    }








}
