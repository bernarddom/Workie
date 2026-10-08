package com.deceptiveb.workie.mapper.company;

import com.deceptiveb.workie.dto.company.CompanyResponseDto;
import com.deceptiveb.workie.model.company.Company;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CompanyResponseMapper implements Function<Company, CompanyResponseDto> {

    @Override
    public CompanyResponseDto apply(Company company) {
        return new CompanyResponseDto(
                company.getId(),
                company.getName(),
                company.getIndustry().getName(),
                company.getEmail(),
                company.getPhone(),
                company.getLocation()
        );
    }
}
