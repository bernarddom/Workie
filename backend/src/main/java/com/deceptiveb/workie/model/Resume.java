package com.deceptiveb.workie.model;

import com.deceptiveb.workie.model.audit.DateAudit;
import jakarta.persistence.*;

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
}
