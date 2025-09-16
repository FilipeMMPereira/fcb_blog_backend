package com.fcb_blog_backend.fcb_blog_backend.repository;

import com.fcb_blog_backend.fcb_blog_backend.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
    Optional<CategoryModel>  findById(int id);
    Optional<CategoryModel> findByName(String name);
    Optional<CategoryModel> findBySlug(String slug);
    boolean existsBySlug(String slug);
    boolean existsByName(String name);
}
