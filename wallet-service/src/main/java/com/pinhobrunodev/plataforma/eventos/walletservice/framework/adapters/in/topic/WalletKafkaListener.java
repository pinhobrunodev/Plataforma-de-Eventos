package com.pinhobrunodev.plataforma.eventos.walletservice.framework.adapters.in.topic;

import com.google.gson.Gson;
import com.pinhobrunodev.plataforma.eventos.walletservice.application.ports.in.WalletUseCase;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.kafka.KafkaDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WalletKafkaListener {

    @Autowired
    private WalletUseCase walletUseCase;

    @KafkaListener(topics = "${topic.name}")
    public void listen(ConsumerRecord<String, String> payload) {
        final var gson = new Gson();
        var payloadValue = gson.fromJson(payload.value(), KafkaDto.class);
        walletUseCase.createWallet(payloadValue);
    }


}
