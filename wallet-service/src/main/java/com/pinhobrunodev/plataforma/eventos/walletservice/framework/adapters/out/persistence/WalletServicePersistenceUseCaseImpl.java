package com.pinhobrunodev.plataforma.eventos.walletservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.walletservice.application.ports.out.WalletServicePersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.entities.WalletEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServicePersistenceUseCaseImpl implements WalletServicePersistenceUseCase {


    @Autowired
    private WalletH2Repository walletH2Repository;

    @Override
    public Double getWalletAmount(String userId) {
        return walletH2Repository
                .findWalletEntityByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Não foi possivel achar uma carteira referente a esse usuario"))
                .getAmount();
    }

    @Override
    public WalletEntity getWalletByUserId(String userId) {
        return walletH2Repository
                .findWalletEntityByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Não foi possivel achar uma carteira referente a esse usuario"));
    }

    @Override
    public void saveWallet(WalletEntity walletEntity) {
        walletH2Repository.save(walletEntity);
    }
}
