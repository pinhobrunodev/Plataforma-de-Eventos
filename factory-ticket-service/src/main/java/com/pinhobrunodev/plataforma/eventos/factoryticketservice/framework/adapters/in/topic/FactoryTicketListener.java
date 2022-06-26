package com.pinhobrunodev.plataforma.eventos.factoryticketservice.framework.adapters.in.topic;

import com.google.gson.Gson;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.application.ports.in.FactoryTicketUseCase;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.application.ports.out.TicketServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.kafka.KafkaListenerDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FactoryTicketListener {

    @Autowired
    private FactoryTicketUseCase factoryTicketUseCase;
    @Autowired
    private TicketServiceOpenFeignUseCase ticketServiceOpenFeignUseCase;



    @KafkaListener(topics = "${topic.name.consumer}",groupId = "factory-ticket-group")
    public void factoryTicketConsumer(ConsumerRecord<String, String> payload) {
        log.info("message received from topic : {}", payload);
        final Gson gson = new Gson();
        var kafkaListenerDto = gson.fromJson(payload.value(), KafkaListenerDto.class);
        ticketServiceOpenFeignUseCase.persistTickets(kafkaListenerDto.getAccess_token(),factoryTicketUseCase.generateTickets(kafkaListenerDto));
    }


}
