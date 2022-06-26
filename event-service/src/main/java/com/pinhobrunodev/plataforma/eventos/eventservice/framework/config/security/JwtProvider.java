package com.pinhobrunodev.plataforma.eventos.eventservice.framework.config.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    // Method to extract the claims ( 1- get roles )
    public String getClaimsNameJwt(String token, String claimName) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get(claimName).toString();
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
