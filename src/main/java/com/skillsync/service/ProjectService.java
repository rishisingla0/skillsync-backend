package com.skillsync.service;
import java.util.*;

import org.springframework.stereotype.Service;
import com.skillsync.dto.*;

import com.skillsync.repository.ProjectRepository;

@Service
public class ProjectService {
    
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectResponseDTO> getProjectsBySkill(String skillName) {

        return projectRepository.findProjectsBySkill(skillName).stream().map(p -> new ProjectResponseDTO(p.getId(), p.getTitle(), p.getDescription())).toList();
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
