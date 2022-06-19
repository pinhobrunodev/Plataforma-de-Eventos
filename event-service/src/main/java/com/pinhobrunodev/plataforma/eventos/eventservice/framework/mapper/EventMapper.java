package com.pinhobrunodev.plataforma.eventos.eventservice.framework.mapper;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.CreateEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.kafka.KafkaDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EventMapper {


    public static EventEntity createEventConverter(CreateEventRequest createEventRequest) {
        return EventEntity
                .builder()
                .eventId(UUID.randomUUID())
                .eventName(createEventRequest.getEventName())
                .eventLocation(createEventRequest.getEventLocation())
                .eventDate(createEventRequest.getEventDate())
                .ticketRemaining(createEventRequest.getTicketRemaining())
                .build();
    }

    public static KafkaDto SendToKafkaConverter(EventEntity eventEntity){
        return KafkaDto
                .builder()
                .eventId(eventEntity.getEventId().toString())
                .ticketRemaining(eventEntity.getTicketRemaining())
                .ticketValue(eventEntity.getTicketValue())
                .build();
    }
}

