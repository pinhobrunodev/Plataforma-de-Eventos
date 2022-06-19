package com.pinhobrunodev.plataforma.eventos.ticketservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.entities.TicketEntity;

public interface TicketPersistenceUseCase {

    void saveTickets(TicketEntity ticketEntity);
    Double getTicketValueByEventId(String eventId);

    TicketEntity getTicketByEventId(String eventId);

}
