package com.fcb_blog_backend.fcb_blog_backend.dtos.post;

import jakarta.validation.constraints.NotBlank;

public record PostCreateReqDTO(@NotBlank String title, @NotBlank String content, @NotBlank String image, @NotBlank int categoryId) {
}
