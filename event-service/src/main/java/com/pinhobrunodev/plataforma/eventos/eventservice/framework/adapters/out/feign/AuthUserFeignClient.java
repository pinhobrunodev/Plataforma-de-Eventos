package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.out.feign;

import com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response.GetUserInfoByCPFResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ticket-service", url = "${authuser.service.endpoint}")
public interface AuthUserFeignClient {

    @GetMapping(value = "/cpf/{cpf}")
     ResponseEntity<GetUserInfoByCPFResponseDTO> getUserByCPF(@PathVariable String cpf);

}
