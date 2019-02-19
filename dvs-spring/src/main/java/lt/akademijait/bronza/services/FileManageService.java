package lt.akademijait.bronza.services;

import lt.akademijait.bronza.dto.document.DocumentCreateCommand;
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

@Service
public class FileManageService {

    @Autowired
    private DocumentService documentService;

@Transactional
    public ResponseEntity uploadFiles(HttpServletRequest req,
                                      MultipartFile[] files, DocumentCreateCommand documentCreateCommand){

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

        File userDirectory = new File(currentAbsolutePath + fileSeparator + "uploaded-files" + fileSeparator + userName);
        userDirectory.mkdirs();
        for (MultipartFile file : files) {
            File fileToSave = new File(userDirectory, userID + "-" + getCurrentLocalDateTimeStamp() + "-" + file.getOriginalFilename());
//            fileToSave.mkdirs();

            try {
                file.transferTo(fileToSave); //Transfer or Saving in local memory
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        documentService.createDocument(documentCreateCommand);


        return null;
    }
    public String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS"));
    }

}
