package com.deceptiveb.workie.mapper.industry;

import com.deceptiveb.workie.dto.industry.IndustryResponseDto;
import com.deceptiveb.workie.model.Industry;

import java.util.function.Function;

public class IndustryResponseMapper implements Function<Industry, IndustryResponseDto> {
    @Override
    public IndustryResponseDto apply(Industry industry) {
        return new IndustryResponseDto(
                industry.getId(),
                industry.getName()
        );
    }
}
