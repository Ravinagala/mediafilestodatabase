package com.example.mediafilestodatabase.controller;

import com.example.mediafilestodatabase.service.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageDataController {

    @Autowired
    ImageDataService imageDataService;

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = imageDataService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/getImage/{fileName}")
    public ResponseEntity<?> downloadImageFromFile(@PathVariable String fileName) throws IOException {
        byte[] imageData = imageDataService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
