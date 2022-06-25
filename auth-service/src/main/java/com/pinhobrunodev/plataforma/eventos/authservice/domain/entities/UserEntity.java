package com.pinhobrunodev.plataforma.eventos.authservice.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "tb_user")
public class UserEntity {

    @Id
    private String userId;
    private String userEmail;
    @JsonIgnore
    private String userPassword;

    @ManyToMany
    @JoinTable(name = "tb_user_role"
            ,joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

}
