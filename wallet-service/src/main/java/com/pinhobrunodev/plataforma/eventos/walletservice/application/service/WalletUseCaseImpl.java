package com.pinhobrunodev.plataforma.eventos.walletservice.application.service;

import com.pinhobrunodev.plataforma.eventos.walletservice.application.ports.in.WalletUseCase;
import com.pinhobrunodev.plataforma.eventos.walletservice.application.ports.out.WalletServicePersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.dto.request.IncreaseAmountRequest;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.dto.response.ValidAmountForTransactionResponse;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.kafka.KafkaDto;
import com.pinhobrunodev.plataforma.eventos.walletservice.framework.mapper.WalletMapper;

import java.time.LocalDateTime;

public class WalletUseCaseImpl implements WalletUseCase {

    public WalletServicePersistenceUseCase walletServicePersistenceUseCase;


    public WalletUseCaseImpl(WalletServicePersistenceUseCase walletServicePersistenceUseCase) {
        this.walletServicePersistenceUseCase = walletServicePersistenceUseCase;
    }


    /*
      Create Wallet.
   */
    @Override
    public void createWallet(KafkaDto kafkaDto) {
        walletServicePersistenceUseCase.saveWallet(WalletMapper.createWalletConverter(kafkaDto));
    }

    /*
        Validate Wallet amount for transaction.
     */
    @Override
    public ValidAmountForTransactionResponse validateAmount(String userId, Double totalAmount) {
        var currentWalletAmount = walletServicePersistenceUseCase.getWalletAmount(userId);
        var validAmountForTransactionResponse = isValidAmount(currentWalletAmount, totalAmount) ? new ValidAmountForTransactionResponse(Boolean.TRUE) : new ValidAmountForTransactionResponse(Boolean.FALSE);
        if (validAmountForTransactionResponse.getIsValid().booleanValue() == Boolean.FALSE) {
           throw new RuntimeException("Sem saldo suficiente na carteira para realizar a compra.");
        }
        decreaseAmountFromWallet(userId, totalAmount);
        return validAmountForTransactionResponse;
    }

    /*
       Increase  wallet amount.
    */
    @Override
    public void increaseAmountFromWallet(String userId, IncreaseAmountRequest increaseAmountRequest) {
        var newBalance = 0.00;
        if (!isValidAmountToIncrease(increaseAmountRequest.getValueToBeIncreased()))
            throw new RuntimeException("Valor não pode ser menor ou igual a zero");
        var wallet = walletServicePersistenceUseCase.getWalletByUserId(userId);
        newBalance = wallet.getAmount() + increaseAmountRequest.getValueToBeIncreased();
        wallet.setAmount(newBalance);
        wallet.setIncreaseAmountAt(LocalDateTime.now());
        walletServicePersistenceUseCase.saveWallet(wallet);
    }

    /*
        Decrease  wallet amount.
     */

    @Override
    public void decreaseAmountFromWallet(String userId, Double amountToBeReduced) {
        var wallet = walletServicePersistenceUseCase.getWalletByUserId(userId);
        var newAmountAfterReduce = wallet.getAmount() - amountToBeReduced;
        wallet.setAmount(newAmountAfterReduce);
        wallet.setReduceAmountAt(LocalDateTime.now());
        walletServicePersistenceUseCase.saveWallet(wallet);
    }

    @Override
    public Boolean isValidAmount(Double amountFromCurrentWallet, Double amountFromPossibleTransaction) {
        return amountFromCurrentWallet >= amountFromPossibleTransaction;
    }

    @Override
    public Boolean isValidAmountToIncrease(Double amountToIncrease) {
        return amountToIncrease <= 0.00;
    }
}
