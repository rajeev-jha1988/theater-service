package com.example.theaterservice.service.v1.impl;

import com.example.theaterservice.dto.v1.AuditoriumDetailDto;
import com.example.theaterservice.dto.v1.AuditoriumDto;
import com.example.theaterservice.dto.v1.message.AuditoriumMessageDto;
import com.example.theaterservice.entity.Auditorium;
import com.example.theaterservice.entity.Theatre;
import com.example.theaterservice.enums.EventType;
import com.example.theaterservice.mapper.AuditoriumMapper;
import com.example.theaterservice.repository.AuditoriumRepository;
import com.example.theaterservice.service.v1.AuditoriumService;
import com.example.theaterservice.service.v1.TheatreService;
import com.example.theaterservice.util.MessagePublisher;
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
