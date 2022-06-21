package com.pinhobrunodev.plataforma.eventos.authuserservice.application.service;

import com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.in.UserUseCase;
import com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.out.UserPersistenceUseCase;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.request.RegisterUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.response.GetUserInfoByCPFResponseDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.response.RegisterUserResponseDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.framework.mapper.UserMapper;

public class UserUseCaseImpl implements UserUseCase {

    public UserPersistenceUseCase userPersistenceUseCase;

    public UserUseCaseImpl(UserPersistenceUseCase userPersistenceUseCase) {
        this.userPersistenceUseCase = userPersistenceUseCase;
    }


    @Override
    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO registerUserRequestDTO) {
        return new RegisterUserResponseDTO(userPersistenceUseCase.persistUser(UserMapper.registerUserConverter(registerUserRequestDTO)));
    }

    @Override
    public GetUserInfoByCPFResponseDTO getUserByCPF(String cpf) {
        return UserMapper.getUserInfoByCPFConverter(userPersistenceUseCase.getUserByCPF(cpf));
    }

}

