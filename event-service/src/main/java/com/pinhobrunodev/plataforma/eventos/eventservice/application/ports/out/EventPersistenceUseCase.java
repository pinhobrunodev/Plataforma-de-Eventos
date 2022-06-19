package com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.CreateEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;

import java.util.UUID;

public interface EventPersistenceUseCase {

    EventEntity saveEvent(CreateEventRequest createEventRequest);
    EventEntity getEventById(UUID eventId);
    void updateEvent(EventEntity eventEntity);

}
