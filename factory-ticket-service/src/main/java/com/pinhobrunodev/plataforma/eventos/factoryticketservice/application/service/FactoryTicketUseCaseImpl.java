package com.pinhobrunodev.plataforma.eventos.factoryticketservice.application.service;

import com.pinhobrunodev.plataforma.eventos.factoryticketservice.application.ports.in.FactoryTicketUseCase;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.dto.CreateTicketRequest;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.kafka.KafkaListenerDto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FactoryTicketUseCaseImpl implements FactoryTicketUseCase {

    @Override
    public Set<CreateTicketRequest> generateTickets(KafkaListenerDto kafkaListenerDto) {
        Set<CreateTicketRequest> createTicketRequests = new HashSet<>();
        for (int i = 0; i < kafkaListenerDto.getTicketRemaining(); i++) {
            createTicketRequests.add(
                    CreateTicketRequest
                            .builder()
                            .eventId(kafkaListenerDto.getEventId())
                            .ticketValue(kafkaListenerDto.getTicketValue())
                            .ticketId(UUID.randomUUID())
                            .build()
            );
        }
        return createTicketRequests;
    }
}
