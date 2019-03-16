package lt.akademijait.bronza.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.statistics.DocumentCountGetCommand;
import lt.akademijait.bronza.dto.user.UserGetCommand;
import lt.akademijait.bronza.services.StatisticsService;
import lt.akademijait.bronza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "statistics")
@RequestMapping(value = "/api/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    @ApiOperation(value = "Get all users count", notes = "Returns all users count")
    public Long getAllUsersCount(){
        return statisticsService.getAllUsersCount();
    }

    @RequestMapping(path = "/documents", method = RequestMethod.GET)
    @ApiOperation(value = "Get all documents count", notes = "Returns all document count")
    public Long getAllDocumentsCount(){
        return statisticsService.getAllDocumentsCount();
    }

    @RequestMapping(path = "/docAndusers", method = RequestMethod.GET)
    @ApiOperation(value = "Get all documents count", notes = "Returns all document count")
    public List<Long> getAllDocAndUsers(){
        return statisticsService.getAllDocumentsandUsersCount();
    }

    @RequestMapping(path = "/{docType}", method = RequestMethod.GET)
    @ApiOperation(value = "Get documents by doctype", notes = "Returns documents statistics by document type")
    public DocumentCountGetCommand getDocumentsByType(
            @ApiParam(value = "docType", required = true) @PathVariable final String docType){
        return statisticsService.getCountByDocumentType(docType);
    }


}
