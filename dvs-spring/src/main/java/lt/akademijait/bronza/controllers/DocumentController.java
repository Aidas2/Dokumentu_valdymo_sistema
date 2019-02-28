package lt.akademijait.bronza.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.document.DocumentCreateCommand;
import lt.akademijait.bronza.dto.document.DocumentGetCommand;
import lt.akademijait.bronza.dto.document.DocumentSetStateCommand;
import lt.akademijait.bronza.dto.document.DocumentUpdateCommand;
import lt.akademijait.bronza.entities.DocumentType;
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

    //READ ALL =========================================================================================================
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all documents", notes = "Returns all documents")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    //READ BY ID =======================================================================================================
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get document by Id", notes = "Returns document info")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentGetCommand getDocumentById(
            @ApiParam(value = "Document id", required = true)
            @PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    //READ SUBMITTED ===================================================================================================
    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    @ApiOperation(value = "Get all submitted document", notes = "Returns all submitted document")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getSubmittedDocuments() {
        return documentService.getSubmittedDocuments();
    }

    //READ TO BE REVIEWED ==============================================================================================
    @RequestMapping(value = "/review", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document to review", notes = "Returns all document to review")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getDocumentsToReview() {
        return documentService.getDocumentsToReview();
    }




    //READ All DOCUMENTS OF SPECIFIC DOCUMENT_STATE. Version_01 ========================================================
    @RequestMapping(value = "/documentbystate/{documentState}", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified state. V_01", notes = "Returns all document of specified state")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentStateV1(
            @ApiParam(value = "Document state", required = true)
            @PathVariable DocumentState documentState) {
        return documentService.getAllDocumentsByDocumentState(documentState);
    }

    //READ All DOCUMENTS OF SPECIFIC DOCUMENT_STATE. Version_02 ========================================================
    //@PathVariable --> @RequestParam
    @RequestMapping(value = "/documentbystate", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified state. V_02", notes = "Returns all document of specified state")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentStateV2(
            @ApiParam(value = "Document state", required = true)
            @RequestParam DocumentState documentState) {
        return documentService.getAllDocumentsByDocumentState(documentState);
    }





    //READ All DOCUMENTS OF SPECIFIC DOCUMENT_TYPE. Version_01 =========================================================
    @RequestMapping(value = "/documentbytype/{documentType}", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified type. V_01", notes = "Returns all document of specified type")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentTypeV1(
            @ApiParam(value = "Document type", required = true)
            @PathVariable DocumentType documentType) {
        return documentService.getAllDocumentsByDocumentType1(documentType);
    }


    //READ All DOCUMENTS OF SPECIFIC DOCUMENT_TYPE. Version_02.1 =========================================================
    //object --> String; @PathVariable --> @RequestParam
    @RequestMapping(value = "/documentbytype", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified type. V_02.1", notes = "Returns all document of specified type")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentTypeV21(
            @ApiParam(value = "Document type", required = true)
            @RequestParam String documentTypeTitle) {
        return documentService.getAllDocumentsByDocumentType2(documentTypeTitle);
    }
/* temporaly commented as cause "ambiguous" with Version_01
    //READ All DOCUMENTS OF SPECIFIC DOCUMENT_TYPE. Version_02.2 (by J.C.) ===============================================
    //@PathVariable comes back :) Together mandatory comes and {} in first line (@RequestMapping) !!!
    @RequestMapping(value = "/documentbytype/{title}", method = RequestMethod.GET)
    @ApiOperation(value = "Get all document of specified type. V_02.2", notes = "Returns all document of specified type")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByDocumentTypeV22(
            @ApiParam(value = "Document type", required = true)
            @PathVariable String title) {
        return documentService.getAllDocumentsByDocumentType2(title);
    }
*/





    //READ All DOCUMENTS OF SPECIFIC AUTHOR_ID =========================================================================
    @RequestMapping(value = "/{authorId}/docs", method = RequestMethod.GET)

    @ApiOperation(value = "Get all document of specified author id", notes = "Returns all document of specified author id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentGetCommand> getAllDocumentsByAuthorId(
            @ApiParam(value = "Author ID", required = true)
            @PathVariable Long authorId) {
        return documentService.getAllDocumentsByAuthorId(authorId);
    }

    //CREATE ===========================================================================================================
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add new document", notes = "Adds new document")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocument(
            @ApiParam(value = "Document data", required = true)
            @RequestBody final DocumentCreateCommand documentCreateCommand) {
        documentService.createDocument(documentCreateCommand);
    }

    //UPDATE ===========================================================================================================
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update document info", notes = "Update document by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateDocumentById(
            @ApiParam(value = "Document id", required = true)
            @RequestBody final DocumentUpdateCommand documentUpdateCommand,
            @PathVariable Long id) {
        documentService.updateDocument(id, documentUpdateCommand);
    }


    //DELETE ===========================================================================================================
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete document", notes = "Delete document by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDocumentById(
            @ApiParam(value = "Document id", required = true)
            @PathVariable Long id) {
        documentService.deleteDocument(id);
    }

    /*
    // commented as not necessary;

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


    //SET DOCUMENT STATE. Version_01 (by my) ===========================================================================
    @RequestMapping(value = "/{id}/setState", method = RequestMethod.PUT)
    @ApiOperation(value = "Set document state V_01", notes = "Set document state by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setDocumentStateByIdV1(
            //@ApiParam(value = "Document id", required = true)
            @RequestBody final DocumentSetStateCommand documentSetStateCommand
            //@PathVariable Long id

//            @ApiParam(value = "Document state", required = true)
//            @PathVariable DocumentState documentState

    ) {
        documentService.setDocumentStateV1(documentSetStateCommand);
    }


    //SET DOCUMENT STATE. Version_02 (by J.C.) =========================================================================
    @RequestMapping(value = "/setState", method = RequestMethod.PUT)
    @ApiOperation(value = "Set document state. V_02", notes = "Set document state by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setDocumentStateByIdV2 (
            @RequestBody final DocumentSetStateCommand documentSetStateCommand
            //@ApiParam(value = "Document state", required = true)
            //@PathVariable DocumentState documentState
    ) {
                documentService.setDocumentStateV2(documentSetStateCommand);
    }

}
