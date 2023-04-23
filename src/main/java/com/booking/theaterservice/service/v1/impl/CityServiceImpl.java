package com.example.theaterservice.service.v1.impl;

import com.example.theaterservice.dto.v1.CityDto;
import com.example.theaterservice.entity.City;
import com.example.theaterservice.mapper.CityMapper;
import com.example.theaterservice.repository.CityRepository;
import com.example.theaterservice.service.v1.CityService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public CityDto save(CityDto cityDto) {
        City city = CityMapper.INSTANCE.toCity( cityDto );
         cityRepository.save( city );
        return CityMapper.INSTANCE.toCityDto(city);
    }

    @Override
    public City findById(Long id) {
        Optional<City> byId = cityRepository.findById( id );
        return byId.orElse( null );
    }
}
