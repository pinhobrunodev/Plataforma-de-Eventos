package com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.response;

import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.entities.UserEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class RegisterUserResponseDTO {

    private UUID userId;

    public RegisterUserResponseDTO(UserEntity userEntity) {
        userId = userEntity.getUserId();
    }
}
