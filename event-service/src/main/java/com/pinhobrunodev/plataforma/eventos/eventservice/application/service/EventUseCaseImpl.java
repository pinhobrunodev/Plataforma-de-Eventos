package com.pinhobrunodev.plataforma.eventos.eventservice.application.service;

import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.in.EventUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.EventKafkaProducerUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.EventPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.TicketServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.WalletServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.CreateEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.ReduceEventTicketsRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request.SubscribeEventRequest;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.response.CreateEventResponse;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.response.SubscribeEventResponse;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;
import jdk.jfr.Event;

import java.util.UUID;

public class EventUseCaseImpl implements EventUseCase {

    private final String USER_BUYER_CURRENT_ID_FROM_ACCESS_TOKEN = "1";

    public EventPersistenceUseCase eventPersistenceUseCase;

    public TicketServiceOpenFeignUseCase ticketServiceOpenFeignUseCase;

    public EventKafkaProducerUseCase eventKafkaProducerUseCase;

    public WalletServiceOpenFeignUseCase walletServiceOpenFeignUseCase;

    public EventUseCaseImpl(EventPersistenceUseCase eventPersistenceUseCase,
                            EventKafkaProducerUseCase eventKafkaProducerUseCase,
                            TicketServiceOpenFeignUseCase ticketServiceOpenFeignUseCase,
                            WalletServiceOpenFeignUseCase walletServiceOpenFeignUseCase) {
        this.eventPersistenceUseCase = eventPersistenceUseCase;
        this.eventKafkaProducerUseCase = eventKafkaProducerUseCase;
        this.ticketServiceOpenFeignUseCase = ticketServiceOpenFeignUseCase;
        this.walletServiceOpenFeignUseCase = walletServiceOpenFeignUseCase;
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
        var validationResult = validateTicketsRemaining(eventPersistenceUseCase.getEventById(eventId), subscribeEventRequest.getTicketsQuantity());
        if (validationResult == Boolean.FALSE) {
            throw new RuntimeException("A quantidade de ingressos solicitados ultrapassa o limite máximo para esse evento");
        }
        var totalAmount = computeTotalAmount(
                subscribeEventRequest.getTicketsQuantity(),
                ticketServiceOpenFeignUseCase.getTicketValue(String.valueOf(eventId)).getTicketValue());
        var validAmountForTransactionResponse = walletServiceOpenFeignUseCase.getValidationAmountFromWallet(USER_BUYER_CURRENT_ID_FROM_ACCESS_TOKEN, totalAmount);
        if (validAmountForTransactionResponse.getIsValid().booleanValue() == Boolean.TRUE) {
            reduceEventTicketsRemaining(eventId, subscribeEventRequest.getTicketsQuantity());
        }
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
    public void reduceEventTicketsRemaining(UUID eventId, Object ticketQuantityToReduce) {
        var newTicketsQuantity = 0;
        if (ticketQuantityToReduce.getClass().equals(ReduceEventTicketsRequest.class)) {
            var reduceEventTicketsRequest = new ReduceEventTicketsRequest(Integer.valueOf((String) ticketQuantityToReduce));
            var eventEntity = eventPersistenceUseCase.getEventById(eventId);
            newTicketsQuantity = eventEntity.getTicketRemaining() - reduceEventTicketsRequest.getTicketsQuantityToReduce();
            eventEntity.setTicketRemaining(newTicketsQuantity);
            eventPersistenceUseCase.updateEvent(eventEntity);
        }
        var eventEntity = eventPersistenceUseCase.getEventById(eventId);
        newTicketsQuantity = eventEntity.getTicketRemaining() - Integer.valueOf((String) ticketQuantityToReduce);
        eventEntity.setTicketRemaining(newTicketsQuantity);
        eventPersistenceUseCase.updateEvent(eventEntity);
    }

    @Override
    public Double computeTotalAmount(Integer ticketsQuantityToBuy, Double ticketValue) {
        return ticketValue * ticketsQuantityToBuy;
    }
}
