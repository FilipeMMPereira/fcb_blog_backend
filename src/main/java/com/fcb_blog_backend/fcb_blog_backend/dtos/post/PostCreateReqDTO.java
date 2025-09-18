package com.fcb_blog_backend.fcb_blog_backend.dtos.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record PostCreateReqDTO(
    @NotBlank(message = "Title is required") 
    String title,
    
    @NotBlank(message = "Content is required") 
    String content,
    
    @NotNull(message = "Image is required") 
    MultipartFile image,
    
    @NotNull(message = "Category ID is required") 
    int categoryId) {}
