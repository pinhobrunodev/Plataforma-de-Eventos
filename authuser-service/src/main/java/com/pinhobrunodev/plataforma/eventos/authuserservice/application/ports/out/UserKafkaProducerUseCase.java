package com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.kafka.KafkaDto;

public interface UserKafkaProducerUseCase {

    void produceMessageToOpenWallet(KafkaDto kafkaDto);


}
