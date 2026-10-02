package com.deceptiveb.workie.service;

import com.deceptiveb.workie.dto.company.CompanyRequestDTO;
import com.deceptiveb.workie.model.company.Company;

public interface CompanyService {
    Company save(CompanyRequestDTO companyRequestDTO);
}
