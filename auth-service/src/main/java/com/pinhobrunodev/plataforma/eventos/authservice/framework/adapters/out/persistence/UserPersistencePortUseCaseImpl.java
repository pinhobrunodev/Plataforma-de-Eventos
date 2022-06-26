package com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out.UserPersistencePortUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPersistencePortUseCaseImpl implements UserPersistencePortUseCase {

    @Autowired
    private UserH2Repository h2Repository;

    @Override
    public UserEntity findByUserId(String userId) {
        return  h2Repository.findByUserId(userId).orElseThrow(()-> new RuntimeException("nao encontrou usuario com esse id"));
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        h2Repository.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return h2Repository.findByUserEmail(email).orElseThrow(() -> new RuntimeException("nao encontrou usuario com esse email"));
    }
}
