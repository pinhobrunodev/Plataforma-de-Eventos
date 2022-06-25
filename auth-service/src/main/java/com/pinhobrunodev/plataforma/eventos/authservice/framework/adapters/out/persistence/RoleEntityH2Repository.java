package com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleEntityH2Repository extends JpaRepository<RoleEntity,Long> {

    Optional<RoleEntity> findByAuthority(String authority);
}
