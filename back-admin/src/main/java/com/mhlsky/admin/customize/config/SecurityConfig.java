package com.mhlsky.admin.customize.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * :
 *
 * @author mhlsky孟
 * @date 2024/7/30 下午6:38
 * @description
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(
                    auth -> auth
                        .requestMatchers("/*/api-docs","/*/api-docs/swagger-config").anonymous()
                        .requestMatchers("/swagger-ui/**").anonymous()
                );
        return httpSecurity.build();
    }
}
