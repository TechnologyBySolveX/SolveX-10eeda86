package com.solvex.stream.controller;

//AuthController.java
import org.springframework.web.bind.annotation.*;

import com.solvex.stream.entity.User;
import com.solvex.stream.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3002")
public class AuthController {

 private final UserRepository repo;

 public AuthController(UserRepository repo) {
     this.repo = repo;
 }

 // SIGNUP
 @PostMapping("/signup")
 public String signup(@RequestBody User user) {
     Optional<User> existing = repo.findByUserName(user.getUserName());
     if (existing.isPresent()) {
         return "Username already exists!";
     }
     repo.save(user);
     return "Signup successful!";
 }

 // LOGIN
 @PostMapping("/login")
 public String login(@RequestBody User user) {
     Optional<User> existing = repo.findByUserName(user.getUserName());
     if (existing.isPresent() && existing.get().getPassword().equals(user.getPassword())) {
         return "Login successful!";
     }
     return "Invalid credentials!";
 }
}
