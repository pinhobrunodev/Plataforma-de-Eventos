package com.pinhobrunodev.plataforma.eventos.userservice.application.ports.in;

import com.pinhobrunodev.plataforma.eventos.userservice.domain.dto.request.RegisterUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.userservice.domain.dto.response.GetUserInfoByCPFResponseDTO;
import com.pinhobrunodev.plataforma.eventos.userservice.domain.dto.response.RegisterUserResponseDTO;

public interface UserUseCase {

    GetUserInfoByCPFResponseDTO getUserByCPF(String cpf);
    RegisterUserResponseDTO registerUser(RegisterUserRequestDTO registerUserRequestDTO);

}
