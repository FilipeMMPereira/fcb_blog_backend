package com.fcb_blog_backend.fcb_blog_backend.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLoginReqDTO(@NotBlank(message = "The email is required") @Email(message = "Invalid email format") String email, @NotBlank(message = "The password is mandatory") String password) {
}
