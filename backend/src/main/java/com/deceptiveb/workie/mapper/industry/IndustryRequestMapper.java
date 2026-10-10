package com.deceptiveb.workie.mapper.industry;

import com.deceptiveb.workie.dto.industry.IndustryRequestDto;
import com.deceptiveb.workie.model.Industry;

import java.util.function.Function;

public class IndustryRequestMapper implements Function<IndustryRequestDto, Industry> {
    @Override
    public Industry apply(IndustryRequestDto industryRequestDto) {
        return new Industry(
                industryRequestDto.name()
        );
    }
}
