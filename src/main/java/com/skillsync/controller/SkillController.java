package com.skillsync.controller;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillsync.dto.SkillRequestDTO;
import com.skillsync.entity.Skill;
import com.skillsync.service.SkillService;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<String> createSkill(@RequestBody SkillRequestDTO dto) {
        skillService.createSkill(dto);
        return ResponseEntity.ok("Skill created");
    }

    @GetMapping
    public List<Skill> getSkills() {
        return skillService.getAllSkills();
    }
}
