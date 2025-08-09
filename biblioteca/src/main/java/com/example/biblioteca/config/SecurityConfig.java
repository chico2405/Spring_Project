package com.example.biblioteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                        .requestMatchers(HttpMethod.GET,"/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/livros/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/livros").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/livros/**").hasRole("ADMIN")
                        .requestMatchers("/adicionar-exemplar").hasRole("ADMIN")
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
                )

                .formLogin(withDefaults())
                .httpBasic(withDefaults());

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}