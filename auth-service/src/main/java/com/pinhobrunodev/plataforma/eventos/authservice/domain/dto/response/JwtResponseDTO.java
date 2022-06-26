package com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.response;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor // To build the Jwt only with obligatory attributes ( token )
public class JwtResponseDTO {


    @NonNull // -> Specifying the only parameter on the constructor
    private String token;
    private String type = "Bearer";
}
