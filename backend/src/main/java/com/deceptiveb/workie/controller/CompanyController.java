package com.deceptiveb.workie.controller;

import com.deceptiveb.workie.dto.company.CompanyRequestDTO;
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
    public ResponseEntity<Void> createCompany(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody @Valid CompanyRequestDTO companyRequest) {
        Company company = companyService.save(companyRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(company.getId())
                .toUri();
        // TODO return CompanyDTO
        return ResponseEntity.created(location).build();
    }
}
