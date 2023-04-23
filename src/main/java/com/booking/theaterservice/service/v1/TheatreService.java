package com.booking.theaterservice.service.v1;

import com.booking.theaterservice.dto.v1.TheatreDto;
import com.booking.theaterservice.entity.Theatre;

public interface TheatreService {

    TheatreDto save(TheatreDto theatreDto);

    Theatre findById(Long id);
    Theatre findTheaterDetail(Long id);

}
