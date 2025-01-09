package com.project.FocusFlow.config;

import com.project.FocusFlow.security.RateLimitingFilter;
import com.project.FocusFlow.security.UserDetailsServiceImpl;
import com.project.FocusFlow.security.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private final TokenFilter tokenFilter;
    RateLimitingFilter rateLimitingFilter;

    @Autowired
    public SecurityConfig(TokenFilter tokenFilter, RateLimitingFilter rateLimitingFilter) {
        this.tokenFilter = tokenFilter;
        this.rateLimitingFilter = rateLimitingFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()))
                .exceptionHandling(exceptions -> exceptions
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/secured/getBasicInfo").permitAll()
                        .requestMatchers("/secured/**").authenticated()
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        .anyRequest().permitAll())
                .formLogin(login -> login
                        .loginPage("/login") // Указываем путь к странице логина
                        .loginProcessingUrl("/login") // URL для обработки формы логина (совпадает с th:action в HTML)
                        .defaultSuccessUrl("/secured/getBasicInfo", true) // Перенаправление после успешного входа
                        .failureUrl("/login?error=true") // Перенаправление при ошибке входа
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL для logout
                        .logoutSuccessUrl("/login?logout=true") // Перенаправление после успешного выхода
                        .permitAll())
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(rateLimitingFilter,
                        org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
