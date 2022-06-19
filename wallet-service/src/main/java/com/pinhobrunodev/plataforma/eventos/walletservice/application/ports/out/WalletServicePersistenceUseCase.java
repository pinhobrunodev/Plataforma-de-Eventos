package com.pinhobrunodev.plataforma.eventos.walletservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.walletservice.domain.entities.WalletEntity;

public interface WalletServicePersistenceUseCase {

    Double getWalletAmount(String userId);
    WalletEntity getWalletByUserId(String userId);
    void saveWallet(WalletEntity walletEntity);


}
