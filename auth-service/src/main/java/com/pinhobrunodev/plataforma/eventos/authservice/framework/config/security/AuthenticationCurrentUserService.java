package com.pinhobrunodev.plataforma.eventos.authservice.framework.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

// Extract the information of Current User that is sending the REQUEST
@Service
public class AuthenticationCurrentUserService {


    public UserDetailsImpl getCurrentUser() {
        // This method allows to get all information of current user
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    //  or parameter or this way...
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


}

