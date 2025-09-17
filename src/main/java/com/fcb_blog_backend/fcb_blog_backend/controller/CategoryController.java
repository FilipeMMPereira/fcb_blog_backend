package com.fcb_blog_backend.fcb_blog_backend.controller;

import com.fcb_blog_backend.fcb_blog_backend.dtos.category.CategoryCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.global.ErrorDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.model.CategoryModel;
import com.fcb_blog_backend.fcb_blog_backend.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name= "Categories", description = "Categories Management")
@RequestMapping("/public/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    @Operation(summary = "Create a new category", description = "Add a new category in the system")
    @ApiResponse(responseCode = "201", description = "Category created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDTO.class)))
    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class)))
    @ApiResponse(responseCode = "409", description = "Request conflict", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class)))
    public ResponseEntity<MessageDTO> create(@RequestBody @Valid CategoryCreateReqDTO body){
        return categoryService.create(body);
    }
    @GetMapping("/")
    @Operation(summary = "Get all categories", description = "Return all categories to client")
    public ResponseEntity<List<CategoryModel>> getAll(){
        return categoryService.getAll();
    }
}
