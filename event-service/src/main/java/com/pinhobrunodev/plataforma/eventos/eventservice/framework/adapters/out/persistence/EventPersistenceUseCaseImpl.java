package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.EventPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.CreateEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;
import com.pinhobrunodev.plataforma.eventos.eventservice.framework.mapper.EventMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class EventPersistenceUseCaseImpl implements EventPersistenceUseCase {



    @Autowired
    private EventH2Repository eventH2Repository;

    @Override
    public EventEntity saveEvent(CreateEventRequest createEventRequest) {
        log.info("Create Event payload : {}",createEventRequest);
        return eventH2Repository.save(EventMapper.createEventConverter(createEventRequest));
    }

    @Override
    public EventEntity getEventById(UUID eventId) {
        log.info("EventId to be found : {}",eventId);
        return eventH2Repository.findById(eventId).orElseThrow(()-> new RuntimeException("Not found"));
    }

    @Override
    public void updateEvent(EventEntity eventEntity) {
        eventH2Repository.save(eventEntity);
    }
}
