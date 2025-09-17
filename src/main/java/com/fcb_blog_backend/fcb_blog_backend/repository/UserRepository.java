package com.fcb_blog_backend.fcb_blog_backend.repository;

import com.fcb_blog_backend.fcb_blog_backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);
    boolean existsByEmail(String email);
}