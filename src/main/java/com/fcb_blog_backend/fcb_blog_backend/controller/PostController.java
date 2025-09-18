package com.fcb_blog_backend.fcb_blog_backend.controller;

import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.post.PostCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.model.CategoryModel;
import com.fcb_blog_backend.fcb_blog_backend.model.PostModel;
import com.fcb_blog_backend.fcb_blog_backend.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Posts", description = "Posts Management")
@RequestMapping("public/post")
@CrossOrigin(origins = "*")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    @Operation(summary = "Create a new post", description = "Add a new post with an image to the system")
    ResponseEntity<MessageDTO> createPost(
        @ModelAttribute @Valid PostCreateReqDTO body
    ) {
        return postService.create(body);
    }
    @GetMapping("/")
    @Operation(summary = "Get all posts", description = "Return all posts to client")
    public ResponseEntity<List<PostModel>> getAll(){
        return postService.getAll();
    }
}
