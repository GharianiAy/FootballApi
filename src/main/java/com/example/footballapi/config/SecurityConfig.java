package com.example.footballapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  // Spring Security configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Disables CSRF protection
                .authorizeRequests()
                .antMatchers("/**").permitAll()  // Allows all requests
                .anyRequest().authenticated();

        return http.build();
    }
}