package com.skillsync.service;

import org.springframework.stereotype.Service;

import com.skillsync.entity.Project;
import com.skillsync.entity.User;
import com.skillsync.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public void registerUser(User user) {

        if (!user.getEmail().contains("@")) {
            throw new RuntimeException("Invalid Email Format");
        }

        if (user.getPassword().length() < 6) {
             throw new RuntimeException("Password must be at least 6 characters");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
             throw new RuntimeException("Email already exists");
        }

        userRepository.save(user);
    }

    public void addProjectToUser(Long userId, String title, String description) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);

        user.addProject(project);
    }
}
