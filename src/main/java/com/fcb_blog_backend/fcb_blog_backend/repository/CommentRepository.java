package com.fcb_blog_backend.fcb_blog_backend.repository;

import com.fcb_blog_backend.fcb_blog_backend.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Integer> {
    Optional<List<CommentModel>> findByPostId(int postId);
}
