package com.booking.theaterservice.mapper;

import com.booking.theaterservice.dto.v1.CityDto;
import com.booking.theaterservice.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( componentModel = "spring" )
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper( CityMapper.class );


    CityDto toCityDto(City city);
    City toCity(CityDto city);

}
