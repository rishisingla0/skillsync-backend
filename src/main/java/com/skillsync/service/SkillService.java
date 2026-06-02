package com.skillsync.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.skillsync.dto.SkillRequestDTO;
import com.skillsync.entity.Skill;
import com.skillsync.repository.SkillRepository;

@Service
public class SkillService {
    
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public void createSkill(SkillRequestDTO dto) {
        Skill skill = new Skill();
        skill.setName(dto.name);
        skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
}
