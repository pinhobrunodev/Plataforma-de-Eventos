package com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class PersistTicketRequest {

    private UUID ticketId;
    private String eventId;
    private Double ticketValue;

}
