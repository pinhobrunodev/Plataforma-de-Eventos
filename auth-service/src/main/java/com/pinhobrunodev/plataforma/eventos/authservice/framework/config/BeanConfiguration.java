package com.pinhobrunodev.plataforma.eventos.authservice.framework.config;

import com.pinhobrunodev.plataforma.eventos.authservice.AuthServiceApplication;
import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out.UserPersistencePortUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.application.service.AuthServiceUseCaseImpl;
import com.pinhobrunodev.plataforma.eventos.authservice.framework.mapper.AuthServiceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AuthServiceApplication.class)
public class BeanConfiguration {

    @Bean
    public AuthServiceUseCaseImpl authServiceUseCaseImpl(UserPersistencePortUseCase userPersistencePortUseCase,
                                                         AuthServiceMapper authServiceMapper){
        return new AuthServiceUseCaseImpl(userPersistencePortUseCase,authServiceMapper);
    }

}
