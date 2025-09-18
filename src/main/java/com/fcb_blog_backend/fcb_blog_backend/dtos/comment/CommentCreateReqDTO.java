package com.fcb_blog_backend.fcb_blog_backend.dtos.comment;

import jakarta.validation.constraints.NotBlank;

public record CommentCreateReqDTO(@NotBlank String content, @NotBlank int userId, @NotBlank int postId) {
}
