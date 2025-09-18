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

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    private String generateSlug(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-");
        return Pattern.compile("-+").matcher(normalized).replaceAll("-");
    }

    public ResponseEntity<List<CategoryModel>> getAll() {
        List<CategoryModel> list = categoryRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

//    public ResponseEntity<List<CategoryModel>> getBySlug(String slug) {
//
//    }

    public ResponseEntity<MessageDTO> create(CategoryCreateReqDTO body){

            CategoryModel category = new CategoryModel();
            category.setName(body.name());
            category.setSlug(generateSlug(body.name()));
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
