package com.booking.theaterservice.service.v1;

import com.booking.theaterservice.entity.City;
import com.booking.theaterservice.dto.v1.CityDto;

public interface CityService {

    CityDto save(CityDto city);

    City findById(Long id);

}
