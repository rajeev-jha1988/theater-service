package com.booking.theaterservice.service.v1.impl;

import com.booking.theaterservice.dto.v1.AuditoriumDto;
import com.booking.theaterservice.dto.v1.message.AuditoriumMessageDto;
import com.booking.theaterservice.entity.Auditorium;
import com.booking.theaterservice.entity.Theatre;
import com.booking.theaterservice.enums.EventType;
import com.booking.theaterservice.repository.AuditoriumRepository;
import com.booking.theaterservice.service.v1.TheatreService;
import com.booking.theaterservice.util.MessagePublisher;
import com.booking.theaterservice.dto.v1.AuditoriumDetailDto;
import com.booking.theaterservice.mapper.AuditoriumMapper;
import com.booking.theaterservice.service.v1.AuditoriumService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    private final TheatreService theatreService;

    private final MessagePublisher messagePublisher;

    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository, TheatreService theatreService,
        MessagePublisher messagePublisher) {
        this.auditoriumRepository = auditoriumRepository;
        this.theatreService = theatreService;
        this.messagePublisher = messagePublisher;
    }

    @Override
    public AuditoriumDto save(AuditoriumDto auditoriumDto) {

        Auditorium auditorium = AuditoriumMapper.INSTANCE.toAuditorium( auditoriumDto );

        Theatre byId = theatreService.findById( auditoriumDto.getTheaterId() );
        auditorium.setTheatre( byId );

        auditoriumRepository.save( auditorium );
        // publish the message to consume by other subscriber
        messagePublisher.sendMessage( EventType.THEATER_AUDITORIUM_ADDED,
            AuditoriumMessageDto.builder()
                .auditoriumId( auditorium.getId() )
                .auditoriumName( auditorium.getAuditoriumName() )
                .theatreId( byId.getId() )
            .build() );
        return AuditoriumMapper.INSTANCE.toAuditoriumDto( auditorium );
    }

    @Override
    public List<AuditoriumDetailDto> findByTheaterId(Long id) {
        List<Auditorium> byTheatreId = auditoriumRepository.findByTheatre_Id( id );
        return  AuditoriumMapper.INSTANCE.toAuditoriumDetailDto( byTheatreId );
    }
}
