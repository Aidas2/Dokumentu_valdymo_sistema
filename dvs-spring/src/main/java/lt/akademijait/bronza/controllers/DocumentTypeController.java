package lt.akademijait.bronza.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.documenttype.DocumentTypeGetCommand;
import lt.akademijait.bronza.services.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "document types")
@RequestMapping(value = "/api/doctypes")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;


    //READ
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all documents types", notes = "Returns all documents types")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentTypeGetCommand> getDocumentsTypes() {
        return documentTypeService.getDocumentTypes();
    }

    //READ By ID
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get documents type by id", notes = "Returns document type by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentTypeGetCommand getDocumentsTypeById(
            @ApiParam(value = "Document type id", required = true)
            @PathVariable Long id) {
        return documentTypeService.getDocumentsTypeById(id);
    }

/*
    //CREATE
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add new document type", notes = "Adds new document type")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocumentType (
            @ApiParam(value = "Document type data", required = true)
            @RequestBody final DocumentTypeCreateCommand documentTypeCreateCommand) {
        documentTypeService.createDocumentType(documentTypeCreateCommand);
    }

    //UPDATE
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update document type info", notes = "Update document type by id")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateDocumentTypeById(
            @ApiParam(value = "Document type id", required = true)
            @RequestBody final DocumentTypeCreateCommand documentTypeCreateCommand,
            @PathVariable Long id) {
        documentTypeService.updateDocumentType(id, documentTypeCreateCommand);
    }
*/

    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete document type", notes = "Delete document type by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDocumentTypeById(
            @ApiParam(value = "Document type id", required = true)
            @PathVariable Long id) {
        documentTypeService.deleteDocumentType(id);
    }




}
