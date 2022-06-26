package com.pinhobrunodev.plataforma.eventos.userservice.domain.kafka;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KafkaDto {

    private String userId;
    private String userEmail;
    private String userCpf;

}
