package com.deceptiveb.workie.controller;

import com.deceptiveb.workie.dto.industry.IndustryRequestDto;
import com.deceptiveb.workie.dto.industry.IndustryResponseDto;
import com.deceptiveb.workie.service.IndustryService;
import com.deceptiveb.workie.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<IndustryResponseDto> getProduct(
            @PathVariable(value = "id") Integer id
    ) {
        return ResponseEntity.ok().body(industryService.getIndustry(id));
    }

    public ResponseEntity<List<IndustryResponseDto>> getIndustries(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = AppConstants.DEFAULT_PAGE_NUMBER
            ) Integer page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = AppConstants.DEFAULT_PAGE_NUMBER
            ) Integer size
    ){
        return null;
    }
}
