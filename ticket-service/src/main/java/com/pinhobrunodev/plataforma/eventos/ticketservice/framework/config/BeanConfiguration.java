package com.pinhobrunodev.plataforma.eventos.ticketservice.framework.config;

import com.pinhobrunodev.plataforma.eventos.ticketservice.TicketServiceApplication;
import com.pinhobrunodev.plataforma.eventos.ticketservice.application.ports.out.TicketPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.ticketservice.application.service.TicketServiceUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TicketServiceApplication.class)
public class BeanConfiguration {

    @Bean
    public TicketServiceUseCaseImpl ticketServiceUseCase(TicketPersistenceUseCase ticketPersistenceUseCase){
        return new TicketServiceUseCaseImpl(ticketPersistenceUseCase);
    }

}
