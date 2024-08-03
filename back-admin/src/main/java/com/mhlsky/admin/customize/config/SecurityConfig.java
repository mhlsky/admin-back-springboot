package com.mhlsky.admin.customize.config;

import cn.hutool.json.JSONUtil;
import com.mhlsky.common.core.dto.ResponseDTO;
import com.mhlsky.common.exception.ApiException;
import com.mhlsky.common.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
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

    /**
     * 未登陆/登录异常处理类
     * 用户未登陆的话  在这个Bean中处理
     */
/*     @Bean
    public AuthenticationEntryPoint unauthorizedHandler() {
        return (request, response, exception) -> {
            ResponseDTO<Object> responseDTO = ResponseDTO.fail(
                    new ApiException(ErrorCode.Client.COMMON_NO_AUTHORIZATION, request.getRequestURI())
            );
            ServletHolderUtil.renderString(response, JSONUtil.toJsonStr(responseDTO));
        };
    } */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(
                    auth -> auth.requestMatchers("/","/login","/register","/getConfig","/captchaImage","/api/**").anonymous()
                        .requestMatchers("/*/api-docs","/*/api-docs/swagger-config").anonymous()
                        .requestMatchers("/swagger-ui/**").anonymous()
                );
        return httpSecurity.build();
    }
}
