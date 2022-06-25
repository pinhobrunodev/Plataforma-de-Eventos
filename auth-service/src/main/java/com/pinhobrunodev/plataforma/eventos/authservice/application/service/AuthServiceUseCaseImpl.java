package com.pinhobrunodev.plataforma.eventos.authservice.application.service;

import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.in.AuthServiceUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out.AuthServicePersistencePortUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request.CreateUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authservice.framework.mapper.AuthServiceMapper;

public class AuthServiceUseCaseImpl implements AuthServiceUseCase {


    public AuthServicePersistencePortUseCase authServicePersistencePortUseCase;

    public AuthServiceUseCaseImpl(AuthServicePersistencePortUseCase authServicePersistencePortUseCase) {
        this.authServicePersistencePortUseCase = authServicePersistencePortUseCase;
    }

    @Override
    public void createUser(CreateUserRequestDTO createUserRequestDTO) {
        authServicePersistencePortUseCase.saveUser(AuthServiceMapper.createUserConverter(createUserRequestDTO));
    }
}
