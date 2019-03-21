package lt.akademijait.bronza.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.attachment.AttachmentCreateCommand;
import lt.akademijait.bronza.dto.attachment.AttachmentGetCommand;
import lt.akademijait.bronza.services.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "attachments")
@RequestMapping(value = "/api/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;


    //READ =============================================================================================================
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all attachments", notes = "Returns all attachments")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<AttachmentGetCommand> getAttachments() {
        return attachmentService.getAttachments();
    }



    //READ BY ID Version_01 ============================================================================================
    //@PathVariable
    @RequestMapping(value="/byid/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get attachments by id. V_01", notes = "Returns attachments by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AttachmentGetCommand getAttachmentByIdV1(
            @ApiParam(value = "Attachment id", required = true)
            @PathVariable Long id) {
        return attachmentService.getAttachmentById(id);
    }

    //READ BY ID Version_02 ============================================================================================
    //@PathVariable --> @RequestParam
    @RequestMapping(value="/byid", method = RequestMethod.GET)
    @ApiOperation(value = "Get attachments by id.V_02", notes = "Returns attachments by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AttachmentGetCommand getAttachmentByIdV2(
            @ApiParam(value = "Attachment id", required = true)
            @RequestParam Long id) {
        return attachmentService.getAttachmentById(id);
    }



    //READ BY TITLE Version_01 =========================================================================================
    //@PathVariable
    @RequestMapping(value="/bytitle/{title}", method = RequestMethod.GET)
    @ApiOperation(value = "Get attachments by title. V_01", notes = "Returns attachments by title")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AttachmentGetCommand getAttachmentsByTitleV1(
            @ApiParam(value = "Attachment title", required = true)
            @PathVariable String title) {
        return attachmentService.getAttachmentsByTitle(title);
    }

    //READ BY TITLE Version_02 =========================================================================================
    //@PathVariable --> @RequestParam
    @RequestMapping(value="/bytitle", method = RequestMethod.GET)
    @ApiOperation(value = "Get attachments by title. V_02", notes = "Returns attachments by title")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AttachmentGetCommand getAttachmentsByTitleV2(
            @ApiParam(value = "Attachment title", required = true)
            @RequestParam String title) {
        return attachmentService.getAttachmentsByTitle(title);
    }



    //CREATE ===========================================================================================================
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Add new attachment", notes = "Adds new attachment")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAttachments (
            @ApiParam(value = "Attachment data", required = true)
            @RequestBody final AttachmentCreateCommand attachmentCreateCommand) {
        attachmentService.createAttachment(attachmentCreateCommand);
    }

    //UPDATE ===========================================================================================================
    //There is no need to update attachment (not logic, makes no sense).



    //DELETE ===========================================================================================================
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "delete//{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete attachment", notes = "Delete attachments by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAttachment(
            @ApiParam(value = "Attachment id", required = true)
            @PathVariable Long id) {
        attachmentService.deleteAttachment(id);
    }

}
