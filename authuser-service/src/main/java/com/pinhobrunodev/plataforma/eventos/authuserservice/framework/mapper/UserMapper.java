package com.pinhobrunodev.plataforma.eventos.authuserservice.framework.mapper;

import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.request.RegisterUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.response.GetUserInfoByCPFResponseDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    @Autowired
    private static BCryptPasswordEncoder encoder;


    public  static GetUserInfoByCPFResponseDTO getUserInfoByCPFConverter(UserEntity userEntity){
        return GetUserInfoByCPFResponseDTO
                .builder()
                .userId(userEntity.getUserId())
                .fullName(userEntity.getFullName())
                .userEmail(userEntity.getUserEmail())
                .userCpf(userEntity.getUserCpf())
                .build();
    }


    public static UserEntity registerUserConverter(RegisterUserRequestDTO registerUserRequestDTO){
        return UserEntity
                .builder()
                .userId(UUID.randomUUID())
                .fullName(registerUserRequestDTO.getFullName())
                .userPassword(encoder.encode(registerUserRequestDTO.getUserPassword()))
                .userEmail(registerUserRequestDTO.getUserEmail())
                .userCpf(registerUserRequestDTO.getUserCpf())
                .build();
    }


}
