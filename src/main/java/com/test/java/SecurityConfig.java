package com.test.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import com.test.java.jwt.JwtAuthenticationFilter;

/**
 * Clase de configuracion para security 
 */
@Configuration
public class SecurityConfig  {

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
    
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
    	/**
    	 * Escribir los paths de los controllers a escanear
    	 */
        return (web) -> web.ignoring().requestMatchers("/token/generate", "/token/protected", "/user");
    }
}
