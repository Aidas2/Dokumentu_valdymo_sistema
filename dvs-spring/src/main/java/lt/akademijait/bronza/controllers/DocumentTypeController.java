package lt.akademijait.bronza.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.documenttype.DocumentTypeCreateCommand;
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

    //READ =============================================================================================================
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all documents types", notes = "Returns all documents types")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DocumentTypeGetCommand> getDocumentsTypes() {
        return documentTypeService.getDocumentTypes();
    }

    //READ By ID Version_01 ============================================================================================
    //@PathVariable
    @RequestMapping(value="/byid/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get documents type by id. V_01", notes = "Returns document type by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentTypeGetCommand getDocumentTypeByIdV1(
            @ApiParam(value = "Document type id", required = true)
            @RequestParam Long id) {
        return documentTypeService.getDocumentTypeById(id);
    }

    //READ By ID Version_02 ============================================================================================
    //@PathVariable --> @RequestParam
    @RequestMapping(value="/byid", method = RequestMethod.GET)
    @ApiOperation(value = "Get documents type by id. V_02", notes = "Returns document type by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentTypeGetCommand getDocumentTypeByIdV2(
            @ApiParam(value = "Document type id", required = true)
            @RequestParam Long id) {
        return documentTypeService.getDocumentTypeById(id);
    }

    //READ By TITLE Version_01 =========================================================================================
    //@PathVariable. Remark: for some reason caused "ambiguous" with method getDocumentTypeByIdV1 (in //READ By ID Version_01). Fixed by: value="/{id}" --> value="/{id}/byid",
    @RequestMapping(value="/bytitle/{title}", method = RequestMethod.GET)
    @ApiOperation(value = "Get documents type by title. V_01", notes = "Returns document type by title")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentTypeGetCommand getDocumentsTypeByTitleV1(
            @ApiParam(value = "Document type title", required = true)
            @PathVariable String title) {
        return documentTypeService.getDocumentsTypeByTitle(title);
    }

    //READ By TITLE Version_02 =========================================================================================
    //@PathVariable --> @RequestParam
    @RequestMapping(value="/bytitle", method = RequestMethod.GET)
    @ApiOperation(value = "Get documents type by title. V_02", notes = "Returns document type by title")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DocumentTypeGetCommand getDocumentsTypeByTitleV2(
            @ApiParam(value = "Document type title", required = true)
            @RequestParam String title) {
        return documentTypeService.getDocumentsTypeByTitle(title);
    }

    //Gali padaryt kontrollerį, kuris grąžintų tik dokumentų tipus, kuriuos useris gali submittinti?
    //READ BY STATE (READY FOR SUBMITTING) AND USER (SPECIFIED)
    @RequestMapping(value = "/{username}/readyForSubmitting", method = RequestMethod.GET)
    @ApiOperation(value = "Get document types (ready for submiting) for specified user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String> getTypesTitlesOfSubmittingUser (
            @ApiParam(value = "User username", required = true)
            @PathVariable String username) {
        return documentTypeService.getDocumentTypeTitlesOfSubmittingUser(username);
    }

    //CREATE ===========================================================================================================
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add new document type", notes = "Adds new document type")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDocumentType (
            @ApiParam(value = "Document type data", required = true)
            @RequestBody final DocumentTypeCreateCommand documentTypeCreateCommand) {
        documentTypeService.createDocumentType(documentTypeCreateCommand);
    }

    //UPDATE ===========================================================================================================
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update document type info", notes = "Update document type by id")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateDocumentTypeById(
            @ApiParam(value = "Document type id", required = true)
            @RequestBody final DocumentTypeCreateCommand documentTypeCreateCommand,
            @PathVariable Long id) {
        documentTypeService.updateDocumentType(id, documentTypeCreateCommand);
    }

    //DELETE Version_01 ================================================================================================
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete document type. V_01", notes = "Delete document type by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDocumentTypeByIdV1(
            @ApiParam(value = "Document type id", required = true)
            @PathVariable Long id) {
        documentTypeService.deleteDocumentType(id);
    }

    //DELETE Version_02 ================================================================================================
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete document type. V_02", notes = "Delete document type by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDocumentTypeByIdV2(
            @ApiParam(value = "Document type id", required = true)
            @RequestParam Long id) {
        documentTypeService.deleteDocumentType(id);
    }

}
