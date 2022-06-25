package com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.RoleEntity;

public interface RolePersistencePortUseCase {
    RoleEntity findRoleByName(String roleName);
}
