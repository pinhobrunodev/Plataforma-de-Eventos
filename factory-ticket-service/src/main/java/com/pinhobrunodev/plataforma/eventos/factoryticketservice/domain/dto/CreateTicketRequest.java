package com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CreateTicketRequest {

    private UUID ticketId;
    private String eventId;
    private Double ticketValue;

}
