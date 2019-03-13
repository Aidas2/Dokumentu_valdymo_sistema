package lt.akademijait.bronza.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.usergroup.UserGroupCreateCommand;
import lt.akademijait.bronza.dto.usergroup.UserGroupGetCommand;
import lt.akademijait.bronza.dto.usergroup.UserGroupUpdateDocTypeCommand;
import lt.akademijait.bronza.services.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @ApiOperation(value = "Get all groups", notes = "Returns all user groups")
    public List<UserGroupGetCommand> getAllGroups(){
        return userGroupService.getAllGroups();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create group", notes = "Creates new user group")
    public void createGroup (@ApiParam(value = "Group info", required = true) @Valid @RequestBody final UserGroupCreateCommand ugc){
        userGroupService.createNewGroup(ugc);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/{title}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Delete group", notes = "Deletes an existing user group")
    public void deleteUserByUsername(@ApiParam(value = "Usergroup title", required = true) @PathVariable final String title){
        userGroupService.deleteGroup(title);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/reviewDocType/{userGroup}", method = RequestMethod.PUT)
    @ApiOperation(value = "Add doctype to review", notes = "Adds new document type to review to user group")
    public void addDocTypeToReview(
            @ApiParam(value = "User Group", required = true) @PathVariable final String userGroup,
            @ApiParam(value = "New doctype to review", required = true) @RequestBody UserGroupUpdateDocTypeCommand ugu){
        userGroupService.addDocTypeToReview(userGroup, ugu);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/reviewDocType/{userGroup}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Remove doctype to review", notes = "Removes document type to review from user group")
    public void removeDocTypeToReview(
            @ApiParam(value = "User Group", required = true) @PathVariable final String userGroup,
            @ApiParam(value = "Doctype to remove", required = true) @RequestBody UserGroupUpdateDocTypeCommand ugu){
        userGroupService.removeDocTypeToReview(userGroup, ugu);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/submitDocType/{userGroup}", method = RequestMethod.PUT)
    @ApiOperation(value = "Add doctype to submit", notes = "Adds new document type to submit to user group")
    public void addDocTypeToSubmit(
            @ApiParam(value = "User Group", required = true) @PathVariable final String userGroup,
            @ApiParam(value = "New doctype to submit", required = true) @RequestBody UserGroupUpdateDocTypeCommand ugu){
        userGroupService.addDocTypeToSubmit(userGroup, ugu);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/submitDocType/{userGroup}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Remove doctype to submit", notes = "Removes document type to submit from user group")
    public void removeDocTypeToSubmit(
            @ApiParam(value = "User Group", required = true) @PathVariable final String userGroup,
            @ApiParam(value = "Doctype to remove", required = true) @RequestBody UserGroupUpdateDocTypeCommand ugu){
        userGroupService.removeDocTypeToSubmit(userGroup, ugu);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/{usergroup}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update usergroup title", notes = "Change titel of a certain usergroup")
    public void updateUserGroupTitle(
            @ApiParam(value = "Usergroup", required = true) @PathVariable final String usergroup,
            @ApiParam(value =  "new title", required = true) @RequestBody UserGroupCreateCommand ugcc){
        userGroupService.changeGroupName(usergroup,ugcc);
    }

    @RequestMapping(path = "/{usergroup}", method = RequestMethod.GET)
    @ApiOperation(value = "Get usergroup by title", notes = "Returns certain usergroup ifo by title")
    public UserGroupGetCommand getUserGroupByTitle(
            @ApiParam(value = "usergroup", required = true) @Valid @PathVariable final String usergroup){
        return userGroupService.getUserGroupInfo(usergroup);
    }








}
