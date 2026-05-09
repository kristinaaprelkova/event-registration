package com.github.kristinaaprelkova.event_registration.controller;

import com.github.kristinaaprelkova.event_registration.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if (adminEmail.equals(request.getEmail()) &&
                adminPassword.equals(request.getPassword())) {

            return "Login successful";
        }

        throw new RuntimeException("Invalid credentials");
    }
}
