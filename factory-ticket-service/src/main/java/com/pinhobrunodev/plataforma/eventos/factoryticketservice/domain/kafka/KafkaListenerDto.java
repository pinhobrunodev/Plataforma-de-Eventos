package com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KafkaListenerDto {

    private String eventId;
    private Integer ticketRemaining;
    private Double ticketValue;



}
