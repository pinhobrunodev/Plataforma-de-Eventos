package com.pinhobrunodev.plataforma.eventos.ticketservice.framework.mapper;


import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.request.PersistTicketRequest;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.entities.TicketEntity;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.kafka.KafkaDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class TicketMapper {

    public static Set<TicketEntity> persistTicketConverter(Set<PersistTicketRequest> persistTicketRequestSet) {
        Set<TicketEntity> ticketEntities = new HashSet<>();
        persistTicketRequestSet.stream().forEach(x -> ticketEntities.add(
                new TicketEntity(
                        x.getTicketId(), x.getEventId(), x.getTicketValue(), null, null,
                        null, null, null, null)));
        return ticketEntities;
    }

    public static TicketEntity confirmTicketBoughtUpdateConverter(TicketEntity ticketEntity, KafkaDto kafkaDto) {
        ticketEntity.setOwnerName(kafkaDto.getOwnerName());
        ticketEntity.setOwnerCpf(kafkaDto.getUserCpf());
        ticketEntity.setOwnerEmail(kafkaDto.getUserEmail());
        ticketEntity.setOwnerUserId(kafkaDto.getOwnerUserId());
        ticketEntity.setUserBuyerId(kafkaDto.getUserBuyerId());
        ticketEntity.setBoughtAt(LocalDateTime.now());
        return ticketEntity;
    }

}

