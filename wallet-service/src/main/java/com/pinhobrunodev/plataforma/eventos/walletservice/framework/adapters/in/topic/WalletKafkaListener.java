package com.pinhobrunodev.plataforma.eventos.walletservice.framework.adapters.in.topic;

import com.google.gson.Gson;
import com.pinhobrunodev.plataforma.eventos.walletservice.application.ports.in.WalletUseCase;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.kafka.KafkaDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WalletKafkaListener {

    @Autowired
    private WalletUseCase walletUseCase;

    @KafkaListener(topics = "${topic.name.consumer}",groupId = "wallet-group")
    public void listen(ConsumerRecord<String, String> payload) {
        final var gson = new Gson();
        var payloadValue = gson.fromJson(payload.value(), KafkaDto.class);
        log.info("payload received : {}",payload);
        walletUseCase.createWallet(payloadValue);
    }


}
