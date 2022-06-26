package com.pinhobrunodev.plataforma.eventos.factoryticketservice.framework.adapters.out.feign;

import com.pinhobrunodev.plataforma.eventos.factoryticketservice.application.ports.out.TicketServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.dto.CreateTicketRequest;
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
    public void persistTickets(String access_token, Set<CreateTicketRequest> createTicketRequestSet) {
        log.info("Tickets quantity  to be persisted at {} : {}", LocalDateTime.now(),createTicketRequestSet.size());
        ticketServiceFeignClient.persistTickets(access_token,createTicketRequestSet);
    }
}
