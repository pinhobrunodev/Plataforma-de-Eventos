package com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.openfeign.CreateUserRequestToAuthServiceDTO;

public interface AuthServiceOpenFeignUseCase {

    void createUserToAuthService(CreateUserRequestToAuthServiceDTO createUserRequestToAuthServiceDTO);

}
