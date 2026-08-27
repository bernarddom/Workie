package com.deceptiveb.workie.model;

import com.deceptiveb.workie.model.audit.DateAudit;
import jakarta.persistence.*;

@Table
@Entity
public class Resume extends DateAudit {
    @Id
    @SequenceGenerator(
            sequenceName = "resume_id_sequence",
            name = "resume_id_sequence"
    )
    @GeneratedValue(
            generator = "resume_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private String description;

    private AppUser appUser;

    public Resume() {
    }

    public Resume(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
