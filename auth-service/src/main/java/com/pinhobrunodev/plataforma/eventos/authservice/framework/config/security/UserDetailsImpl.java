package com.pinhobrunodev.plataforma.eventos.authservice.framework.config.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pinhobrunodev.plataforma.eventos.authservice.domain.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private String userId;
    private String userEmail;
    @JsonIgnore
    private String userPassword;
    private Collection<? extends GrantedAuthority> authorities; // Collection of Any Type that extends GrantedAuthority


    public static UserDetailsImpl build(UserEntity userEntity) {
        // Extract the list of authorities for a specific userModel that came from the Database... to Spring analyze and see what role the user have.
        List<GrantedAuthority> authorities = userEntity.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
        return new UserDetailsImpl( // -> Conversion UserModel to UserDetailsImpl
                userEntity.getUserId(),
                userEntity.getUserPassword(),
                userEntity.getUserPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }


    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
