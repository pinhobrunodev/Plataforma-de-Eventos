package com.pinhobrunodev.plataforma.eventos.authservice.application.ports.in;

import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request.CreateUserRequestDTO;

public interface AuthServiceUseCase {

    void createUser(CreateUserRequestDTO createUserRequestDTO);
}
