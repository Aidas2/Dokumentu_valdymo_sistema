package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.attachment.AttachmentCreateCommand;
import lt.akademijait.bronza.dto.attachment.AttachmentGetCommand;
import lt.akademijait.bronza.entities.Attachment;
import lt.akademijait.bronza.repositories.AttachmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttachmentService {

    @Autowired
   private AttachmentRepository attachmentRepository;


    private  final static Logger logger = LoggerFactory.getLogger(AttachmentService.class);

    //GET ALL ==========================================================================================================
    @Transactional(readOnly = true)
    public List<AttachmentGetCommand> getAttachments() {
        logger.info("Geted all attachments");
        return attachmentRepository.findAll()
                .stream()
                .map((attachment) -> new AttachmentGetCommand(
                        attachment.getId(),
                        attachment.getTitle(),
                        attachment.getPath()
                )).collect(Collectors.toList());
    }

    //GET BY ID ========================================================================================================
    @Transactional(readOnly = true)
    public AttachmentGetCommand getAttachmentById(Long id) {
        Attachment attachment = attachmentRepository.findById(id).orElse(null);
        logger.info("Geted all attachments by this id: " + id);
        return new AttachmentGetCommand(
                attachment.getId(),
                attachment.getTitle(),
                attachment.getPath()
        );
    }

    //GET BY TITLE =====================================================================================================
    @Transactional(readOnly = true)
    public AttachmentGetCommand getAttachmentsByTitle(String title) {
        Attachment attachment = attachmentRepository.findByTitle(title);
        logger.info("Geted all attachments by this title: " + title);
        return new AttachmentGetCommand(
                attachment.getId(),
                attachment.getTitle(),
                attachment.getPath()
        );
    }

    //CREATE ===========================================================================================================
    @Transactional
    public void createAttachment (AttachmentCreateCommand attachmentCreateCommand) {
        Attachment newAttachment = new Attachment();
        newAttachment.setTitle(attachmentCreateCommand.getTitle());
        attachmentRepository.save(newAttachment);
        logger.info("New attachment created - {} Everything is OK", attachmentCreateCommand.getTitle());
    }

    //UPDATE ===========================================================================================================
    //There is no need to update attachment (not logic, makes no sense).

    //DELETE ===========================================================================================================
    @Transactional
    public void deleteAttachment(Long id) {
        attachmentRepository.deleteById(id);
        logger.info("Attachment with id = " + id + " was deleted");
    }
}


