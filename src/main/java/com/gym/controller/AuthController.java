package com.gym.controller;

import com.gym.model.User;
import com.gym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserRepository repo;

    // ✅ LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        System.out.println("EMAIL: " + user.getEmail());
        System.out.println("PASSWORD: " + user.getPassword());

        User existing = repo.findByEmail(user.getEmail());

        if (existing == null) {
            System.out.println("USER NOT FOUND");
            return "Invalid";
        }

        System.out.println("DB PASSWORD: " + existing.getPassword());

        if (existing.getPassword().equals(user.getPassword())) {
            return "Success";
        }

        return "Invalid";
    }

    // ✅ REGISTER (optional)
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        repo.save(user);
        return "User Registered";
    }

    // ✅ FORGOT PASSWORD (basic)
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody User user) {

        User existing = repo.findByEmail(user.getEmail());

        if (existing != null) {
            return "Your password is: " + existing.getPassword();
        }

        return "User not found";
    }
}