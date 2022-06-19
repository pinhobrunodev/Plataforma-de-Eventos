package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.in.rest;

import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.in.EventUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.CreateEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.ReduceEventTicketsRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.SubscribeEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.response.CreateEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    private EventUseCase eventUseCase;

    @PostMapping(value = "/create",produces = "application/json",consumes = "application/json")
    public ResponseEntity<CreateEventResponse> createEvent(@Valid @RequestBody CreateEventRequest createEventRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventUseCase.createEvent(createEventRequest));
    }

    @PostMapping(value = "/{eventId}/subscribe",produces = "application/json",consumes = "application/json")
    public ResponseEntity<?> subscribeEvent(@PathVariable UUID eventId, @RequestBody SubscribeEventRequest subscribeEventRequest){
        return  ResponseEntity.status(HttpStatus.CREATED).body(eventUseCase.subscribeEvent(eventId,subscribeEventRequest));
    }

    @PutMapping(value = "/{eventId}/reduce/tickets")
    public ResponseEntity<Void> reduceTicketsAmount(@PathVariable UUID eventId, @RequestBody ReduceEventTicketsRequest reduceEventTicketsRequest){
        return ResponseEntity.noContent().build();
    }

}
