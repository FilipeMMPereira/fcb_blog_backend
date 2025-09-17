package com.fcb_blog_backend.fcb_blog_backend.service;

import com.fcb_blog_backend.fcb_blog_backend.dtos.category.CategoryCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.model.CategoryModel;
import com.fcb_blog_backend.fcb_blog_backend.repository.CategoryRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<List<CategoryModel>> getAll() {
        List<CategoryModel> list = categoryRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

//    public ResponseEntity<List<CategoryModel>> getBySlug(String slug) {
//
//    }

    public ResponseEntity<MessageDTO> create(CategoryCreateReqDTO body){
            if(categoryRepository.existsByName(body.name()) || categoryRepository.existsBySlug(body.slug())){
                throw new EntityExistsException("Category already exists");
            }
            CategoryModel category = new CategoryModel();
            category.setName(body.name());
            category.setSlug(body.slug());
            category.setDescription(body.description());
            categoryRepository.save(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO("Category created successfully"));
    }

//    public ResponseEntity<MessageDTO> update(int id, CategoryCreateReqDTO body){
//        if(categoryRepository.exitsById(id)){
//            CategoryModel category = categoryRepository.findById(id).get();
//        }
//    }
}
