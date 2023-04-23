package com.example.theaterservice.mapper;


import com.example.theaterservice.dto.v1.AuditoriumDetailDto;
import com.example.theaterservice.dto.v1.AuditoriumDto;
import com.example.theaterservice.entity.Auditorium;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( componentModel = "spring" )
public interface AuditoriumMapper {


    AuditoriumMapper INSTANCE = Mappers.getMapper( AuditoriumMapper.class );

    Auditorium toAuditorium(AuditoriumDto auditoriumDto);
    AuditoriumDto toAuditoriumDto(Auditorium auditoriumDto);
    List<AuditoriumDetailDto> toAuditoriumDetailDto(List<Auditorium> auditoriumDto);

}
