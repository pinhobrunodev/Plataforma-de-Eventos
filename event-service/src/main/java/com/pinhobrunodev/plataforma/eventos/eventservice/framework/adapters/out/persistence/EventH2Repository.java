package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventH2Repository extends JpaRepository<EventEntity, UUID> {


}
