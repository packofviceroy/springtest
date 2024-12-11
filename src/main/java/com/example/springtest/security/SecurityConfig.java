package com.example.springtest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.springtest.service.MyUserDetailService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {return new MyUserDetailService(); };

    @Bean 
    public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(10); };

    @Autowired
    private TokenFilter tokenFilter;

    SecurityConfig(TokenFilter tokenFilter){
        this.tokenFilter = tokenFilter;
    }

    @Bean 
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return  http
                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/rest/security/**", "/static/**", "/recources/**").permitAll() 
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .failureUrl("/loginError").permitAll()
                        .defaultSuccessUrl("/main_page", true) 
                        )
                .logout((logout) -> logout
                        .logoutUrl("/auth/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll())
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
