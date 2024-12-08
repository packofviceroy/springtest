package com.example.springtest.security;
// package com.example.springtest.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import com.example.springtest.service.MyUserDetailService;


// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
//     @Bean
//     public UserDetailsService userDetailsService() {return new MyUserDetailService(); };

//     @Bean 
//     public PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(10); };

//     @Bean 
//     public AuthenticationProvider authenticationProvider(){
//         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//         provider.setUserDetailsService(userDetailsService());
//         provider.setPasswordEncoder(passwordEncoder());
//         return provider;
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//         return  http
//                 .csrf(AbstractHttpConfigurer::disable)

//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/api/rest/login", "/static/**", "/recources/**").permitAll() 
//                         .anyRequest().authenticated()
//                 )
//                 .formLogin(form -> form
//                         .loginPage("/api/rest/login").permitAll()
//                         .failureUrl("/loginError").permitAll()
//                         .defaultSuccessUrl("/main_page", true) 
//                         )
//                 .logout((logout) -> logout
//                         .logoutUrl("/auth/logout")
//                         .logoutSuccessUrl("/login")
//                         .permitAll())
//                 .build();
//     }

// }
