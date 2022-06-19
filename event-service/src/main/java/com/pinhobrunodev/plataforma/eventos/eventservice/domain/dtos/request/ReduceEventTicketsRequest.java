package com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReduceEventTicketsRequest {

    private Integer ticketsQuantityToReduce;

}
