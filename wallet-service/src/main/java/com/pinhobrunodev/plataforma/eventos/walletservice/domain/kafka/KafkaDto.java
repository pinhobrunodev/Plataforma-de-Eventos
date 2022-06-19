package com.pinhobrunodev.plataforma.eventos.walletservice.domain.kafka;

import lombok.Data;

@Data
public class KafkaDto {

    private String userId;
    private String userEmail;
    private String userCpf;

}
