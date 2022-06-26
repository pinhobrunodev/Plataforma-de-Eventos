package com.pinhobrunodev.plataforma.eventos.authservice.framework.config.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Class that represent some exception during the process of AUTHENTICATION
 *
 */
@Log4j2
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.error("Unauthorized error: {}",e.getMessage());
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
    }
}

