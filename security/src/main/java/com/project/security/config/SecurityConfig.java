package com.project.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;


public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http.authorizeRequests()
                .antMatchers("/myAccount").hasAnyRole("USER")
                .antMatchers("/myBalance").hasAnyRole("ADMIN")
                .antMatchers("/myLoans").authenticated()
                .antMatchers("/myCards").hasAnyRole("USER", "ADMIN")
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .and().csrf().disable()
                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);

        http.headers().frameOptions().sameOrigin();

    }



}
