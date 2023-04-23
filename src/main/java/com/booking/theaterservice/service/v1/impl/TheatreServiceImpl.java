package com.example.theaterservice.service.v1.impl;

import com.example.theaterservice.dto.v1.TheatreDto;
import com.example.theaterservice.entity.City;
import com.example.theaterservice.entity.Theatre;
import com.example.theaterservice.enums.EventType;
import com.example.theaterservice.mapper.TheatreMapper;
import com.example.theaterservice.repository.TheatreRepository;
import com.example.theaterservice.service.v1.CityService;
import com.example.theaterservice.service.v1.TheatreService;
import com.example.theaterservice.util.MessagePublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;

    private final CityService cityService;

    private final MessagePublisher messagePublisher;

    public TheatreServiceImpl(TheatreRepository theatreRepository, CityService cityService,
        MessagePublisher messagePublisher) {
        this.theatreRepository = theatreRepository;
        this.cityService = cityService;
        this.messagePublisher = messagePublisher;
    }

    @Override
    @Transactional
    public TheatreDto save(TheatreDto theatreDto) {
        Theatre theatre = TheatreMapper.INSTANCE.toTheatre( theatreDto );
        City city = cityService.findById( theatreDto.getCityId() );
        theatre.setCity( city );
        theatreRepository.save( theatre );
        messagePublisher.sendMessage( EventType.THEATER_CREATED,theatre );
        return TheatreMapper.INSTANCE.toTheatreDto(theatre);
    }

    @Override
    public Theatre findById(Long id) {
        return theatreRepository.findById( id ).orElse( null );
    }
}
