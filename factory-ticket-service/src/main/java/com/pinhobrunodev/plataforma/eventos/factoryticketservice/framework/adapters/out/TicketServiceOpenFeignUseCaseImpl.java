package com.pinhobrunodev.plataforma.eventos.factoryticketservice.framework.adapters.out;

import com.pinhobrunodev.plataforma.eventos.factoryticketservice.application.ports.out.TicketServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.dto.CreateTicketRequest;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.framework.adapters.out.feign.TicketServiceFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Slf4j
@Component
public class TicketServiceOpenFeignUseCaseImpl implements TicketServiceOpenFeignUseCase {

    @Autowired
    private TicketServiceFeignClient ticketServiceFeignClient;

    @Override
    public void persistTickets(Set<CreateTicketRequest> createTicketRequestSet) {
        log.info("Tickets sent to be persisted at {} : {}", LocalDateTime.now(),createTicketRequestSet);
        ticketServiceFeignClient.persistTickets(createTicketRequestSet);
    }
}
