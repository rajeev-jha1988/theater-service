package com.example.theaterservice.service.v1;

import com.example.theaterservice.dto.v1.TheatreDto;
import com.example.theaterservice.entity.Theatre;

public interface TheatreService {

    TheatreDto save(TheatreDto theatreDto);

    Theatre findById(Long id);
    Theatre findTheaterDetail(Long id);

}
