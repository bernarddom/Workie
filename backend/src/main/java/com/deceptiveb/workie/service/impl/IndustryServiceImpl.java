package com.deceptiveb.workie.service.impl;

import com.deceptiveb.workie.dto.industry.IndustryRequestDto;
import com.deceptiveb.workie.dto.industry.IndustryResponseDto;
import com.deceptiveb.workie.mapper.industry.IndustryRequestMapper;
import com.deceptiveb.workie.mapper.industry.IndustryResponseMapper;
import com.deceptiveb.workie.model.Industry;
import com.deceptiveb.workie.repository.IndustryRepo;
import com.deceptiveb.workie.service.IndustryService;

public class IndustryServiceImpl implements IndustryService {
    private final IndustryRepo industryRepo;

    private final IndustryRequestMapper industryRequestMapper;
    private final IndustryResponseMapper industryResponseMapper;

    public IndustryServiceImpl(
            IndustryRepo industryRepo,
            IndustryRequestMapper industryRequestMapper,
            IndustryResponseMapper industryResponseMapper) {
        this.industryRepo = industryRepo;
        this.industryRequestMapper = industryRequestMapper;
        this.industryResponseMapper = industryResponseMapper;
    }

    @Override
    public IndustryResponseDto save(IndustryRequestDto industryRequest) {
        Industry industry = industryRepo.save(industryRequestMapper.apply(industryRequest));

        return industryResponseMapper.apply(industry);
    }
}
