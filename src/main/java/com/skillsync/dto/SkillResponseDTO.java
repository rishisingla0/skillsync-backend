package com.skillsync.dto;

public class SkillResponseDTO {

    private Long id;
    private String name;

    public SkillResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}