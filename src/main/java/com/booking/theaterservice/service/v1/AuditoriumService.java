package com.example.theaterservice.service.v1;

import com.example.theaterservice.dto.v1.AuditoriumDetailDto;
import com.example.theaterservice.dto.v1.AuditoriumDto;
import com.example.theaterservice.entity.Auditorium;
import java.util.List;

public interface AuditoriumService {

    AuditoriumDto save(AuditoriumDto auditoriumDto);

    List<AuditoriumDetailDto> findByTheaterId(Long id);

}
