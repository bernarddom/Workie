package com.deceptiveb.workie.service.impl;

import com.deceptiveb.workie.dto.company.CompanyRequestDTO;
import com.deceptiveb.workie.mapper.company.CompanyRequestMapper;
import com.deceptiveb.workie.model.company.Company;
import com.deceptiveb.workie.repository.CompanyRepo;
import com.deceptiveb.workie.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRequestMapper companyReqMapper;
    private final CompanyRepo companyRepo;
    @Autowired
    public CompanyServiceImpl(CompanyRequestMapper companyReqMapper,
                              CompanyRepo companyRepo) {
        this.companyReqMapper = companyReqMapper;
        this.companyRepo = companyRepo;
    }
    @Override
    public Company save(CompanyRequestDTO companyRequestDTO) {
         Company company = companyReqMapper.apply(companyRequestDTO);
         Company companySaved = companyRepo.save(company);
         return company;
    }
}
