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
                        .boughtAt(null)
                        .build()
        ));
        return ticketEntities;
    }

    public static TicketEntity confirmTicketBoughtUpdateConverter(TicketEntity ticketEntity, KafkaDto kafkaDto) {
        return ticketEntity
                .builder()
                .ownerName(kafkaDto.getOwnerName())
                .ownerCpf(kafkaDto.getUserCpf())
                .ownerEmail(kafkaDto.getUserEmail())
                .ownerUserId(kafkaDto.getOwnerUserId())
                .userBuyerId(kafkaDto.getUserBuyerId())
                .boughtAt(LocalDateTime.now())
                .build();
    }

}

