package com.pinhobrunodev.plataforma.eventos.ticketservice.application.service;

import com.pinhobrunodev.plataforma.eventos.ticketservice.application.ports.in.TicketServiceUseCase;
import com.pinhobrunodev.plataforma.eventos.ticketservice.application.ports.out.TicketPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.request.PersistTicketRequest;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.response.TicketValueResponse;
import com.pinhobrunodev.plataforma.eventos.ticketservice.framework.mapper.TicketMapper;

import java.util.Set;

public class TicketServiceUseCaseImpl implements TicketServiceUseCase {


    public TicketPersistenceUseCase ticketPersistenceUseCase;

    public TicketServiceUseCaseImpl(TicketPersistenceUseCase ticketPersistenceUseCase) {
        this.ticketPersistenceUseCase = ticketPersistenceUseCase;
    }

    @Override
    public void persistTicket(Set<PersistTicketRequest> persistTicketRequestSet) {
        var ticketsEntitySet = TicketMapper.persistTicketConverter(persistTicketRequestSet);
        ticketsEntitySet.stream().forEach(x -> ticketPersistenceUseCase.saveTickets(x));
    }

    @Override
    public TicketValueResponse getTicketValue(String eventId) {
        return new TicketValueResponse(ticketPersistenceUseCase.getTicketValueByEventId(eventId));
    }

}
