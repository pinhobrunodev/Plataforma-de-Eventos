package com.pinhobrunodev.plataforma.eventos.ticketservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.ticketservice.application.ports.out.TicketPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.entities.TicketEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TicketPersistenceUseCaseImpl implements TicketPersistenceUseCase {

    @Autowired
    private TicketH2Repository ticketH2Repository;

    @Override
    public void saveTickets(TicketEntity ticketEntity) {
        log.info("Tickets to be persisted: {}", ticketEntity);
        ticketH2Repository.save(ticketEntity);
    }

    @Override
    public Double getTicketValueByEventId(String eventId) {
        return ticketH2Repository
                .findTicketEntityByEventId(eventId)
                .orElseThrow(() -> new RuntimeException("Não existe nenhum ingresso associado a esse evento"))
                .getTicketValue();

    }

    @Override
    public TicketEntity getTicketByEventId(String eventId) {
        return ticketH2Repository
                .findTicketEntityByEventId(eventId)
                .orElseThrow(() -> new RuntimeException("Não existe nenhum ingresso associado a esse evento"));
    }
}
