package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.out.topic;

import com.google.gson.Gson;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.EventKafkaProducerUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;
import com.pinhobrunodev.plataforma.eventos.eventservice.framework.mapper.EventMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class EventKafkaProducerUseCaseImpl implements EventKafkaProducerUseCase {


    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void produceKafkaMessage(EventEntity eventEntity) {
        final var gson = new Gson();
        var payloadToBeSent = gson.toJson(EventMapper.SendToKafkaConverter(eventEntity));
        log.info("payload sent : {}", payloadToBeSent);
        kafkaTemplate.send("event-service-factory-tickets-topic", payloadToBeSent);
    }
}
