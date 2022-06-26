package com.pinhobrunodev.plataforma.eventos.ticketservice.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime boughtAt;



}
