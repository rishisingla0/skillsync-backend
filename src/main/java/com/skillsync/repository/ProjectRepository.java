package com.skillsync.repository;
import java.util.*;

import com.skillsync.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p JOIN p.owner u JOIN u.skills s WHERE s.name = :skillName")
    List<Project> findProjectsBySkill(@Param("skillName") String skillName);
}