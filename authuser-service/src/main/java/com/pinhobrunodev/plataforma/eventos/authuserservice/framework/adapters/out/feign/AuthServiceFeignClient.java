package com.pinhobrunodev.plataforma.eventos.authuserservice.framework.adapters.out.feign;

import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.openfeign.CreateUserRequestToAuthServiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Component
@FeignClient(name = "auth-service", url = "${auth.service.endpoint}")
public interface AuthServiceFeignClient {
    @PostMapping(value = "/callback/user/save")
    ResponseEntity<Void> createUser(@RequestBody CreateUserRequestToAuthServiceDTO createUserRequestToAuthServiceDTO);
}
