package com.pinhobrunodev.plataforma.eventos.userservice.framework.adapters.out.feign;

import com.pinhobrunodev.plataforma.eventos.userservice.application.ports.out.AuthServiceOpenFeignUseCase;
import com.pinhobrunodev.plataforma.eventos.userservice.domain.openfeign.CreateUserRequestToAuthServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceOpenFeignUseCaseImpl implements AuthServiceOpenFeignUseCase {

    @Autowired
    private AuthServiceFeignClient authServiceFeignClient;

    @Override
    public void createUserToAuthService(CreateUserRequestToAuthServiceDTO createUserRequestToAuthServiceDTO) {
        try {
            authServiceFeignClient.createUser(createUserRequestToAuthServiceDTO);
        }catch (Exception e){
            throw  new RuntimeException("Erro do outro lado (auth-service) - "+e);
        }
    }
}
