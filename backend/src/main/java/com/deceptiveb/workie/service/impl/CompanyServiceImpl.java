package com.deceptiveb.workie.service.impl;

import com.deceptiveb.workie.dto.company.CompanyRequestDto;
import com.deceptiveb.workie.dto.company.CompanyResponseDto;
import com.deceptiveb.workie.mapper.company.CompanyRequestMapper;
import com.deceptiveb.workie.mapper.company.CompanyResponseMapper;
import com.deceptiveb.workie.model.company.Company;
import com.deceptiveb.workie.repository.CompanyRepo;
import com.deceptiveb.workie.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRequestMapper companyReqMapper;
    private final CompanyResponseMapper companyRespMapper;
    private final CompanyRepo companyRepo;
    @Autowired
    public CompanyServiceImpl(CompanyRequestMapper companyReqMapper,
                              CompanyRepo companyRepo,
                              CompanyResponseMapper companyRespMapper) {
        this.companyReqMapper = companyReqMapper;
        this.companyRepo = companyRepo;
        this.companyRespMapper = companyRespMapper;
    }
    @Override
    public CompanyResponseDto save(CompanyRequestDto companyRequestDto) {
         Company company = companyReqMapper.apply(companyRequestDto);
         Company companySaved = companyRepo.save(company);
         return companyRespMapper.apply(companySaved);
    }
}
