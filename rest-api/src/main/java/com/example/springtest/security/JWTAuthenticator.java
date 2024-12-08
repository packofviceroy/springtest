
package com.example.springtest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.example.springtest.service.UserService;

public class JWTAuthenticator {

    @Autowired
    UserService userService;


    @Value("${myapp.myvars.security.lifetime}")
    private int lifetime;

    @Value("${myapp.myvars.security.secret}")
    String secret;


    public JWTAuthenticator(UserService userService){
        this.userService = userService;
    }

    

}
