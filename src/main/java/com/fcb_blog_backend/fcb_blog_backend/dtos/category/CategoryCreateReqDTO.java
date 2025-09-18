package com.fcb_blog_backend.fcb_blog_backend.dtos.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateReqDTO(@NotBlank String name, @NotBlank String description ) {
}
