package com.deceptiveb.workie.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table
@Entity
public class JobOpening {
    @Id
    @SequenceGenerator(
            name = "opening_id_sequence",
            sequenceName = "opening_id_sequence"
    )
    @GeneratedValue(
            generator = "opening_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private String title;

    private BigDecimal salaryMin;
    private BigDecimal salaryMax;
    private BigDecimal currency;
    private SalaryPeriod salaryPeriod;

    private String description;

    private LocalDateTime closingDate;
}
