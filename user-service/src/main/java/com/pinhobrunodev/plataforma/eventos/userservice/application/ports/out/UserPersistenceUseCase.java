package com.pinhobrunodev.plataforma.eventos.userservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.userservice.domain.entities.UserEntity;

public interface UserPersistenceUseCase {
    UserEntity getUserByCPF(String cpf);
    UserEntity persistUser(UserEntity userEntity);
}
