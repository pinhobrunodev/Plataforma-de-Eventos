package com.pinhobrunodev.plataforma.eventos.walletservice.application.ports.in;

import com.pinhobrunodev.plataforma.eventos.walletservice.domain.dto.request.IncreaseAmountRequest;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.dto.response.ValidAmountForTransactionResponse;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.kafka.KafkaDto;

public interface WalletUseCase {

    ValidAmountForTransactionResponse validateAmount(String userId,Double totalAmount);
    void increaseAmountFromWallet(String userId, IncreaseAmountRequest increaseAmountRequest);
    void decreaseAmountFromWallet(String userId,Double amountToBeReduced);
    void createWallet(KafkaDto kafkaDto);

    Boolean isValidAmount(Double amountFromCurrentWallet,Double amountFromPossibleTransaction);
    Boolean isValidAmountToIncrease(Double amountToIncrease);

}
