package lt.akademijait.bronza.controllers;


import io.swagger.annotations.Api;
import lt.akademijait.bronza.services.DocTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "document types")
@RequestMapping(value = "api/doctypes")
public class DocTypeController {

    @Autowired
    private DocTypeService docTypeService;










}
