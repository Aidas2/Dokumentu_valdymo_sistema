package lt.akademijait.bronza.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.document.DocumentCreateCommand;
import lt.akademijait.bronza.dto.document.DocumentGetCommand;
import lt.akademijait.bronza.dto.document.DocumentSetStateCommand;
import lt.akademijait.bronza.dto.document.DocumentUpdateCommand;
import lt.akademijait.bronza.enums.DocumentState;
import lt.akademijait.bronza.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "documents")
@RequestMapping(value = "/api/docs")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    //GET GET GET GET GET GET GET GET GET  GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET

    //READ ALL =========================================================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all documents", notes = "Returns all documents")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    //READ BY ID =======================================================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get document info by Id", notes = "Returns document info by Id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentGetCommand getDocumentById(
            @ApiParam(value = "<-- Document id", required = true)
            @PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    //READ BY STATE (SUBMITTED) ========================================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/submitted", method = RequestMethod.GET)
    @ApiOperation(value = "Get all submitted document", notes = "Returns all submitted document")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getSubmittedDocuments() {
        return documentService.getSubmittedDocuments();
    }

    //READ BY STATE (CONFIRMED) ========================================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/confirmed", method = RequestMethod.GET)
    @ApiOperation(value = "Get all confirmed documents", notes = "Returns all confirmed documents")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getConfirmedDocuments() {
        return documentService.getConfirmedDocuments();
    }

    //READ BY STATE (REJECTED) =========================================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/rejected", method = RequestMethod.GET)
    @ApiOperation(value = "Get all rejected documents", notes = "Returns all rejected documents")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getRejectedDocuments() {
        return documentService.getRejectedDocuments();
    }

    //READ BY STATE (SPECIFIED). Version_02 ============================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/bystate", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified state. V_02",
            notes = "Returns all document of specified state")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentStateV2(
            @ApiParam(value = "Document state", required = true)
            @RequestParam("state") DocumentState documentState) {
        return documentService.getAllDocumentsByDocumentState(documentState);
    }

    //READ BY STATE (SUBMITTED) AND BY USER (SPECIFIED) ================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/toreview", method = RequestMethod.GET)
    @ApiOperation(value = "Get submitted documents for user's (specified) to review",
            notes = "Returns submitted documents for user's (specified) to review")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getDocumentsByDocumentStateAndUser(
    ) {
        return documentService.getSubmittedDocumentForReviewing();
    }

    //READ BY TYPE. Version_02.1 (by J.C.) =============================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/bytype", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified type. V_02.1", notes = "Returns all document of specified type")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentTypeV21(
            @ApiParam(value = "Document type", required = true)
            @RequestParam String title) {
        return documentService.getAllDocumentsByDocumentType2(title);
    }

    //READ BY TYPE (SPECIFIED) AND BY AUTHOR (SPECIFIED) ===============================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/{username}/bytype", method = RequestMethod.GET)
    @ApiOperation(value = "Get user's (by specified username) documents (by specified type)",
            notes = "Returns user's (by specified username) documents (by specified type)")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentTypeAndUser(
            @ApiParam(value = "User username", required = true)
            @PathVariable String username,
            @ApiParam(value = "Document type", required = true)
            @RequestParam String documentTypeTitle) {
        return documentService.getAllDocumentsByDocumentTypeAndUsername(username, documentTypeTitle);
    }

    //READ All DOCUMENTS BY AUTHOR_USERNAME ============================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/docsbyuser", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified author username",
            notes = "Returns all document of specified author username")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByAuthorId(
           /* @ApiParam(value = "Author username", required = true)
            @PathVariable String username*/) {
        return documentService.getAllDocumentsByAuthorUsername(/*username*/);
    }

    // POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST

    //CREATE ===========================================================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add new document", notes = "Adds new document")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocument(
            @ApiParam(value = "Document data", required = true)
            @RequestBody final DocumentCreateCommand documentCreateCommand) {
        documentService.createDocument(documentCreateCommand);
    }

    // PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT

    //UPDATE BY ID =====================================================================================================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update document info by id", notes = "Update document by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateDocumentById(
            @ApiParam(value = "<--RequestBody", required = true)
            @RequestBody final DocumentUpdateCommand documentUpdateCommand,
            @ApiParam(value = "<--Id", required = true)
            @PathVariable Long id) {
        documentService.updateDocument(id, documentUpdateCommand);
    }

    //SET DOCUMENT STATE. Version_01 ===================================================================================
    // Permissions check is included (allows to change state only according to user permissions).
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/setstate", method = RequestMethod.PUT)
    @ApiOperation(value = "Set document state by id.", notes = "Set document state by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setDocumentStateByIdV1(
            @ApiParam(value = "<--RequestBody", required = true)
            @RequestBody final DocumentSetStateCommand documentSetStateCommand

            // this is for choosing from existing states (not necessary, but useful):
            //@ApiParam(value = "Document state", required = true)
            //@PathVariable DocumentState documentState
    ) {
        documentService.setDocumentStateV1(documentSetStateCommand);
    }

    /*
    //SET DOCUMENT STATE. Version_02 ===================================================================================
    // Permissions check isn't included (allows to change state to anny user).
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/setstate2", method = RequestMethod.PUT)
    @ApiOperation(value = "Set document state by id. V_02 (temporal)", notes = "Set document state by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setDocumentStateByIdV2(
            @ApiParam(value = "<--RequestBody", required = true)
            @RequestBody final DocumentSetStateCommand documentSetStateCommand

    ) {
        documentService.setDocumentStateV2(documentSetStateCommand);
    }
    */

    // DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE

    //DELETE ===========================================================================================================
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete document by id", notes = "Delete document by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDocumentById(
            @ApiParam(value = "Document id", required = true)
            @PathVariable Long id) {
        documentService.deleteDocument(id);
    }

}
