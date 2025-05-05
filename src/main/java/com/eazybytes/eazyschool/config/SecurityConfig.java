package com.eazybytes.eazyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()  // allow H2 access
                        .anyRequest().authenticated()                  // protect other endpoints
                )
                .formLogin()  // keep login form for other pages
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();  // allow frames for H2 console

        return http.build();
    }
}
