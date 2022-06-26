package com.pinhobrunodev.plataforma.eventos.userservice.framework.adapters.in.rest;

import com.pinhobrunodev.plataforma.eventos.userservice.application.ports.in.UserUseCase;
import com.pinhobrunodev.plataforma.eventos.userservice.domain.dto.request.RegisterUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.userservice.domain.dto.response.GetUserInfoByCPFResponseDTO;
import com.pinhobrunodev.plataforma.eventos.userservice.domain.dto.response.RegisterUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    private UserUseCase userUseCase;

    @PostMapping(value = "/create")
    public ResponseEntity<RegisterUserResponseDTO> createUser(@RequestBody RegisterUserRequestDTO registerUserRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userUseCase.registerUser(registerUserRequestDTO));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<GetUserInfoByCPFResponseDTO> getUserByCPF(@PathVariable String cpf) {
        return ResponseEntity.ok(userUseCase.getUserByCPF(cpf));
    }

}
