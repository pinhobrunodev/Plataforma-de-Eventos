package com.pinhobrunodev.plataforma.eventos.authservice.domain.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class RoleEntity {

    @Id
    private Long roleId;
    private String authority;


}
