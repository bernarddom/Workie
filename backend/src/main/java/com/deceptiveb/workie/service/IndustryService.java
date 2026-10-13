package com.deceptiveb.workie.service;

import com.deceptiveb.workie.dto.industry.IndustryRequestDto;
import com.deceptiveb.workie.dto.industry.IndustryResponseDto;
import com.deceptiveb.workie.model.Industry;

import java.util.List;

public interface IndustryService {
    IndustryResponseDto save(IndustryRequestDto industryRequest);

    IndustryResponseDto getIndustry(Integer productId);

    List<IndustryResponseDto> getIndustries(String filter, int page, int size);
}
