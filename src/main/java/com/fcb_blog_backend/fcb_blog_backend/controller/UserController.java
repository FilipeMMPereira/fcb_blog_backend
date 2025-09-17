package com.fcb_blog_backend.fcb_blog_backend.controller;

import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.user.AuthResponseDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.user.UserCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.user.UserLoginReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<MessageDTO> register(@Valid @RequestBody UserCreateReqDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody UserLoginReqDTO loginDTO) {
        return ResponseEntity.ok(userService.login(loginDTO));
    }
}