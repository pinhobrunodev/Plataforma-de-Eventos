package com.pinhobrunodev.plataforma.eventos.authservice.framework.config.security;

import com.pinhobrunodev.plataforma.eventos.authservice.application.ports.out.UserPersistencePortUseCase;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserPersistencePortUseCase userPersistencePortUseCase;

    public UserDetails loadUserByUserId(String userId) throws AuthenticationCredentialsNotFoundException {
        UserEntity userEntity = userPersistencePortUseCase.findByUserId(userId);
        if(userEntity == null ) throw  new AuthenticationCredentialsNotFoundException("userid not found  : "+userId);
        return UserDetailsImpl.build(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userPersistencePortUseCase.findByEmail(email);
        log.info("usuario encontrado via login : {}",userEntity.getUserId());
        if(userEntity == null ) throw  new UsernameNotFoundException("username not found  : "+email);
        return UserDetailsImpl.build(userEntity);
    }
}
