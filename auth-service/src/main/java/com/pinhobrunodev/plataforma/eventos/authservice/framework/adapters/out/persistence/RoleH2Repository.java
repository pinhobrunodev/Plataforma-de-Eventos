package com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.RoleEntity;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleH2Repository extends JpaRepository<RoleEntity,Long> {
}
