package com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.UserEntity;

public interface UserPersistencePortUseCase {
    void saveUser(UserEntity userEntity);
}
