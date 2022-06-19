package com.pinhobrunodev.plataforma.eventos.ticketservice.application.ports.in;

import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.request.PersistTicketRequest;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.response.TicketValueResponse;

import java.util.Set;

public interface TicketServiceUseCase {

    TicketValueResponse getTicketValue(String eventId);
    void persistTicket(Set<PersistTicketRequest> persistTicketRequestSet);
}
