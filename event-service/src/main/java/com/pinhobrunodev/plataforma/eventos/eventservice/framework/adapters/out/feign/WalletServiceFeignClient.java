package com.pinhobrunodev.plataforma.eventos.eventservice.framework.adapters.out.feign;


import com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response.ValidAmountForTransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "wallet-service", url = "${wallet.service.endpoint}")
public interface WalletServiceFeignClient {

    @GetMapping(value = "/user/{userId}/amount/{totalAmount}")
    ResponseEntity<ValidAmountForTransactionResponse> validAmountForTransaction(@PathVariable(name = "userId") String userId,
                                                                                @PathVariable(name = "totalAmount") Double totalAmount);
}
