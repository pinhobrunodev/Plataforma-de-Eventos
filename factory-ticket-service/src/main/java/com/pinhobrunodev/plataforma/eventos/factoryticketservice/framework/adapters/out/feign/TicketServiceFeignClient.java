package com.pinhobrunodev.plataforma.eventos.factoryticketservice.framework.adapters.out.feign;


import com.pinhobrunodev.plataforma.eventos.factoryticketservice.domain.dto.CreateTicketRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Set;

@FeignClient(name = "ticket-service",url = "${ticket.service.endpoint}")
public interface TicketServiceFeignClient {

    @PostMapping(value = "/ticket/persist", produces = "application/json", consumes = "application/json")
    void persistTickets(@RequestBody Set<CreateTicketRequest> createTicketRequestSet);

}
