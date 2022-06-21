package com.pinhobrunodev.plataforma.eventos.authuserservice.framework.config;

import com.pinhobrunodev.plataforma.eventos.authuserservice.AuthuserServiceApplication;
import com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out.UserKafkaProducerUseCase;
import com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out.UserPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.authuserservice.application.service.UserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan(basePackageClasses = AuthuserServiceApplication.class)
public class BeanConfiguration {

    @Bean
    public UserUseCaseImpl userUseCase(UserPersistenceUseCase userPersistenceUseCase, UserKafkaProducerUseCase userKafkaProducerUseCase){

        return new UserUseCaseImpl(userPersistenceUseCase,userKafkaProducerUseCase);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
