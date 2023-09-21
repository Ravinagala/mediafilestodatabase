package com.example.mediafilestodatabase.service;

import com.example.mediafilestodatabase.entities.ImageData;
import com.example.mediafilestodatabase.repos.ImageDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class ImageDataService {
    @Autowired
    ImageDataRepo imageDataRepo;

    private final String FOLDER_PATH = "C:/Users/Ravi/Desktop/photos/";

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filepath = FOLDER_PATH + file.getOriginalFilename();

        ImageData imageData = imageDataRepo.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filepath(filepath).build());

        file.transferTo(new File(filepath));
        if(imageData != null){
            return "file uploaded successfully:"+filepath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<ImageData> imageData = imageDataRepo.findByName(fileName);
        String filepath = imageData.get().getFilepath();
        byte[] image = Files.readAllBytes(new File(filepath).toPath());
        return image;
    }
}
