package com.fcb_blog_backend.fcb_blog_backend.repository;

import com.fcb_blog_backend.fcb_blog_backend.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Integer> {
}
