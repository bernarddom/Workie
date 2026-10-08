package com.deceptiveb.workie.mapper.company;

import com.deceptiveb.workie.dto.company.CompanyRequestDto;
import com.deceptiveb.workie.exception.ResourceNotFoundException;
import com.deceptiveb.workie.model.Industry;
import com.deceptiveb.workie.model.company.Company;
import com.deceptiveb.workie.repository.IndustryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CompanyRequestMapper implements Function<CompanyRequestDto, Company> {
    private final IndustryRepo industryRepo;

    @Autowired
    public CompanyRequestMapper(IndustryRepo industryRepo) {
        this.industryRepo = industryRepo;
    }

    @Override
    public Company apply(CompanyRequestDto companyRequestDTO) {
        Industry industry = industryRepo
                .findById(companyRequestDTO.industryId())
                .orElseThrow(() -> new ResourceNotFoundException("Industry", "id", companyRequestDTO.industryId()));
        return new Company(
                companyRequestDTO.name(),
                companyRequestDTO.foundedAt(),
                industry,
                companyRequestDTO.email(),
                companyRequestDTO.phone(),
                companyRequestDTO.location()
        );
    }
}
