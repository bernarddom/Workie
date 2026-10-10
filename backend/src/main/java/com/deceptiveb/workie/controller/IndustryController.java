package com.deceptiveb.workie.controller;

import com.deceptiveb.workie.dto.industry.IndustryRequestDto;
import com.deceptiveb.workie.dto.industry.IndustryResponseDto;
import com.deceptiveb.workie.service.IndustryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/industry")
public class IndustryController {

    private final IndustryService industryService;
    public IndustryController(IndustryService industryService) {
        this.industryService = industryService;
    }
    @PostMapping
    public ResponseEntity<IndustryResponseDto> save(
            @RequestBody @Valid IndustryRequestDto industryRequestDto
    ) {
        IndustryResponseDto responseDto = industryService.save(industryRequestDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(uri).body(responseDto);

    }
}
