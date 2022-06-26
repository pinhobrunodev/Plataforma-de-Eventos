package com.pinhobrunodev.plataforma.eventos.factoryticketservice.framework.config;


import com.pinhobrunodev.plataforma.eventos.factoryticketservice.FactoryTicketServiceApplication;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.application.service.FactoryTicketUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = FactoryTicketServiceApplication.class)
public class BeanConfiguration {

    @Bean
    public FactoryTicketUseCaseImpl factoryTicketUseCaseImpl(){
        return new FactoryTicketUseCaseImpl();
    }
}
