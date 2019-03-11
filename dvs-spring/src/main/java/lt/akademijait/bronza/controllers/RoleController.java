package lt.akademijait.bronza.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.akademijait.bronza.dto.role.RoleGetCommand;
import lt.akademijait.bronza.dto.user.UserGetCommand;
import lt.akademijait.bronza.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "roles")
@RequestMapping(value = "/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;


    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all roles", notes = "Returns all roles")
    public List<RoleGetCommand> getAllUsers(){
        return roleService.getAllRoles();
    }
}
