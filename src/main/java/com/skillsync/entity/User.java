package com.skillsync.entity;

import java.util.*;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @OneToMany(mappedBy = "owner",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
    fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Project> projects = new ArrayList<>();

    public User() {

    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void addProject(Project project) {
        projects.add(project);
        project.setOwner(this);
    }

    public List<Project> getProjects() {
        return projects;
    }

    @ManyToMany
    @JoinTable(
        name = "user_skill",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills = new ArrayList<>();

    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.getUsers().add(this);
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
