package com.fcb_blog_backend.fcb_blog_backend.service;

import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.user.AuthResponseDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.user.UserCreateReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.user.UserLoginReqDTO;
import com.fcb_blog_backend.fcb_blog_backend.model.UserModel;
import com.fcb_blog_backend.fcb_blog_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public MessageDTO createUser(UserCreateReqDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.email())) {
            throw new RuntimeException("Email already exists");
        }

        UserModel user = new UserModel();
        user.setEmail(userDTO.email());
        user.setName(userDTO.name());
        user.setPassword(passwordEncoder.encode(userDTO.password()));
        user.setAdmin("ADMIN".equalsIgnoreCase(userDTO.role()));

        userRepository.save(user);
        return new MessageDTO("User created successfully");
    }

    public AuthResponseDTO login(UserLoginReqDTO loginDTO) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password())
        );

        UserModel user = userRepository.findByEmail(loginDTO.email())
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Generate a simple token (in a real app, use JWT)
        String token = "user_" + user.getId() + "_" + System.currentTimeMillis();
        
        return new AuthResponseDTO("Login successful", token);
    }
}