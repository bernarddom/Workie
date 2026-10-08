package com.deceptiveb.workie.service;

import com.deceptiveb.workie.dto.company.CompanyRequestDto;
import com.deceptiveb.workie.dto.company.CompanyResponseDto;
import com.deceptiveb.workie.model.company.Company;

public interface CompanyService {
    CompanyResponseDto save(CompanyRequestDto companyRequestDTO);
}
