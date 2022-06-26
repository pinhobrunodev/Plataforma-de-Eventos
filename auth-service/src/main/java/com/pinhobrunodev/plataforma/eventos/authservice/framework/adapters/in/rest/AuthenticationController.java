package com.pinhobrunodev.plataforma.eventos.authservice.framework.adapters.in.rest;

import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.request.LoginRequestDTO;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.dto.response.JwtResponseDTO;
import com.pinhobrunodev.plataforma.eventos.authservice.framework.config.security.JwtProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping(value = "/login")
    public ResponseEntity<JwtResponseDTO> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate( // Used to make the authentication -> UserDetails...Query...etc.. and return a object authenticated
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUserEmail(), loginRequestDTO.getUserPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication); // Setting the authentication on the Security Context of application with the object authenticated
        String jwt = jwtProvider.generateJwt(authentication); // Generating the JWT token of the object authenticated
        return ResponseEntity.ok(new JwtResponseDTO(jwt));

    }

}
