package com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.response;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateEventResponse {
    private UUID eventId;

    public CreateEventResponse(EventEntity eventEntity){
        eventId = eventEntity.getEventId();
    }


}
