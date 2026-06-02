package com.skillsync.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.skillsync.dto.*;
import com.skillsync.entity.*;
import com.skillsync.service.UserService;

import jakarta.validation.Valid;

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

    @PostMapping("/{id}/projects")
    public ResponseEntity<String> addProject(
            @PathVariable Long id,
            @RequestBody ProjectRequestDTO request) {

        userService.addProjectToUser(id, request);

        return ResponseEntity.ok("Project added successfully");
    }

    @GetMapping("/{id}/projects")
    public List<ProjectResponseDTO> getUserProjects(@PathVariable Long id) {
        return userService.getUserProjects(id);
    }

    @PostMapping("/{userId}/skills/{skillId}")
    public ResponseEntity<String> addSkillToUser(
            @PathVariable Long userId,
            @PathVariable Long skillId) {
        userService.addSkillToUser(userId, skillId);

        return ResponseEntity.ok("Skill added to user");
    }

    @GetMapping("/{id}/skills")
    public List<SkillResponseDTO> getUserSkills(@PathVariable Long id) {
        return userService.getUserSkills(id);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestDTO dto) {
        userService.createUser(dto);
        return ResponseEntity.ok("User created successfully");
    }
}
