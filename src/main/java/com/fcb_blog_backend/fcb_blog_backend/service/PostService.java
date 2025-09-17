package com.fcb_blog_backend.fcb_blog_backend.service;

import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.post.PostCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.model.CategoryModel;
import com.fcb_blog_backend.fcb_blog_backend.model.PostModel;
import com.fcb_blog_backend.fcb_blog_backend.repository.CategoryRepository;
import com.fcb_blog_backend.fcb_blog_backend.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
 @Autowired
 private PostRepository postRepository;
 @Autowired
 private CategoryRepository categoryRepository;

 public ResponseEntity<MessageDTO> create(PostCreateReqDTO body) {
     CategoryModel category = categoryRepository.findById(body.categoryId())
             .orElseThrow(() -> new EntityNotFoundException("Category not found: " + body.categoryId()));
     PostModel post = new PostModel();
     post.setTitle(body.title());
     post.setImage(body.image());
     post.setCategory(category);
     postRepository.save(post);
     return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO("Post created successfully!"));
 }

 public ResponseEntity<List<PostModel>> getAll(){
     List<PostModel> posts = postRepository.findAll();
     return ResponseEntity.status(HttpStatus.OK).body(posts);
 }
}
