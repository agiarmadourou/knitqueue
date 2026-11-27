package com.knitqueue.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/** Configures HTTP security and authentication for KnitQueue. */
@Configuration
public class SecurityConfig {

    // Restrict project endpoints to authenticated users with the USER role.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                    .requestMatchers("/api/projects","/api/projects/**")
                    .hasRole("USER")
                    .anyRequest().denyAll()

                );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // BCrypt Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
