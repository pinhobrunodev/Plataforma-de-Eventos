package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.out.feign;

import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.WalletServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response.ValidAmountForTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceOpenFeignUseCaseImpl implements WalletServiceOpenFeignUseCase {

    @Autowired
    private WalletServiceFeignClient walletServiceFeignClient;

    @Override
    public ValidAmountForTransactionResponse getValidationAmountFromWallet(String userId, Double totalAmount) {
        try {
            return walletServiceFeignClient.validAmountForTransaction(userId, totalAmount).getBody();
        } catch (Exception e) {
            throw new RuntimeException("Algum erro no outro microserviço - Wallet-Service");
        }

    }
}
