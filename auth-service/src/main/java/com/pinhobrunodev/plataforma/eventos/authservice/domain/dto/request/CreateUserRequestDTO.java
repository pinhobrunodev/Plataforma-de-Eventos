package com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CreateUserRequestDTO {

    private String userId;
    private String userEmail;
    private String userPassword;
    private List<RoleInfoRequestDTO> roles;

}
