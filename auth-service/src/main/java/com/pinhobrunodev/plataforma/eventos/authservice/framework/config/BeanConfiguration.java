package com.pinhobrunodev.plataforma.eventos.authservice.framework.config;

import com.pinhobrunodev.plataforma.eventos.authservice.AuthServiceApplication;
import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out.AuthServicePersistencePortUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.application.service.AuthServiceUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AuthServiceApplication.class)
public class BeanConfiguration {

    @Bean
    public AuthServiceUseCaseImpl authServiceUseCaseImpl(AuthServicePersistencePortUseCase authServicePersistencePortUseCase){
        return new AuthServiceUseCaseImpl(authServicePersistencePortUseCase);
    }

}
