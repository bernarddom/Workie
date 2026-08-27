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

    @ManyToOne
    @JoinColumn(name = "industry_id", nullable = false)
    private Industry industry;

    private String email;

    private String phone;

    private String location;

    public Company() {
    }

    public Company(String name, Date foundedAt, Industry industry, String email, String phone, String location) {
        this.name = name;
        this.foundedAt = foundedAt;
        this.industry = industry;
        this.email = email;
        this.phone = phone;
        this.location = location;
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

    public Date getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(Date foundedAt) {
        this.foundedAt = foundedAt;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
