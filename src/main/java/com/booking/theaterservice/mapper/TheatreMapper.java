package com.example.theaterservice.mapper;

import com.example.theaterservice.dto.v1.TheatreDto;
import com.example.theaterservice.entity.Theatre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( componentModel = "spring" )
public interface TheatreMapper {
    TheatreMapper INSTANCE = Mappers.getMapper( TheatreMapper.class );


    TheatreDto toTheatreDto(Theatre theatre);
    Theatre toTheatre(TheatreDto theatreDto);
}
