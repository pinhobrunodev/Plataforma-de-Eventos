package com.pinhobrunodev.plataforma.eventos.authuserservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.authuserservice.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserH2Repository extends JpaRepository<UserEntity, UUID> {

    @Query("SELECT DISTINCT obj FROM UserEntity obj WHERE obj.userCpf = :cpf")
    Optional<UserEntity> findUserEntityByUserCpf(String cpf);
}
