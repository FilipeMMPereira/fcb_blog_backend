package com.fcb_blog_backend.fcb_blog_backend.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateReqDTO(@NotBlank(message = "The email is required") @Email (message = "Invalid email format") String email, @NotBlank(message = "The password is mandatory") @Size(min = 6, message = "The password must be at least 6 characters long") String password, String role) {
}
