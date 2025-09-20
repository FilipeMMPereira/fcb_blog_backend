package com.fcb_blog_backend.fcb_blog_backend.dtos.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentCreateReqDTO(@NotBlank String content, @NotNull int userId, @NotNull int postId) {
}
