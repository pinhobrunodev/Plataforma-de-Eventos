package com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.response;

import lombok.Data;

@Data
public class TicketValueResponse {

    private Double ticketValue;

    public TicketValueResponse(Double ticketValueFromEntity){
        ticketValue = ticketValueFromEntity;
    }

}
