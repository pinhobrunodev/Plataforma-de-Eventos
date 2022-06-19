package com.pinhobrunodev.plataforma.eventos.ticketservice.framework.mapper;


import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.request.PersistTicketRequest;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.entities.TicketEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TicketMapper {

    public static Set<TicketEntity> persistTicketConverter(Set<PersistTicketRequest> persistTicketRequestSet) {
        Set<TicketEntity> ticketEntities = new HashSet<>();
        persistTicketRequestSet.stream().forEach(x -> ticketEntities.add(
                TicketEntity
                        .builder()
                        .ticketId(x.getTicketId())
                        .eventId(x.getEventId())
                        .ticketValue(x.getTicketValue())
                        .ownerName(null)
                        .ownerCpf(null)
                        .ownerEmail(null)
                        .ownerUserId(null)
                        .userBuyerId(null)
                        .build()
        ));
        return ticketEntities;
    }

}

