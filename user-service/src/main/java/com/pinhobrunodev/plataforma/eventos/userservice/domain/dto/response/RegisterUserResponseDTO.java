package com.pinhobrunodev.plataforma.eventos.userservice.domain.dto.response;

import com.pinhobrunodev.plataforma.eventos.userservice.domain.entities.UserEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class RegisterUserResponseDTO {

    private UUID userId;

    public RegisterUserResponseDTO(UserEntity userEntity) {
        userId = userEntity.getUserId();
    }
}
