package com.deceptiveb.workie.service;

import com.deceptiveb.workie.dto.industry.IndustryRequestDto;
import com.deceptiveb.workie.dto.industry.IndustryResponseDto;
import com.deceptiveb.workie.model.Industry;

public interface IndustryService {
    IndustryResponseDto save(IndustryRequestDto industryRequest);
}
