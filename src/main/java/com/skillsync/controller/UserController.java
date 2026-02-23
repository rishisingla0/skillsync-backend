package com.skillsync.controller;

import org.springframework.web.bind.annotation.*;
import com.skillsync.entity.User;
import com.skillsync.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully";
    }
}
