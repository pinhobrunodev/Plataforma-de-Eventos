package com.pinhobrunodev.plataforma.eventos.authservice.framework.mapper;

import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request.CreateUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request.RoleInfoRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.UserEntity;
import com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.out.persistence.RoleH2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceMapper {

    @Autowired
    private static RoleH2Repository roleH2Repository;

    public static UserEntity createUserConverter(CreateUserRequestDTO createUserRequestDTO) {
        var userEntity = new UserEntity();
        userEntity.setUserId(createUserRequestDTO.getUserId());
        userEntity.setUserPassword(createUserRequestDTO.getUserPassword());
        userEntity.setUserEmail(createUserRequestDTO.getUserEmail());
        for (RoleInfoRequestDTO role : createUserRequestDTO.getRoles()) {
            var roleEntity = roleH2Repository.findById(role.getRoleId()).orElseThrow(
                    () -> new RuntimeException("Role not found")
            );
            userEntity.getRoles().add(roleEntity);
        }
        return userEntity;
    }
}
