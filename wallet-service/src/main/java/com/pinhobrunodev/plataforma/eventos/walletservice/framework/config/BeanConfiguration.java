package com.pinhobrunodev.plataforma.eventos.walletservice.framework.config;

import com.pinhobrunodev.plataforma.eventos.walletservice.WalletServiceApplication;
import com.pinhobrunodev.plataforma.eventos.walletservice.application.ports.out.WalletServicePersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.walletservice.application.service.WalletUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = WalletServiceApplication.class)
public class BeanConfiguration {

    @Bean
    public WalletUseCaseImpl walletUseCaseImpl(WalletServicePersistenceUseCase  walletServicePersistenceUseCase){
        return new WalletUseCaseImpl(walletServicePersistenceUseCase);
    }
}
