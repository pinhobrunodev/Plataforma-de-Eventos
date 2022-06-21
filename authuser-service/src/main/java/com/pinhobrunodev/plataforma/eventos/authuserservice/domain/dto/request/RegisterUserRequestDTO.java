package com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterUserRequestDTO {

    private UUID userId;
    private String fullName;
    private String userPassword;
    private String userEmail;
    private String userCpf;

}
