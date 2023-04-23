package com.booking.theaterservice.service.v1;

import com.booking.theaterservice.dto.v1.AuditoriumDto;
import com.booking.theaterservice.dto.v1.AuditoriumDetailDto;
import java.util.List;

public interface AuditoriumService {

    AuditoriumDto save(AuditoriumDto auditoriumDto);

    List<AuditoriumDetailDto> findByTheaterId(Long id);

}
