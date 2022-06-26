package com.pinhobrunodev.plataforma.eventos.userservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.userservice.application.ports.out.UserPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.userservice.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPersistenceUseCaseImpl implements UserPersistenceUseCase {

    @Autowired
    private UserH2Repository userH2Repository;

    @Override
    public UserEntity getUserByCPF(String cpf) {
        return userH2Repository.findUserEntityByUserCpf(cpf)
                .orElseThrow(() -> new RuntimeException("nao achou usuario"));
    }

    @Override
    public UserEntity persistUser(UserEntity userEntity) {
        return userH2Repository.save(userEntity);
    }
}

