package com.pinhobrunodev.plataforma.eventos.eventservice.domain.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEventRequest {
    private UUID eventId;
    private String eventName;
    private String eventLocation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime eventDate;
    private Integer ticketRemaining;
    @DecimalMin(value = "0.01",message = "Minimum value R$ 0.01")
    private Double ticketValue;


}
