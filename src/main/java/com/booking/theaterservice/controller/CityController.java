package com.example.theaterservice.controller;

import com.example.theaterservice.dto.v1.CityDto;
import com.example.theaterservice.service.v1.CityService;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping( path = "/api/city" )
    public ResponseEntity<CityDto> register(@RequestBody @Valid CityDto cityDto) {
        return ResponseEntity.ok( cityService.save( cityDto ) );
    }
}
