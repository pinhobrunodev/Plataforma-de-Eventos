package com.pinhobrunodev.plataforma.eventos.walletservice.framework.mapper;

import com.pinhobrunodev.plataforma.eventos.walletservice.domain.entities.WalletEntity;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.kafka.KafkaDto;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class WalletMapper {


    public static WalletEntity createWalletConverter(KafkaDto kafkaDto) {
        var wallet = new WalletEntity();
        wallet.setWalletId(UUID.randomUUID());
        wallet.setUserId(kafkaDto.getUserId());
        wallet.setUserEmail(kafkaDto.getUserEmail());
        wallet.setUserCpf(kafkaDto.getUserCpf());
        wallet.setAmount(0.00);
        wallet.setCreatedAt(LocalDateTime.now());
        wallet.setReduceAmountAt(null);
        wallet.setIncreaseAmountAt(null);
        return wallet;
    }
}
