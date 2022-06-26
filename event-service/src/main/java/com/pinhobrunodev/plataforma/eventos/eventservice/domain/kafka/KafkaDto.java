package com.pinhobrunodev.plataforma.eventos.eventservice.domain.kafka;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KafkaDto {

    private String eventId;
    private Integer ticketRemaining;
    private Double ticketValue;

}
