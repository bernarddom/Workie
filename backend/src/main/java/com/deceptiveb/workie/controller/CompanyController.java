package com.deceptiveb.workie.controller;

import com.deceptiveb.workie.dto.company.CompanyRequestDTO;
import com.deceptiveb.workie.securirty.CustomUserDetails;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @PostMapping
    public ResponseEntity<Void> createCompany(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody @Valid CompanyRequestDTO companyRequest){

        return ResponseEntity.created();
    }
}
