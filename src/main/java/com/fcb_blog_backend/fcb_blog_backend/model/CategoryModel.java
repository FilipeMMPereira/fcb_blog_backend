package com.fcb_blog_backend.fcb_blog_backend.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "categories")
@NoArgsConstructor

public class CategoryModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Column(nullable = false, unique = true)
    private String slug;

//    @Lob
//    private String description;
//
//
//    private String imageUrl;

//    @ManyToMany(mappedBy = "posts")
//    private Set<PostModel> posts;



}
