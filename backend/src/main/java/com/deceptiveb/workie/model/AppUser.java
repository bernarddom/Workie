package com.deceptiveb.workie.model;

import com.deceptiveb.workie.model.audit.DateAudit;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class AppUser extends DateAudit {
    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            generator = "user_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private String email;

    private String fullName;

    private String password;

    private String username;

    private boolean isActive;

    @OneToMany(mappedBy = "appUser")
    private Set<Resume> resumes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public AppUser() {
    }

    public AppUser(String email, String fullName,String username, String password) {
        this.email = email;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public AppUser(String email, String fullName, String password, Set<Resume> resumes) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.resumes = resumes;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(Set<Resume> resumes) {
        this.resumes = resumes;
    }
}
