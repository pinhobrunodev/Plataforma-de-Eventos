package com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response.ValidAmountForTransactionResponse;

public interface WalletServiceOpenFeignUseCase {

    ValidAmountForTransactionResponse getValidationAmountFromWallet(String userId,Double totalAmount);

}
