package com.fcb_blog_backend.fcb_blog_backend.service;

import com.fcb_blog_backend.fcb_blog_backend.dtos.comment.CommentCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.model.CommentModel;
import com.fcb_blog_backend.fcb_blog_backend.model.PostModel;
import com.fcb_blog_backend.fcb_blog_backend.model.UserModel;
import com.fcb_blog_backend.fcb_blog_backend.repository.CommentRepository;
import com.fcb_blog_backend.fcb_blog_backend.repository.PostRepository;
import com.fcb_blog_backend.fcb_blog_backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<MessageDTO> create(CommentCreateReqDTO body) {
        PostModel post = postRepository.findById(body.postId())
                .orElseThrow(() -> new EntityNotFoundException("Post not found: " + body.postId()));
                
        UserModel user = userRepository.findById(body.userId())
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + body.userId()));
                
        CommentModel comment = new CommentModel();
        comment.setContent(body.content());
        comment.setPost(post);
        comment.setUser(user);
        
        commentRepository.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO("Comment created successfully!"));
    }

    public ResponseEntity<List<CommentModel>> getAll() {
        List<CommentModel> comments = commentRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }

    public ResponseEntity<List<CommentModel>> getByPostId(int postId) {
        List<CommentModel> comments = commentRepository.findByPostId(postId)
                .orElseThrow(() -> new EntityNotFoundException("No comments found for post: " + postId));
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }

    public ResponseEntity<MessageDTO> delete(int commentId) {
        CommentModel comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found: " + commentId));
        
        commentRepository.delete(comment);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO("Comment deleted successfully!"));
    }
}
