package com.deceptiveb.workie.controller;

import com.deceptiveb.workie.dto.company.CompanyRequestDto;
import com.deceptiveb.workie.dto.company.CompanyResponseDto;
import com.deceptiveb.workie.model.company.Company;
import com.deceptiveb.workie.securirty.CustomUserDetails;
import com.deceptiveb.workie.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDto> createCompany(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody @Valid CompanyRequestDto companyRequest) {
        CompanyResponseDto company = companyService.save(companyRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(company.id())
                .toUri();
        return ResponseEntity.created(location).body(company);
    }
}
