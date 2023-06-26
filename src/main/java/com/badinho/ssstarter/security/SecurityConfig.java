package com.badinho.ssstarter.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.badinho.ssstarter.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((auth) -> auth
                        .antMatchers("/", "index", "/css/*", "/js/*")
                        .permitAll()
                        .antMatchers("/api/**")
                        .hasRole(USER.name())
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails badinho = User.builder()
                .username("badinho")
                .password(passwordEncoder.encode("badinho"))
                .roles(USER.name()) // ROLE_USER
                .build();
        UserDetails peralitos = User.builder()
                .username("peralitos")
                .password(passwordEncoder.encode("peralitos"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                badinho,
                peralitos
        );
    }
}
