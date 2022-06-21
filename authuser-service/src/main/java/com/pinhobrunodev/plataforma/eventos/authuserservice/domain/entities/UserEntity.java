package com.pinhobrunodev.plataforma.eventos.authuserservice.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Builder
@Entity
public class UserEntity {

    @Id
    private UUID userId;
    private String fullName;
    @JsonIgnore
    private String userPassword;
    private String userEmail;
    private String userCpf;



}
