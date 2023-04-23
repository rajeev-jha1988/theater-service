package com.example.theaterservice.dto.v1.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingMessageDto {

    private String eventId;
    private String schemaVersion;
    private String eventType;
    private String publisher;
    private Long timestamp;
    private String eventDetails;



}
