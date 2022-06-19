package com.pinhobrunodev.plataforma.eventos.ticketservice.framework.adapters.in.topic;

import com.google.gson.Gson;
import com.pinhobrunodev.plataforma.eventos.ticketservice.application.ports.in.TicketServiceUseCase;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.kafka.KafkaDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TicketServiceListener {

    @Autowired
    private TicketServiceUseCase ticketServiceUseCase;

    @KafkaListener(topics = "${topic.name}")
    public  void listen (ConsumerRecord<String,String> payload){
        final var gson = new Gson();
        var payloadValue = gson.fromJson(payload.value(), KafkaDto.class);
        ticketServiceUseCase.confirmTicketBoughtUpdate(payloadValue);

    }

}
