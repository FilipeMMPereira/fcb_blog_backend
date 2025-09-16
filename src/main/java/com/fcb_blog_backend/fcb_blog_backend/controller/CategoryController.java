package com.fcb_blog_backend.fcb_blog_backend.controller;

import com.fcb_blog_backend.fcb_blog_backend.dtos.category.CategoryCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name= "Categories", description = "Categories Management")
@RequestMapping("/public/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    @Operation(summary = "Create a new user", description = "Add a new user in the system")
    public ResponseEntity<MessageDTO> create(@RequestBody @Valid CategoryCreateReqDTO body){
        return categoryService.create(body);
    }
}
