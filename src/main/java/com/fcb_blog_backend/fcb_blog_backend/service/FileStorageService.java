package com.fcb_blog_backend.fcb_blog_backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {
    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    public String storeFile(MultipartFile file) throws IOException {
        // Create the uploads directory if it doesn't exist
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate a unique filename
        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf(".")) : "";
        String filename = UUID.randomUUID().toString() + fileExtension;

        // Save the file
        Path filePath = uploadPath.resolve(filename);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }
}