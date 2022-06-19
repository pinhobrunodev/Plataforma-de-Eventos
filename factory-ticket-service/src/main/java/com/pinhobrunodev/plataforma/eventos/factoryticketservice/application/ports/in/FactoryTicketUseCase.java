package com.pinhobrunodev.plataforma.eventos.factoryticketservice.application.ports.in;

import com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.dto.CreateTicketRequest;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.kafka.KafkaListenerDto;

import java.util.Set;

public interface FactoryTicketUseCase {


    Set<CreateTicketRequest> generateTickets(KafkaListenerDto kafkaListenerDto);

}
