package com.pinhobrunodev.plataforma.eventos.walletservice.framework.adapters.in.rest;

import com.pinhobrunodev.plataforma.eventos.walletservice.application.ports.in.WalletUseCase;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.dto.request.IncreaseAmountRequest;
import com.pinhobrunodev.plataforma.eventos.walletservice.domain.dto.response.ValidAmountForTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/wallets")
public class WalletController {

    @Autowired
    private WalletUseCase walletUseCase;


    @PatchMapping(value = "/user/{userId}/increase")
    public ResponseEntity<?> increaseWalletAmount(@PathVariable(value = "userId") String userId,
                                                     @RequestBody IncreaseAmountRequest increaseAmountRequest){
        walletUseCase.increaseAmountFromWallet(userId,increaseAmountRequest);
        return ResponseEntity.ok().body("Saldo adicionado com sucesso");

    }

    @GetMapping(value = "/user/{userId}/amount/{totalAmount}")
    public ResponseEntity<ValidAmountForTransactionResponse> validAmountForTransaction(@PathVariable(name = "userId") String userId,
                                                                                       @PathVariable(name = "totalAmount") Double totalAmount) {
        return ResponseEntity.ok(walletUseCase.validateAmount(userId,totalAmount));
    }

}
