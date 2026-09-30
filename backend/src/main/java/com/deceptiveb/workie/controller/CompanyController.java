package com.deceptiveb.workie.controller;

import com.deceptiveb.workie.dto.CompanyRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @PostMapping
    public ResponseEntity<Void> createCompany(
            @RequestBody @Valid CompanyRequestDTO companyRequest){
        return ResponseEntity.created();
    }
}
