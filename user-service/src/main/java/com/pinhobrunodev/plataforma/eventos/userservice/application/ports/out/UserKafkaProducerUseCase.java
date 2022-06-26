package com.pinhobrunodev.plataforma.eventos.userservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.userservice.domain.kafka.KafkaDto;

public interface UserKafkaProducerUseCase {

    void produceMessageToOpenWallet(KafkaDto kafkaDto);


}
