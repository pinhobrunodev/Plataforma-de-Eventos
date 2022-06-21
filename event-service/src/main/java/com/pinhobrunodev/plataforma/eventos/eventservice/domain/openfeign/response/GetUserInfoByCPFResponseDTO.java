package com.pinhobrunodev.plataforma.eventos.eventservice.domain.openfeign.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetUserInfoByCPFResponseDTO {

    private UUID userId;
    private String fullName;
    private String userEmail;
    private String userCpf;


}
