package com.skillsync.service;

import org.springframework.stereotype.Service;
import java.util.*;

import com.skillsync.dto.*;
import com.skillsync.entity.*;
import com.skillsync.repository.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    public UserService(UserRepository userRepository, SkillRepository skillRepository) {
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public void createUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.name);
        user.setEmail(dto.email);
        user.setPassword(dto.password);

        userRepository.save(user);
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

        userRepository.save(user);
    }

    public void addProjectToUser(Long userId, ProjectRequestDTO request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Project project = new Project();
        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());

        user.addProject(project);

        userRepository.save(user);
    }

    public List<ProjectResponseDTO> getUserProjects(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        return user.getProjects().stream().map(p -> new ProjectResponseDTO(p.getId(), p.getTitle(), p.getDescription())).toList();
    }

    public void addSkillToUser(Long userId, Long skillId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found"));
        
        user.addSkill(skill);

        userRepository.save(user);
    }

    public List<SkillResponseDTO> getUserSkills(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        return user.getSkills().stream().map(skill -> new SkillResponseDTO(skill.getId(), skill.getName())).toList();
    }
}
