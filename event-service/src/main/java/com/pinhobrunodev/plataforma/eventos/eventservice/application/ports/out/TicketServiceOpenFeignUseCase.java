package com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response.TicketValueResponse;

public interface TicketServiceOpenFeignUseCase {

    TicketValueResponse getTicketValue(String eventId);

}
