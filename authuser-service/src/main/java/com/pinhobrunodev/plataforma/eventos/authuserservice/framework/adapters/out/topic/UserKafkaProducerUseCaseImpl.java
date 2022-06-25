package com.pinhobrunodev.plataforma.eventos.authuserservice.framework.adapters.out.topic;

import com.google.gson.Gson;
import com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out.UserKafkaProducerUseCase;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.kafka.KafkaDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class UserKafkaProducerUseCaseImpl implements UserKafkaProducerUseCase  {

    private final KafkaTemplate<String,String> kafkaTemplate;


    @Override
    public void produceMessageToOpenWallet(KafkaDto kafkaDto) {
        final var gson = new Gson();
        var payload = gson.toJson(kafkaDto);
        kafkaTemplate.send("create-user-topic",payload);

    }
}
