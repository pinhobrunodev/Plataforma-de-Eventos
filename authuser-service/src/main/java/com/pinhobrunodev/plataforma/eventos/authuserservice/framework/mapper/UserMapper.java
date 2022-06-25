package com.pinhobrunodev.plataforma.eventos.authuserservice.framework.mapper;

import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.request.RegisterUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.response.GetUserInfoByCPFResponseDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.entities.UserEntity;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.kafka.KafkaDto;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.openfeign.CreateUserRequestToAuthServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {



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
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        var userEntity = new UserEntity();
        userEntity.setUserId(UUID.randomUUID());
        userEntity.setFullName(registerUserRequestDTO.getFullName());
        userEntity.setUserCpf(registerUserRequestDTO.getUserCpf());
        userEntity.setUserEmail(registerUserRequestDTO.getUserEmail());
        userEntity.setUserPassword(passwordEncoder.encode(registerUserRequestDTO.getUserPassword()));
        return userEntity;
    }


    public static KafkaDto kafkaDtoConverter(UserEntity userEntity){
        return KafkaDto
                .builder()
                .userId(userEntity.getUserId().toString())
                .userCpf(userEntity.getUserCpf())
                .userEmail(userEntity.getUserEmail())
                .build();
    }

    public static CreateUserRequestToAuthServiceDTO sendToAuthUserConverter(UserEntity userEntity){
        return CreateUserRequestToAuthServiceDTO
                .builder()
                .userId(userEntity.getUserId().toString())
                .userEmail(userEntity.getUserEmail())
                .userPassword(userEntity.getUserPassword())
                .roleName("ROLE_BASIC")
                .build();
    }
}
