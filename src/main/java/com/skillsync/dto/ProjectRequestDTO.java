package com.skillsync.dto;

import jakarta.validation.constraints.NotBlank;

public class ProjectRequestDTO {
    
    @NotBlank
    private String title;
    
    @NotBlank
    private String description;

    public ProjectRequestDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
