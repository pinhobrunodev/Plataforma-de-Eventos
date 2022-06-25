package com.pinhobrunodev.plataforma.eventos.authuserservice.application.service;

import com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.in.UserUseCase;
import com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out.AuthServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out.UserKafkaProducerUseCase;
import com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out.UserPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.request.RegisterUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.response.GetUserInfoByCPFResponseDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.response.RegisterUserResponseDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.framework.mapper.UserMapper;

public class UserUseCaseImpl implements UserUseCase {

    public UserPersistenceUseCase userPersistenceUseCase;

    public UserKafkaProducerUseCase userKafkaProducerUseCase;

    public AuthServiceOpenFeignUseCase authServiceOpenFeignUseCase;

    public UserUseCaseImpl(UserPersistenceUseCase userPersistenceUseCase, UserKafkaProducerUseCase userKafkaProducerUseCase,AuthServiceOpenFeignUseCase authServiceOpenFeignUseCase) {
        this.userPersistenceUseCase = userPersistenceUseCase;
        this.userKafkaProducerUseCase = userKafkaProducerUseCase;
        this.authServiceOpenFeignUseCase= authServiceOpenFeignUseCase;
    }


    @Override
    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO registerUserRequestDTO) {
        var userEntity = userPersistenceUseCase.persistUser(UserMapper.registerUserConverter(registerUserRequestDTO));
        authServiceOpenFeignUseCase.createUserToAuthService(UserMapper.sendToAuthUserConverter(userEntity));
        userKafkaProducerUseCase.produceMessageToOpenWallet(UserMapper.kafkaDtoConverter(userEntity));
        return new RegisterUserResponseDTO(userEntity);
    }

    @Override
    public GetUserInfoByCPFResponseDTO getUserByCPF(String cpf) {
        return UserMapper.getUserInfoByCPFConverter(userPersistenceUseCase.getUserByCPF(cpf));
    }

}

