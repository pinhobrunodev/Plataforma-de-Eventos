package com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response.GetUserInfoByCPFResponseDTO;

public interface AuthUserServiceOpenFeignUseCase {

    GetUserInfoByCPFResponseDTO getUserInfoByCPF(String userOwnerCpf);
}
