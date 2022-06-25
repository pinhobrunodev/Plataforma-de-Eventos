package com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserH2Repository extends JpaRepository<UserEntity,String> {
}
