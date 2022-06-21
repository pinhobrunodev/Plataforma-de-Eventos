package com.pinhobrunodev.plataforma.eventos.authuserservice.application.ports.in;

import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.request.RegisterUserRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.response.GetUserInfoByCPFResponseDTO;
import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.dto.response.RegisterUserResponseDTO;

public interface UserUseCase {

    GetUserInfoByCPFResponseDTO getUserByCPF(String cpf);
    RegisterUserResponseDTO registerUser(RegisterUserRequestDTO registerUserRequestDTO);

}
