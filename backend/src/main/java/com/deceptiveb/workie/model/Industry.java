package com.deceptiveb.workie.model;

import jakarta.persistence.*;

@Entity
@Table
public class Industry {

    @Id
    @SequenceGenerator(
            name = "industry_id_sequence",
            sequenceName = "industry_id_sequence"
    )
    @GeneratedValue(
            generator = "industry_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private String name;

    public Industry() {
    }

    public Industry(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
