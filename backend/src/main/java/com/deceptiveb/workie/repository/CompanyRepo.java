package com.deceptiveb.workie.repository;

import com.deceptiveb.workie.model.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {
}
