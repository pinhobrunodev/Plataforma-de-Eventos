package com.pinhobrunodev.plataforma.eventos.userservice.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Data
@Entity
@NoArgsConstructor
public class UserEntity {

    @Id
    private UUID userId;
    private String fullName;
    @JsonIgnore
    private String userPassword;
    private String userEmail;
    private String userCpf;



}
