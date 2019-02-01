package lt.akademijait.bronza.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.usergroup.UserGroupCreateCommand;
import lt.akademijait.bronza.dto.usergroup.UserGroupGetCommand;
import lt.akademijait.bronza.services.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "user groups")
@RequestMapping(value = "/api/groups" )
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get groups", notes = "Returns all groups")
    public List<UserGroupGetCommand> getAllGroups(){
        return userGroupService.getAllGroups();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create group", notes = "Creates new user group")
    public void createGroup (@ApiParam(value = "Group info", required = true) @Valid @RequestBody final UserGroupCreateCommand ugc){
        userGroupService.createNewGroup(ugc.getTitle(), ugc.getSubmissionDocType(), ugc.getReviewDocType());
    }








}
