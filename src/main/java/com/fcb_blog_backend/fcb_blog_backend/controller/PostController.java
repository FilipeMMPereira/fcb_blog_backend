package com.fcb_blog_backend.fcb_blog_backend.controller;

import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.post.PostCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.service.PostService;
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
@Tag(name = "Posts", description = "Posts Management")
@RequestMapping("public/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    @Operation(summary = "Create a new post", description = "Add a new post in the system")
    ResponseEntity<MessageDTO> createPost(@RequestBody @Valid PostCreateReqDTO body){
        return postService.create(body);
    }
}
