package com.pinhobrunodev.plataforma.eventos.walletservice.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ValidAmountForTransactionResponse {

    public Boolean isValid;

}
