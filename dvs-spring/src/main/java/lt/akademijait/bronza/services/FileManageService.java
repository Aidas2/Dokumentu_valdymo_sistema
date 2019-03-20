package lt.akademijait.bronza.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.akademijait.bronza.dto.document.DocumentCreateCommand;
import lt.akademijait.bronza.entities.Attachment;
import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.enums.DocumentState;
import lt.akademijait.bronza.repositories.AttachmentRepository;
import lt.akademijait.bronza.repositories.DocumentRepository;
import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class FileManageService {

    @Autowired
    private DocumentService documentService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Transactional
    public ResponseEntity<String> uploadFiles(
            MultipartFile[] files, String docData) {
        String username = null;

        //this is used to get the current absolute path. Later the temp file is deleted
        File tempFile = new File("temptest9954332543.txt");
        boolean bool = false;
        try {
            bool = tempFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("TempTestFile created: " + bool);
        String fileSeparator = System.getProperty("file.separator");
        Path currentAbsolutePath = Paths.get("temptest9954332543.txt").toAbsolutePath().getParent();
        tempFile.delete();

        ObjectMapper objectMapper = new ObjectMapper();
        DocumentCreateCommand documentCreateCommand = new DocumentCreateCommand();
        try {
            documentCreateCommand = objectMapper.readValue(docData, DocumentCreateCommand.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        long userID = userRepository.findByUsername(documentCreateCommand.getUsername()).getId();
        String documentPath = null;
        Document newDocument = new Document();
        newDocument.setCreationDate(new Date());
        newDocument.setAuthor(userRepository.findByUsername(getLoggedInUsername()));
//        newDocument.setAuthor(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        newDocument.setDocumentType(documentTypeRepository.findByTitle(documentCreateCommand.getDocumentTypeTitle()));
        newDocument.setTitle(documentCreateCommand.getTitle());
        newDocument.setDescription(documentCreateCommand.getDescription());
        List<Attachment> attachments = new ArrayList<>();
        int attachmentNumber = 1;


        for (int i = 0; i < files.length; i++) {

            File userDirectory = new File(currentAbsolutePath + fileSeparator + "uploaded-files" + fileSeparator
                    + getLoggedInUsername());
            userDirectory.mkdirs();

            if (files[i].getContentType().equalsIgnoreCase("application/pdf")) {

                File fileToSave = new File(userDirectory, userID + "-" +
                        (i == 0 ? "" : "att" + attachmentNumber + "-") + getCurrentLocalDateTimeStamp() + "-"
                        + files[i].getOriginalFilename());
//                String attachmentPath=null;

                if (i == 0) {
                    documentPath = fileToSave.getAbsolutePath();
                } else {
                    Attachment attachment = new Attachment("Priedas nr." + attachmentNumber, fileToSave.getAbsolutePath());
                    attachmentNumber++;
                    attachmentRepository.save(attachment);
                    attachments.add(attachment);

                }
                try {
                    files[i].transferTo(fileToSave);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else throw new IllegalArgumentException("This type of a file cannot be uploaded");


        }
        newDocument.setDocumentState(DocumentState.CREATED);
        newDocument.setPath(documentPath);
        newDocument.setAttachments(attachments);
        documentRepository.save(newDocument);


        return new ResponseEntity<String>("Files were uploaded and a new document was created", HttpStatus.CREATED);
    }

    public String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS"));
    }

    public String getLoggedInUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return null;
    }

}
