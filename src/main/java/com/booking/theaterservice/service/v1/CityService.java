package com.example.theaterservice.service.v1;

import com.example.theaterservice.dto.v1.CityDto;
import com.example.theaterservice.entity.City;

public interface CityService {

    CityDto save(CityDto city);

    City findById(Long id);

}
