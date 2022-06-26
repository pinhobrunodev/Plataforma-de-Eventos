package com.pinhobrunodev.plataforma.eventos.authservice.framework.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@EnableWebSecurity // -> Turn off wall security config default
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
// -> This class that will be set the global configuration of AuthenticationManager
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;

    // Endpoint that don't need authentication
    private static final String[] AUTH_WHITELIST = {
            "/auth/**","/h2-console/**","/callback/user/save"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
            What role is the principal... priority
            ROLE_USER => ONLY ROLE_USER
            ROLE_STUDENT => ACCESS STUDENT AND ROLE_USER
            ROLE_INSTRUCTOR => ACCESS INSTRUCTOR,ROLE_STUDENT AND ROLE_USER
            ROLE_ADMIN = ACCESS ADMIN, ROLE_INSTRUCTOR_ROLE_STUDENT AND ROLE_USER
     */
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_ADMIN > ROLE_INSTRUCTOR \n ROLE_INSTRUCTOR > ROLE_STUDENT \n  ROLE_STUDENT > ROLE_USER ";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if(Arrays.asList(environment.getActiveProfiles()).contains("test")){
            http.headers().frameOptions().disable();
        }

        http    // If I have some error during authentication will throw exception to UNAUTHORIZED.
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                // Session = NO STATE ....  Always when throw  a request need to have the token to be validated
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll() // Free the Endpoint ( don't need authentication )
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        // Enabling the Filter and the Spring Security will consider the Filter that we build to validate the tokens that are coming with the requisitions to access the resources
        http.addFilterBefore(authenticationJwtFilter(), UsernamePasswordAuthenticationFilter.class);
        // After this..  the requests -> specific controllers
    }


    @Override
    // The way that authenticationManager will authenticate... userDetailsService return an Obj with UserDetails that have the attributes to authentication.
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // The way that will see the password = passwordEncode
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Bean // -> Allows the consideration of AuthenticationJwTFilter
    public AuthenticationJwtFilter authenticationJwtFilter() {
        return new AuthenticationJwtFilter();
    }


    // Used to authenticate the user
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
