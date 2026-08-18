package com.deceptiveb.workie.model.company;

import com.deceptiveb.workie.model.Industry;
import jakarta.persistence.*;

import java.util.Date;

@Table
@Entity
public class Company {
    @Id
    @SequenceGenerator(
            sequenceName = "company_id_sequence",
            name = "company_id_sequence"
    )
    @GeneratedValue(
            generator = "company_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private String name;

    private Date foundedAt;

    private Industry industry;

    private String email;

    private String phone;

    private String location;
}
