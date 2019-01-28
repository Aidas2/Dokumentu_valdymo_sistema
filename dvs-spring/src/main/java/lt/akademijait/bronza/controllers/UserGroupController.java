package lt.akademijait.bronza.controllers;

import io.swagger.annotations.Api;
import lt.akademijait.bronza.services.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "user groups")
@RequestMapping(value = "/api/groups" )
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;







}
