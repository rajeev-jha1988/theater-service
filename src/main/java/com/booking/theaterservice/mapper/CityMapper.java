package com.example.theaterservice.mapper;

import com.example.theaterservice.dto.v1.CityDto;
import com.example.theaterservice.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( componentModel = "spring" )
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper( CityMapper.class );


    CityDto toCityDto(City city);
    City toCity(CityDto city);

}
