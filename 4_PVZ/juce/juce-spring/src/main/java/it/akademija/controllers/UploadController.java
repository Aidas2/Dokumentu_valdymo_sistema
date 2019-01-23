package it.akademija.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public void uploadImageToServer(@RequestParam("image") MultipartFile file) throws IOException {
        logger.warn("Uploading file -> {}",file);
        logger.warn("File name -> {}",file.getOriginalFilename());
        logger.warn("File size -> {}",file.getSize());

        File fileToSave = new File("/test/" + file.getOriginalFilename());
        logger.warn("Saving to = {}",fileToSave.getAbsolutePath());
        //copy file content from received file to new local file
        file.transferTo(fileToSave);
    }
}
