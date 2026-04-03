package com.SpringBoot.JobTracker.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // ✅ NEW WAY to disable CSRF
            .csrf(csrf -> csrf.disable())

            // ✅ Authorization
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/","/login", "/register", "/css/**").permitAll()
                .anyRequest().authenticated()
            )

            // ✅ Login config
            .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/jobs", true)
                .permitAll()
            )

            // ✅ Logout
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}