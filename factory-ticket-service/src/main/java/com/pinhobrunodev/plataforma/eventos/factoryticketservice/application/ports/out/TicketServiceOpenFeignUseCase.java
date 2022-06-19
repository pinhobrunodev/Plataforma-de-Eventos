package com.pinhobrunodev.plataforma.eventos.factoryticketservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.dto.CreateTicketRequest;

import java.util.Set;

public interface TicketServiceOpenFeignUseCase {

    void persistTickets(Set<CreateTicketRequest> createTicketRequestSet);

}
