package com.pinhobrunodev.plataforma.eventos.walletservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.walletservice.domain.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;


public interface WalletH2Repository extends JpaRepository<WalletEntity, UUID> {

    @Query("SELECT DISTINCT obj FROM WalletEntity obj WHERE obj.userId = :userId")
    Optional<WalletEntity> findWalletEntityByUserId(String userId);


}
