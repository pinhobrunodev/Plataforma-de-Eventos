package com.pinhobrunodev.plataforma.eventos.walletservice.framework.mapper;

import com.pinhobrunodev.plataforma.eventos.walletservice.domain.entities.WalletEntity;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.kafka.KafkaDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class WalletMapper {


    public static WalletEntity createWalletConverter(KafkaDto kafkaDto) {
        return WalletEntity
                .builder()
                .userId(kafkaDto.getUserId())
                .userEmail(kafkaDto.getUserEmail())
                .userCpf(kafkaDto.getUserCpf())
                .walletId(UUID.randomUUID())
                .amount(0.00)
                .createdAt(LocalDateTime.now())
                .reduceAmountAt(null)
                .increaseAmountAt(null)
                .build();
    }

}
