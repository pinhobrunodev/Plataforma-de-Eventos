package com.pinhobrunodev.plataforma.eventos.authservice.application.service;

import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.in.AuthUserServiceUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out.UserPersistencePortUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request.CreateUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authservice.framework.mapper.AuthServiceMapper;

public class AuthUserServiceUseCaseImpl implements AuthUserServiceUseCase {

    public UserPersistencePortUseCase userPersistencePortUseCase;
    public AuthServiceMapper authServiceMapper;

    public AuthUserServiceUseCaseImpl(UserPersistencePortUseCase userPersistencePortUseCase, AuthServiceMapper authServiceMapper) {
        this.userPersistencePortUseCase = userPersistencePortUseCase;
        this.authServiceMapper = authServiceMapper;
    }

    @Override
    public void createUser(CreateUserRequestDTO createUserRequestDTO) {
        userPersistencePortUseCase.saveUser(authServiceMapper.createUserConverter(createUserRequestDTO));
    }
}
