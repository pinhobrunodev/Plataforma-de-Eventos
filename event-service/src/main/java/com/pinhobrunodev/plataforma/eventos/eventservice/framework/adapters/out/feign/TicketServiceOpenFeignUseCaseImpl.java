package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.out.feign;

import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.TicketServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response.TicketValueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceOpenFeignUseCaseImpl implements TicketServiceOpenFeignUseCase {

    @Autowired
    private TicketServiceFeignClient ticketServiceFeignClient;

    @Override
    public TicketValueResponse getTicketValue(String eventId) {
        return ticketServiceFeignClient.getTicketValue(eventId).getBody();
    }
}
