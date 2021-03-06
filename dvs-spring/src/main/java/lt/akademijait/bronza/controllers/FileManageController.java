package lt.akademijait.bronza.controllers;

import lt.akademijait.bronza.dto.document.DocumentCreateCommand;
import lt.akademijait.bronza.repositories.AttachmentRepository;
import lt.akademijait.bronza.repositories.DocumentRepository;
import lt.akademijait.bronza.services.FileManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class FileManageController {


    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private FileManageService fileManageService;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;


    //DOCUMENT DOWNLOAD
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping(value = "/files")
    @ResponseBody
    public ResponseEntity downloadFile(@RequestParam Long documentId) throws UnsupportedEncodingException {
        Resource file = applicationContext.getResource("file:" + documentRepository.findById(documentId).orElse(null).getPath());

//        String fileNameEncoded = URLEncoder.encode(file.getFilename(), "UTF-8");
//        fileNameEncoded = URLDecoder.decode(fileName, "ISO8859_1");
//        response.setContentType("application/x-msdownload");
//        response.setHeader("Content-disposition", "attachment; filename="+ fileNameEncoded);


        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename=" + file.getFilename());
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename=" + URLEncoder.encode(file.getFilename(),
//                    java.nio.charset.StandardCharsets.UTF_8.toString()));
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename=" + fileNameEncoded);

            headers.add("Access-Control-Expose-Headers", HttpHeaders.CONTENT_DISPOSITION + ","
                    + HttpHeaders.CONTENT_LENGTH);
            headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream; charset=UTF-8");
//            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return ResponseEntity.ok().headers(headers).body(file);
        }
        return ResponseEntity.notFound().build();

    }

    //    DOCUMENT PREVIEW
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/files/view")
    public ResponseEntity<Resource> previewFile(@RequestParam Long documentId, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = applicationContext.getResource("file:" + documentRepository.findById(documentId).orElse(null).getPath());

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    //ATTACHMENTS DOWNLOAD
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping(value = "files/attachments")
    @ResponseBody
    public ResponseEntity downloadAttachment(@RequestParam Long attachmentId) throws UnsupportedEncodingException {
        Resource file = applicationContext.getResource("file:" + attachmentRepository.findById(attachmentId)
                .orElse(null).getPath());

//        String fileNameEncoded = URLEncoder.encode(file.getFilename(), "UTF-8");
//        fileNameEncoded = URLDecoder.decode(fileName, "ISO8859_1");
//        response.setContentType("application/x-msdownload");
//        response.setHeader("Content-disposition", "attachment; filename="+ fileNameEncoded);


        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename=" + file.getFilename());
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename=" + URLEncoder.encode(file.getFilename(),
//                    java.nio.charset.StandardCharsets.UTF_8.toString()));
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename=" + fileNameEncoded);

            headers.add("Access-Control-Expose-Headers", HttpHeaders.CONTENT_DISPOSITION + ","
                    + HttpHeaders.CONTENT_LENGTH);
            headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream; charset=UTF-8");
//            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return ResponseEntity.ok().headers(headers).body(file);
        }
        return ResponseEntity.notFound().build();

    }

    //    ATTACHMENT PREVIEW
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/files/attachments/view")
    public ResponseEntity<Resource> previewAttachment(@RequestParam Long attachmentId, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = applicationContext.getResource("file:" + attachmentRepository.findById(attachmentId)
                .orElse(null).getPath());

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    //FILES UPLOAD
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/files", method = RequestMethod.POST,
            consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<String> mutipleFileUpload(
            @RequestParam(value = "file", required = false) MultipartFile[] files,
            @RequestParam(value = "docData") String docData)
            throws IOException {
        fileManageService.uploadFiles(files, docData);

        return new ResponseEntity<String>("Files were uploaded", HttpStatus.CREATED);
    }

    public String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS"));
    }
}


