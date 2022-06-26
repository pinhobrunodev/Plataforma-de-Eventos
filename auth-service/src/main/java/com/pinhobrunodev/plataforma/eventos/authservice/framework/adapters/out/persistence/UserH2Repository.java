package com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.out.persistence;

import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserH2Repository extends JpaRepository<UserEntity,String> {
    @EntityGraph(attributePaths = "roles",type = EntityGraph.EntityGraphType.FETCH) // In a specific method I need a EAGER query.(roles = UserModel Relation  to RoleModel)
    Optional<UserEntity> findByUserEmail(String userEmail);
    Optional<UserEntity> findByUserId(String userId);

}
