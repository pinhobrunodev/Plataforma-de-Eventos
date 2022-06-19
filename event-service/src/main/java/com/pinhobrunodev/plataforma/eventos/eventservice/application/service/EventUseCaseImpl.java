package com.pinhobrunodev.plataforma.eventos.eventservice.application.service;

import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.in.EventUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.EventKafkaProducerUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.EventPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.TicketServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.CreateEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.ReduceEventTicketsRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.SubscribeEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.response.CreateEventResponse;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.response.SubscribeEventResponse;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;
import jdk.jfr.Event;

import java.util.UUID;

public class EventUseCaseImpl implements EventUseCase {

    public EventPersistenceUseCase eventPersistenceUseCase;

    public TicketServiceOpenFeignUseCase ticketServiceOpenFeignUseCase;

    public EventKafkaProducerUseCase eventKafkaProducerUseCase;

    public EventUseCaseImpl(EventPersistenceUseCase eventPersistenceUseCase, EventKafkaProducerUseCase eventKafkaProducerUseCase, TicketServiceOpenFeignUseCase ticketServiceOpenFeignUseCase) {
        this.eventPersistenceUseCase = eventPersistenceUseCase;
        this.eventKafkaProducerUseCase = eventKafkaProducerUseCase;
        this.ticketServiceOpenFeignUseCase = ticketServiceOpenFeignUseCase;
    }

    public EventUseCaseImpl(EventPersistenceUseCase eventPersistenceUseCase) {
        this.eventPersistenceUseCase = eventPersistenceUseCase;
    }

    /*
        Create a new Event.
     */
    @Override
    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {
        var eventEntity = eventPersistenceUseCase.saveEvent(createEventRequest);
        eventKafkaProducerUseCase.produceKafkaMessage(eventEntity);
        return new CreateEventResponse(eventEntity);
    }

    /*
        Subscribe to an Event.
     */
    @Override
    public SubscribeEventResponse subscribeEvent(UUID eventId, SubscribeEventRequest subscribeEventRequest) {

        /*
            TODO: Catch the claims of the current logged user and take the userId
            UUID currentUserId = authenticationCurrentUserService.getCurrentUser().getUserId(); // Get the current userId on request
         */

        var validationResult = validateTicketsRemaining(eventPersistenceUseCase.getEventById(eventId), subscribeEventRequest.getTicketsQuantity());
        if (validationResult == Boolean.FALSE) {
            throw new RuntimeException("A quantidade de ingressos solicitados ultrapassa o limite máximo para esse evento");
        }
        /*
            Synchronous Request to TICKET-SERVICE -> GET /tickets/event/{eventId}/value
         */
        try {
            var totalAmount = computeTotalAmount(
                    subscribeEventRequest.getTicketsQuantity(),
                    ticketServiceOpenFeignUseCase.getTicketValue(String.valueOf(eventId)).getTicketValue()
            );
        } catch (Exception e) {
            throw new RuntimeException("Algum erro la no outro ms (ticket-service)");
        }

        /*                                                      currentUserId
            TODO: Chamada ao WALLET-SERVICE -> GET /wallet/user/{userId}/amount?totalAmount=XXXX.XX
                  -  Em caso de retorno "true" -> reduceEventTicketsRemaining(eventId,subscribeEventRequest.getTicketsQuantity())
         */


        /*
            TODO: Chamada ao AUTHUSER-SERVICE -> GET /users/cpf/{cpf}
                  - Capturamos o retorno em um objeto

         */


        /*
            TODO: Enviamos para o Kafka um evento para atualizar a base de dados do TICKET-SERVICE
         */

        return null;
    }


    @Override
    public Boolean validateTicketsRemaining(EventEntity eventEntity, Integer ticketsQuantityToBuy) {
        if (eventEntity.getTicketRemaining() >= ticketsQuantityToBuy) return true;
        return false;
    }


    @Override
    public void reduceEventTicketsRemaining(UUID eventId, ReduceEventTicketsRequest reduceEventTicketsRequest) {
        var newTicketsQuantity = 0;
        var eventEntity = eventPersistenceUseCase.getEventById(eventId);
        newTicketsQuantity = eventEntity.getTicketRemaining() - reduceEventTicketsRequest.getTicketsQuantityToReduce();
        eventEntity.setTicketRemaining(newTicketsQuantity);
        eventPersistenceUseCase.updateEvent(eventEntity);
    }

    @Override
    public Double computeTotalAmount(Integer ticketsQuantityToBuy, Double ticketValue) {
        return ticketValue * ticketsQuantityToBuy;
    }
}
