package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.document.DocumentCreateCommand;
import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.repositories.DocumentRepository;
import lt.akademijait.bronza.repositories.DocumentTypeRepository;
import lt.akademijait.bronza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    @Transactional
    public ResponseEntity uploadFiles(HttpServletRequest req,
                                      MultipartFile[] files, DocumentCreateCommand documentCreateCommand) {

        //this is used to get the current absolute path. Later the temp file is deleted
        File tempFile = new File("temptest9954332543.txt");
        boolean bool = false;
        try {
            bool = tempFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("TempTestFile created: " + bool);
        String fileSeparator = System.getProperty("file.separator");
        Path currentAbsolutePath = Paths.get("temptest9954332543.txt").toAbsolutePath().getParent();
        tempFile.delete();


        String userName = "/user1-dir";
        int userID = 2;

        String filePath = null;
        File userDirectory = new File(currentAbsolutePath + fileSeparator + "uploaded-files" + fileSeparator + userName);
        userDirectory.mkdirs();
        for (int i=0; i< files.length;i++) {

            File fileToSave = new File(userDirectory, userID + "-" + getCurrentLocalDateTimeStamp() + "-" + files[i].getOriginalFilename());
//            fileToSave.mkdirs();
            if(i==0){
                filePath = fileToSave.getAbsolutePath();
            }

            try {
                files[i].transferTo(fileToSave); //Transfer or Saving in local memory
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Document newDocument = new Document();
        newDocument.setCreationDate(new Date());

        //shouldn't set Author directly from Object ir Document Entity, instead use String field from DocumentCreateCommand
        User user = userRepository.findByUsername(documentCreateCommand.getUsername());
        newDocument.setAuthor(user);

        DocumentType documentType = documentTypeRepository.findByTitle(documentCreateCommand.getDocumentTypeTitle());
        newDocument.setDocumentType(documentType);

        newDocument.setTitle(documentCreateCommand.getTitle());
        newDocument.setDescription(documentCreateCommand.getDescription());
        newDocument.setPath(filePath);
        documentRepository.save(newDocument);

        return null;
    }

    public String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS"));
    }

}
