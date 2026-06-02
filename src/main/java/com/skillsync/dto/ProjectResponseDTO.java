package com.skillsync.dto;

public class ProjectResponseDTO {
    
    private Long id;
    private String title;
    private String description;

    public ProjectResponseDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
