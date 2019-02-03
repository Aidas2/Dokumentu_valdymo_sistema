package lt.akademijait.bronza.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.document.DocumentGetCommand;
import lt.akademijait.bronza.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    //READ BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get document by Id", notes = "Returns document info")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentGetCommand getDocumentById(
            @ApiParam(value = "Document id", required = true)
            @PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    //READ SUBMITTED
    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    @ApiOperation(value = "Get all submitted document", notes = "Returns all submitted document")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getSubmittedDocuments() {
        return documentService.getSubmittedDocuments();
    }

    //READ TO BE REVIEWED
    @RequestMapping(value = "/review", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document to review", notes = "Returns all document to review")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getDocumentsToReview() {
        return documentService.getDocumentsToReview();
    }

/*
    //CREATE
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add new document", notes = "Adds new document")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocument (
            @ApiParam(value = "Document data", required = true)
            @RequestBody final DocumentCreateCommand documentCreateCommand) {
        documentService.createDocument(documentCreateCommand);
    }

    //UPDATE
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update document info", notes = "Update document by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateDocumentById(
            @ApiParam(value = "Document id", required = true)
            @RequestBody final DocumentCreateCommand documentCreateCommand,
            @PathVariable Long id) {
        documentService.updateDocument(id, documentCreateCommand);
    }

*/
    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete document", notes = "Delete document by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDocumentById(
            @ApiParam(value = "Document id", required = true)
            @PathVariable Long id) {
        documentService.deleteDocument(id);
    }

}
