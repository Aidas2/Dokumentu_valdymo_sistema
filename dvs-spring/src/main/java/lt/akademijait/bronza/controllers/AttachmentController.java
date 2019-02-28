package lt.akademijait.bronza.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.akademijait.bronza.dto.attachment.AttachmentCreateCommand;
import lt.akademijait.bronza.dto.attachment.AttachmentGetCommand;
import lt.akademijait.bronza.services.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "attachments")
@RequestMapping(value = "/api/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;


    //READ =============================================================================================================
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all attachments", notes = "Returns all attachments")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<AttachmentGetCommand> getAttachments() {
        return attachmentService.getAttachments();
    }

    //READ BY ID =======================================================================================================
    //@PathVariable --> @RequestParam
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get attachments by id", notes = "Returns attachments by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AttachmentGetCommand getAttachmentById(
            @ApiParam(value = "Attachment id", required = true)
            @RequestParam Long id) {
        return attachmentService.getAttachmentById(id);
    }

    //READ BY TITLE ====================================================================================================
    //@PathVariable --> @RequestParam
    @RequestMapping(value="/{title}", method = RequestMethod.GET)
    @ApiOperation(value = "Get attachments by title", notes = "Returns attachments by title")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AttachmentGetCommand getAttachmentsByTitle(
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



    //DELETE ===========================================================================================================
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete attachment", notes = "Delete attachments by id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAttachment(
            @ApiParam(value = "Attachment id", required = true)
            @PathVariable Long id) {
        attachmentService.deleteAttachment(id);
    }

}
