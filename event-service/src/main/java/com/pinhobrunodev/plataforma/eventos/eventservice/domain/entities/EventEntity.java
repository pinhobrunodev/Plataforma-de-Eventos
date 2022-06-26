package com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@Entity
public class EventEntity {
    @Id
    private UUID eventId;
    private String eventName;
    private String eventLocation;
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime eventDate;
    private Integer ticketRemaining;

    @Transient
    private Double ticketValue;

    public EventEntity() {
    }

    public EventEntity(UUID eventId, String eventName, String eventLocation, LocalDateTime eventDate, Integer ticketRemaining) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.ticketRemaining = ticketRemaining;
    }


    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getTicketRemaining() {
        return ticketRemaining;
    }

    public void setTicketRemaining(Integer ticketRemaining) {
        this.ticketRemaining = ticketRemaining;
    }
}
