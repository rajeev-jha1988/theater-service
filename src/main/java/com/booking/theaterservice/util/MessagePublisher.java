package com.example.theaterservice.util;

import com.example.theaterservice.dto.v1.message.BookingMessageDto;
import com.example.theaterservice.enums.EventType;
import com.example.theaterservice.exceptions.TheaterServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessagePublisher {


    @Value( "${spring.rabbitmq.common.exchange}" )
    private String commonExchange;

    public static final String PUBLISHER ="theater-service";

    private final RabbitTemplate rabbitTemplate;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendMessage(EventType eventType, Object data) {
        try {
            log.debug( "Publishing Event {}", eventType.getEvent() );
            BookingMessageDto rabbitMqMessage = prepareHykeEvent( eventType, data );
            log.info( "Publishing event : {}", rabbitMqMessage.toString() );
            rabbitTemplate.convertAndSend( commonExchange, eventType.getRoutingKey(), rabbitMqMessage );

        } catch( Exception e ) {
            throw new TheaterServiceException(  );
        }
    }

    private BookingMessageDto prepareHykeEvent(EventType eventType, Object data) throws JsonProcessingException {
        return BookingMessageDto.builder()
            .eventType( eventType.getEvent() )
            .publisher( PUBLISHER )
            .schemaVersion( "v1" )
            .timestamp( new Date().getTime() )
            .eventDetails( new ObjectMapper().writeValueAsString( data ) )
            .eventId( PUBLISHER + "-" + UUID.randomUUID() )
            .build();
    }

}
