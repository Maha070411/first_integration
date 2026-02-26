package com.example.loginPage.controller;

import com.example.loginPage.entity.User;
import com.example.loginPage.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {

        Optional<User> user = userRepository
                .findByUsernameAndPassword(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                );

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getName());
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }
    }
}