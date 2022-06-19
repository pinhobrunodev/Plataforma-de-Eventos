package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.out.feign;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response.TicketValueResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ticket-service", url = "${ticket.service.endpoint}")
public interface TicketServiceFeignClient {
    @GetMapping(value = "/event/{eventId}/value")
    ResponseEntity<TicketValueResponse> getTicketValue(@PathVariable String eventId);
}
