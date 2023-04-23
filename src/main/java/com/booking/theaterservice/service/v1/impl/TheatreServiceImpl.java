package com.booking.theaterservice.service.v1.impl;

import com.booking.theaterservice.dto.v1.TheatreDto;
import com.booking.theaterservice.enums.EventType;
import com.booking.theaterservice.repository.TheatreRepository;
import com.booking.theaterservice.service.v1.TheatreService;
import com.booking.theaterservice.util.MessagePublisher;
import com.booking.theaterservice.entity.City;
import com.booking.theaterservice.entity.Theatre;
import com.booking.theaterservice.mapper.TheatreMapper;
import com.booking.theaterservice.service.v1.CityService;
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
