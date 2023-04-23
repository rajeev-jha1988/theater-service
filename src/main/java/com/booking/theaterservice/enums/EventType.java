package com.example.theaterservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventType {

    THEATER_CREATED("theater.created.success","theater.created.success"),
    THEATER_AUDITORIUM_ADDED("theater-auditorium.added.success","theater-auditorium.added.success");

    private final String event;
   private final String routingKey;
}
