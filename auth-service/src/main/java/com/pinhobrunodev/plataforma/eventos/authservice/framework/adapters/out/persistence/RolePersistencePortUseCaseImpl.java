package com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out.RolePersistencePortUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePersistencePortUseCaseImpl implements RolePersistencePortUseCase {

    @Autowired
    private RoleEntityH2Repository repository;

    @Override
    public RoleEntity findRoleByName(String roleName) {
        return repository.findByAuthority(roleName).orElseThrow(()-> new RuntimeException("nome da role nao encontrada"));
    }
}
