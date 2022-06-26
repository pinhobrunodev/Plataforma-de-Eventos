package com.pinhobrunodev.plataforma.eventos.userservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.userservice.domain.openfeign.CreateUserRequestToAuthServiceDTO;

public interface AuthServiceOpenFeignUseCase {

    void createUserToAuthService(CreateUserRequestToAuthServiceDTO createUserRequestToAuthServiceDTO);

}
