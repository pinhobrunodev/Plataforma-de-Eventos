package com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.entities.UserEntity;

public interface UserPersistenceUseCase {
    UserEntity getUserByCPF(String cpf);
    UserEntity persistUser(UserEntity userEntity);
}
