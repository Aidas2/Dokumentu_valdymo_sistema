package lt.akademijait.bronza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping(value = "/files-multi/{filename:.+}")
    @ResponseBody
    public ResponseEntity serveFile(@PathVariable String fileName) {
        Resource file = applicationContext.getResource("file:/home/paulius/Desktop/" + fileName);
        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"");
            headers.add("Access-Control-Expose-Headers", HttpHeaders.CONTENT_DISPOSITION + ","
                    + HttpHeaders.CONTENT_LENGTH);
            return ResponseEntity.ok().headers(headers).body(file);
        }
        return ResponseEntity.notFound().build();

    }


    @RequestMapping(value = "/files-multi", method = RequestMethod.POST,
            consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity mutipleFileUpload(HttpServletRequest req,
                                            @RequestParam(value = "file", required = false) MultipartFile[] files)
            throws IOException {

        String userDirectory = "/user1-dir";
        File directory = new File("/home/paulius/testupload-multi" + userDirectory);
        directory.mkdirs();

        for (MultipartFile file : files) {
            File fileToSave = new File(directory, "multi-" + file.getOriginalFilename());
//            fileToSave.mkdirs();

            try {
                file.transferTo(fileToSave); //Transfer or Saving in local memory
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }
}
