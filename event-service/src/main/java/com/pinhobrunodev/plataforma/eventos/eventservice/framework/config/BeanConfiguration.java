package com.pinhobrunodev.plataforma.eventos.eventservice.framework.config;

import com.pinhobrunodev.plataforma.eventos.eventservice.EventServiceApplication;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.EventKafkaProducerUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.EventPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.TicketServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.service.EventUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = EventServiceApplication.class)
public class BeanConfiguration {

    @Bean
    public EventUseCaseImpl eventUseCaseImpl(EventPersistenceUseCase eventPersistenceUseCase, EventKafkaProducerUseCase eventKafkaProducerUseCase, TicketServiceOpenFeignUseCase ticketServiceOpenFeignUseCase){
        return new EventUseCaseImpl(eventPersistenceUseCase,eventKafkaProducerUseCase,ticketServiceOpenFeignUseCase);
    }

}
