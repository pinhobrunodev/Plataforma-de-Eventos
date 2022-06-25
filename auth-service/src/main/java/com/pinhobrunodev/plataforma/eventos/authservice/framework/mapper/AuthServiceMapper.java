package com.pinhobrunodev.plataforma.eventos.authservice.framework.mapper;

import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out.RolePersistencePortUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request.CreateUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceMapper {

    @Autowired
    private RolePersistencePortUseCase rolePersistencePortUseCase;

    public  UserEntity createUserConverter(CreateUserRequestDTO createUserRequestDTO) {
        var userEntity = new UserEntity();
        userEntity.setUserId(createUserRequestDTO.getUserId());
        userEntity.setUserPassword(createUserRequestDTO.getUserPassword());
        userEntity.setUserEmail(createUserRequestDTO.getUserEmail());
        var roleEntity = rolePersistencePortUseCase.findRoleByName(createUserRequestDTO.getRoleName());
        userEntity.getRoles().add(roleEntity);
        return userEntity;
    }
}
