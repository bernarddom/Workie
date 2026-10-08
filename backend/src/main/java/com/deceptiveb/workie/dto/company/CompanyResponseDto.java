package com.deceptiveb.workie.dto.company;

public record CompanyResponseDto(
        Integer id,
        String name,
        String industry,
        String email,
        String phone,
        String location
) {
}
