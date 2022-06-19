package com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscribeEventRequest {

    //private String userBuyerId;
    private String userOwnerCpf;
    private Integer ticketsQuantity;

}
