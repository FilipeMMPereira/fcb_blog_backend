package com.fcb_blog_backend.fcb_blog_backend.controller;

import com.fcb_blog_backend.fcb_blog_backend.dtos.comment.CommentCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.model.CommentModel;
import com.fcb_blog_backend.fcb_blog_backend.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Comments", description = "Comments Management")
@RequestMapping("public/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    @Operation(summary = "Create a new comment", description = "Add a new comment to a post")
    public ResponseEntity<MessageDTO> createComment(@RequestBody @Valid CommentCreateReqDTO body) {
        return commentService.create(body);
    }

    @GetMapping
    @Operation(summary = "Get all comments", description = "Retrieve all comments from the system")
    public ResponseEntity<List<CommentModel>> getAllComments() {
        return commentService.getAll();
    }

    @GetMapping("/post/{postId}")
    @Operation(summary = "Get post comments", description = "Retrieve all comments for a specific post")
    public ResponseEntity<List<CommentModel>> getPostComments(@PathVariable int postId) {
        return commentService.getByPostId(postId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a comment", description = "Remove a comment from the system")
    public ResponseEntity<MessageDTO> deleteComment(@PathVariable int id) {
        return commentService.delete(id);
    }
}