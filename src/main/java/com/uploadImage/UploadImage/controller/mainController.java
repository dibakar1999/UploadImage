package com.uploadImage.UploadImage.controller;

import com.uploadImage.UploadImage.Services.fileService;
import com.uploadImage.UploadImage.payLoad.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class mainController {
    @Autowired
    private fileService fileService;
    @Value("${UploadImage.image}")
    private String path;
    @PostMapping("/upload")
    public ResponseEntity<FileResponse> UploadFile(@RequestParam("image") MultipartFile file) {
        String fileName = null;
        try {
            fileName = this.fileService.uploadImage(path, file);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null,"something went wrong!!"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new FileResponse(fileName,"image is successfully uploaded"),HttpStatus.OK);
    }
}
