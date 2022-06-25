package com.pinhobrunodev.plataforma.eventos.authuserservice.domain.openfeign;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUserRequestToAuthServiceDTO {

    private String userId;
    private String userEmail;
    private String userPassword;
    private String roleName;

}
