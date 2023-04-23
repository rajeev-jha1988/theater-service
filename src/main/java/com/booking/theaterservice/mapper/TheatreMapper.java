package com.booking.theaterservice.mapper;

import com.booking.theaterservice.dto.v1.TheatreDto;
import com.booking.theaterservice.entity.Theatre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( componentModel = "spring" )
public interface TheatreMapper {
    TheatreMapper INSTANCE = Mappers.getMapper( TheatreMapper.class );


    TheatreDto toTheatreDto(Theatre theatre);
    Theatre toTheatre(TheatreDto theatreDto);
}
