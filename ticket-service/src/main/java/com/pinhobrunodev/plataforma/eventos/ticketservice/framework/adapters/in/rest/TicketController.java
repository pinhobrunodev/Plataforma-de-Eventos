package com.pinhobrunodev.plataforma.eventos.ticketservice.framework.adapters.in.rest;


import com.pinhobrunodev.plataforma.eventos.ticketservice.application.ports.in.TicketServiceUseCase;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.request.PersistTicketRequest;
import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.dto.response.TicketValueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

    @Autowired
    private TicketServiceUseCase ticketServiceUseCase;

    @PostMapping(value = "/persist",produces = "application/json",consumes = "application/json")
    public ResponseEntity<Void> persistTickets(@RequestHeader("Authorization") @RequestBody Set<PersistTicketRequest> persistTicketRequestSet){
        ticketServiceUseCase.persistTicket(persistTicketRequestSet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/event/{eventId}/value")
    public ResponseEntity<TicketValueResponse> getTicketValue(@PathVariable String eventId){
        return ResponseEntity.ok(ticketServiceUseCase.getTicketValue(eventId));
    }

}
