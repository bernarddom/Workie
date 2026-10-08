package com.deceptiveb.workie.dto.company;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

public record CompanyRequestDto(
        @Size(min = 3)
        String name,
        @NotNull
        Date foundedAt,
        @NotNull
        Integer industryId,
        @NotBlank
        @Email
        String email,
        @Size(min = 9)
        String phone,
        @Size(min = 10, max = 120)
        String location
) {
}
