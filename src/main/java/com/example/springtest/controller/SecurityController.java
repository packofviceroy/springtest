
package com.example.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.exception.UserNotFoundException;
import com.example.springtest.model.SignInRequest;
import com.example.springtest.model.User;
import com.example.springtest.security.JWTAuthenticator;
import com.example.springtest.service.UserService;


@RestController
@RequestMapping("/api/rest/security")
public class SecurityController {
    
    @Autowired
    UserService userService;

    @Autowired
    JWTAuthenticator jwtAuth;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationProvider authenticationProvider;


    public SecurityController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("signin")
    ResponseEntity<?> signin(@RequestBody SignInRequest entity) {
            Authentication authentication = null;
            String jwt = null;
        try{
            authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(entity.getUsername(), entity.getPassword()));
        }catch (AuthenticationException e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatusCode.valueOf(403)).body("123");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        jwt = jwtAuth.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }
    
}
