package com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.in.rest;

import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.in.AuthServiceUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request.CreateUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class UserController {

    @Autowired
    private AuthServiceUseCase authServiceUseCase;

    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
        authServiceUseCase.createUser(createUserRequestDTO);
        return ResponseEntity.noContent().build();
    }


}
