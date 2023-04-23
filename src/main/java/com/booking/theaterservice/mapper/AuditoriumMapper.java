package com.booking.theaterservice.mapper;


import com.booking.theaterservice.dto.v1.AuditoriumDto;
import com.booking.theaterservice.entity.Auditorium;
import com.booking.theaterservice.dto.v1.AuditoriumDetailDto;
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
