package com.pinhobrunodev.plataforma.eventos.ticketservice.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@Entity
public class TicketEntity {

    @Id
    private UUID ticketId;
    private String eventId;
    private Double ticketValue;
    private String userBuyerId;
    private String ownerUserId;
    private String ownerName;
    private String ownerEmail;
    private String ownerCpf;



}
