package lt.akademijait.bronza.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.akademijait.bronza.dto.document.DocumentGetCommand;
import lt.akademijait.bronza.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "documents")
@RequestMapping(value = "/api/docs")
public class DocumentController {

    @Autowired
    private DocumentService documentService;



    //READ
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all documents", notes = "Returns all documents")
    public List<DocumentGetCommand> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    //READ BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get document by Id", notes = "Returns document info")
    public DocumentGetCommand getDocumentById(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    //READ SUBMITTED
    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    @ApiOperation(value = "Get all submitted document", notes = "Returns all submitted document")
    public List<DocumentGetCommand> getSubmittedDocuments() {
        return documentService.getSubmittedDocuments();
    }

    //READ TO BE REVIEWED
    @RequestMapping(value = "/review", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document to review", notes = "Returns all document to review")
    public List<DocumentGetCommand> getDocumentsToReview() {
        return documentService.getDocumentsToReview();
    }

    //READ REVIEWED


    //CREATE


    //DELETE


    //UPDATE







}
