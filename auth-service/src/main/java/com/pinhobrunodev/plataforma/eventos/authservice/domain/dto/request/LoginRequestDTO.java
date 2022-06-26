package com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDTO {
    @NotBlank(message = "Mandatory field.")
    private String userEmail;
    @NotBlank(message = "Mandatory field.")
    private String userPassword;
}
