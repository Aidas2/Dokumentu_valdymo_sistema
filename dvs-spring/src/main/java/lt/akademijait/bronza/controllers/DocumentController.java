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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "documents")
@RequestMapping(value = "/api/docs")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    //GET GET GET GET GET GET GET GET GET  GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET
    //GET GET GET GET GET GET GET GET GET  GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET GET

    //READ ALL =========================================================================================================
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all documents", notes = "Returns all documents")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    //READ BY ID =======================================================================================================
    // first and last "@PathVariable of type Long" - because only one is allowed by Spring
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get document info by Id", notes = "Returns document info by Id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentGetCommand getDocumentById(
            @ApiParam(value = "<-- Document id", required = true)
            @PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    //READ BY STATE (SUBMITTED) ========================================================================================
    @RequestMapping(value = "/submitted", method = RequestMethod.GET)
    @ApiOperation(value = "Get all submitted document", notes = "Returns all submitted document")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getSubmittedDocuments() {
        return documentService.getSubmittedDocuments();
    }

    //READ BY STATE (CONFIRMED) ========================================================================================
    @RequestMapping(value = "/confirmed", method = RequestMethod.GET)
    @ApiOperation(value = "Get all confirmed documents", notes = "Returns all confirmed documents")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getConfirmedDocuments() {
        return documentService.getConfirmedDocuments();
    }

    //READ BY STATE (REJECTED) =========================================================================================
    @RequestMapping(value = "/rejected", method = RequestMethod.GET)
    @ApiOperation(value = "Get all rejected documents", notes = "Returns all rejected documents")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getRejectedDocuments() {
        return documentService.getRejectedDocuments();
    }

    /* // commented because cause "Ambiguous ... " (maybe passed object covers also and String, and Long and so on)
    //READ BY STATE (BY SPECIFIED STATE). Version_01 ===================================================================
    //// first and last "@PathVariable of type object (or/and String ?, or/and Long?)" - because only one is allowed by Spring
    @RequestMapping(value = "/{documentState}", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified state. V_01", notes = "Returns all document of specified state")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentStateV1(
            @ApiParam(value = "Document state", required = true)
            @PathVariable DocumentState documentState) {
        return documentService.getAllDocumentsByDocumentState(documentState);
    }
    */

    //READ BY STATE (BY SPECIFIED STATE). Version_02 ===================================================================
    //@PathVariable --> @RequestParam
    @RequestMapping(value = "/bystate", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified state. V_02", notes = "Returns all document of specified state")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentStateV2(
            @ApiParam(value = "Document state", required = true)
            @RequestParam("state") DocumentState documentState) {
        return documentService.getAllDocumentsByDocumentState(documentState);
    }


    /* // Doesn't work :( !
    //READ BY TYPE. Version_01 =========================================================
    //object; @PathVariable
    @RequestMapping(value = "/documentbytype1", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified type. V_01", notes = "Returns all document of specified type")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentTypeV1(
            @ApiParam(value = "Document type", required = true)
            @RequestParam DocumentType documentType) {
        return documentService.getAllDocumentsByDocumentType1(documentType);

        //@PathVariable neveikia su objects, reikia rasyti @ReguestParam, o gal net @RequestBody
        //jei pasirenkam  @RequestBody, tada turi nebelikti {}
    }
    */

    //READ BY TYPE. Version_02.1 (by J.C.) =============================================
    //object --> String;
    // first and last "@PathVariable of type String" - because only one is allowed by Spring
    // wtf ?! also "ambiguous" with "@PathVariable of type Long" ???
    @RequestMapping(value = "/bytype", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified type. V_02.1", notes = "Returns all document of specified type")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentTypeV21(
            @ApiParam(value = "Document type", required = true)
            @RequestParam String title) {
        return documentService.getAllDocumentsByDocumentType2(title);
    }

    /* // commented as duplicates Version_02.1 (by J.C.)
    //READ BY TYPE. Version_02.2 =======================================================
    //object --> String; @PathVariable --> @RequestParam
    @RequestMapping(value = "/bytype02", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified type. V_02.2", notes = "Returns all document of specified type")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentTypeV22(
            @ApiParam(value = "Document type", required = true)
            @RequestParam String documentTypeTitle) {
        return documentService.getAllDocumentsByDocumentType2(documentTypeTitle);
    }
    */

    //READ BY TYPE (SPECIFIED) AND BY AUTHOR (SPECIFIED) ===============================================================
    @RequestMapping(value = "/{username}/bytype", method = RequestMethod.GET)
    @ApiOperation(value = "Get user's (by specified username) documents (by specified type)", notes = "Returns user's (by specified username) documents (by specified type)")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentTypeAndUser(
            @ApiParam(value = "User username", required = true)
            @PathVariable String username,
            @ApiParam(value = "Document type", required = true)
            @RequestParam String documentTypeTitle) {
        return documentService.getAllDocumentsByDocumentTypeAndUsername(username, documentTypeTitle);
    }

    //READ All DOCUMENTS BY AUTHOR_ID ==================================================================================
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified author id", notes = "Returns all document of specified author id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByAuthorId(
            @ApiParam(value = "Author username", required = true)
            @RequestParam String username) {
        return documentService.getAllDocumentsByAuthorUsername(username);
    }

    // POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST
    // POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST POST

    //CREATE ===========================================================================================================
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add new document", notes = "Adds new document")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocument(
            @ApiParam(value = "Document data", required = true)
            @RequestBody final DocumentCreateCommand documentCreateCommand) {
        documentService.createDocument(documentCreateCommand);
    }

    // PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT
    // PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT

    //UPDATE BY ID =====================================================================================================
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

    /* // commented as not necessary:

    //ASSIGN DOCUMENT_TYPE TO DOCUMENT =================================================================================
    @RequestMapping(value = "/{id}/{title}", method = RequestMethod.PUT)
    @ApiOperation(value = "Assign DocumentType to Document", notes = "Assigns DocumentType to Document")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void assignDocumentTypeToDocument(
            @ApiParam(value = "Document id", required = true)
            @PathVariable Long id, @PathVariable String title) {
        documentService.assignDocumentTypeToDocument(id, title);
    }
    */

    /*
    //SET DOCUMENT STATE. Version_01 (by my) ===========================================================================
    @RequestMapping(value = "/setstate1", method = RequestMethod.PUT)
    @ApiOperation(value = "Set document state by id. V_01", notes = "Set document state by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setDocumentStateByIdV1(
            @ApiParam(value = "<--RequestBody", required = true)
            @RequestBody final DocumentSetStateCommand documentSetStateCommand

            //@ApiParam(value = "Document id", required = true) // not necessary, because specified in DocumentSetStateCommand
            //@PathVariable Long id // not necessary, because specified in body (in DocumentSetStateCommand)

            // this is for choosing from existing states (also not necessary):
            //@ApiParam(value = "Document state", required = true)
            //@PathVariable DocumentState documentState
    ) {
        documentService.setDocumentStateV1(documentSetStateCommand);
    }

*/
    //SUGGESTION: pass not Body, but only state (because we want change only state, not others fields

    //SET DOCUMENT STATE. Version_02 (by J.C.) =========================================================================
    @RequestMapping(value = "/setstate2", method = RequestMethod.PUT)
    @ApiOperation(value = "Set document state by id. V_02", notes = "Set document state by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setDocumentStateByIdV2 (
            @ApiParam(value = "<--RequestBody", required = true)
            @RequestBody final DocumentSetStateCommand documentSetStateCommand

            // this is for choosing from existing states (also not necessary):
            //@ApiParam(value = "Document state", required = true)
            //@PathVariable DocumentState documentState
    ) {
                documentService.setDocumentStateV2(documentSetStateCommand);
    }

    // DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE
    // DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE

    //DELETE ===========================================================================================================
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete document by id", notes = "Delete document by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDocumentById(
            @ApiParam(value = "Document id", required = true)
            @PathVariable Long id) {
        documentService.deleteDocument(id);
    }

}
