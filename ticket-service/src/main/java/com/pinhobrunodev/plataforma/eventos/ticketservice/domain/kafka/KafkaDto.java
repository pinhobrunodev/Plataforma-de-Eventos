package com.pinhobrunodev.plataforma.eventos.ticketservice.domain.kafka;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KafkaDto {

    private String eventId;
    private String userBuyerId;
    private String ownerUserId;
    private String ownerName;
    private String userEmail;
    private String userCpf;
}
