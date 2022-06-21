package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.out.feign;

import com.pinhobrunodev.plataforma.eventos.eventservice.application.ports.out.AuthUserServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response.GetUserInfoByCPFResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthUserOpenFeignUseCaseImpl implements AuthUserServiceOpenFeignUseCase {

    @Autowired
    private AuthUserFeignClient authUserFeignClient;


    @Override
    public GetUserInfoByCPFResponseDTO getUserInfoByCPF(String userOwnerCpf) {
        try {
            return authUserFeignClient.getUserByCPF(userOwnerCpf).getBody();
        }
        catch (Exception e){
            throw new RuntimeException("Erro no outro lado ( AuthUser )");
        }
    }
}
