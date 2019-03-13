package lt.akademijait.bronza.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.role.RoleCreateCommand;
import lt.akademijait.bronza.dto.role.RoleGetCommand;
import lt.akademijait.bronza.dto.user.UserGetCommand;
import lt.akademijait.bronza.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "roles")
@RequestMapping(value = "/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;


    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all roles", notes = "Returns all roles")
    public List<RoleGetCommand> getAllUsers() {
        return roleService.getAllRoles();
    }


    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add new document type", notes = "Adds new document type")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocumentType (
            @ApiParam(value = "Role data", required = true)
            @RequestBody final RoleCreateCommand roleCreateCommand) {
        roleService.createRole(roleCreateCommand);
    }
}
