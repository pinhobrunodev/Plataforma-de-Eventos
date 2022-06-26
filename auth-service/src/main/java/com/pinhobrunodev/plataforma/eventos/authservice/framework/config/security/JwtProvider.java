package com.pinhobrunodev.plataforma.eventos.authservice.framework.config.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtProvider {

    @Value("${jwt.duration}")
    private Integer jwtDuration;
    @Value("${jwt.secret}")
    private String jwtSecret;


    public String generateJwt(Authentication authentication) {
        // Extract the UserDetails of the Authentication
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        // roles  => Receive the value ON String of all authorities on the user authenticated
        final String roles = userPrincipal.getAuthorities().stream().map(
                role -> {
                    return role.getAuthority();
                }
        ).collect(Collectors.joining(","));
        return Jwts.builder() // Build the token with the UserDetails information that were extracted by the authentication.
                .setSubject((userPrincipal.getUserId()).toString()) // Create token with UUID -> IMPORTANT TO OTHER MICROSERVICES VALIDATE TOKEN
                .claim("roles",roles) // Insert claims on our token (roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtDuration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // Receive the token that was generated and catch the  userID of the user that are on the token.
    public String getSubjectJwt(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    // Method that valid the token
    public boolean validateJwt(String authToken) {
        try {
            // If is ok , the token will is validated
            // Receive the jwtSecret to see if is right
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature : {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token : {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired : {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {} ", e.getMessage());
        }
        return false;
    }

}
