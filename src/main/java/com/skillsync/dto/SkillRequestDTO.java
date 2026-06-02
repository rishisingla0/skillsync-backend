package com.skillsync.dto;

import jakarta.validation.constraints.NotBlank;

public class SkillRequestDTO {

    @NotBlank
    public String name;

    public SkillRequestDTO() {

    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
