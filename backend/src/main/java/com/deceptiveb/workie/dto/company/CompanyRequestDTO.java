package com.deceptiveb.workie.dto.company;

import java.util.Date;

public record CompanyRequestDTO(
        String name,
        Date foundedAt,
        Integer industryId,
        String email,
        String phone,
        String location
) {
}
