package com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.in;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.CreateEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.ReduceEventTicketsRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.SubscribeEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.response.CreateEventResponse;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.response.SubscribeEventResponse;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;

import java.util.UUID;

public interface EventUseCase {

    /*
        Controller Use Case
     */
    CreateEventResponse createEvent(CreateEventRequest createEventRequest);
    SubscribeEventResponse subscribeEvent(String token,UUID eventId, SubscribeEventRequest subscribeEventRequest);
    void reduceEventTicketsRemaining(UUID eventId, Object ticketQuantityToReduce);


     /*
        Business Use Case
     */

    Boolean validateTicketsRemaining(EventEntity eventEntity,Integer ticketsQuantityToBuy);
    Double computeTotalAmount(Integer ticketsQuantityToBuy,Double ticketValue);


}
