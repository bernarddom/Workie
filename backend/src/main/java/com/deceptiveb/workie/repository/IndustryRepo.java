package com.deceptiveb.workie.repository;

import com.deceptiveb.workie.model.Industry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndustryRepo extends JpaRepository<Industry, Integer> {
    Page<Industry> findAll(Specification<Industry> spec, Pageable pageable);
}
