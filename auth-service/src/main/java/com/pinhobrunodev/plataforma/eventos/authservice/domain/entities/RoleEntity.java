package com.pinhobrunodev.plataforma.eventos.authservice.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String authority;


}
