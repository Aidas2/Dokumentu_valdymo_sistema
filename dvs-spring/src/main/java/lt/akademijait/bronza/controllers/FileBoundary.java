package lt.akademijait.bronza.controllers;

import org.apache.http.entity.FileEntity;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.apache.commons.io.filefilter.DirectoryFileFilter.DIRECTORY;

@RestController
@RequestMapping("/files/")
@CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
public class FileBoundary {

    static final String DIRECTORY = "/home/paulius/Dokumentu_valdymo_sistema/dvs-spring/uploaded-files/user1-dir/";
    private static final String DEFAULT_FILE_NAME = "java.txt";

    @GetMapping
    public ResponseEntity<byte[]> getFile(HttpServletRequest req) throws IOException {

        File file = new File(DIRECTORY + "java.txt" );
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));



        byte[] array = Files.readAllBytes(file.toPath());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.valueOf(req.getContentType()));
//        header.setContentLength(req.ge.length);
        header.set("Content-Disposition", "attachment; filename=" + file.getName());
        return new ResponseEntity<>(array, header, HttpStatus.OK);
    }

}