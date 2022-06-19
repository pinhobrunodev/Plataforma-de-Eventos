package com.pinhobrunodev.plataforma.eventos.ticketservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.ticketservice.domain.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface TicketH2Repository extends JpaRepository<TicketEntity, UUID> {

    @Query("SELECT DISTINCT obj FROM TicketEntity obj WHERE obj.eventId = :eventId")
    Optional<TicketEntity> findTicketEntityByEventId(String eventId);


}
