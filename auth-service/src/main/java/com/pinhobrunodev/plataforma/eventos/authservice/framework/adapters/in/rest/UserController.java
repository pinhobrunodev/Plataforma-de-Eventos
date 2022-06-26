package com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.in.rest;

import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.in.AuthUserServiceUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request.CreateUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AuthUserServiceUseCase authUserServiceUseCase;

    @PostMapping(value = "/callback/user/save")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
        authUserServiceUseCase.createUser(createUserRequestDTO);
        return ResponseEntity.noContent().build();
    }


}
