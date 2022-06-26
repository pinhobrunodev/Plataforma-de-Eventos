package com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;

public interface EventKafkaProducerUseCase {

    void produceKafkaMessage(String token,EventEntity eventEntity,Double ticketValue);

}
