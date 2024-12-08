
package com.example.springtest.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import com.example.springtest.model.MyUserDetails;
import com.example.springtest.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



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

    
    public String generateToken(Authentication authentication){
        MyUserDetails mud = (MyUserDetails)authentication.getPrincipal();
        String jwts = Jwts.builder().subject(mud.getUsername()).issuedAt(new Date()).
                                    expiration(new Date((new Date()).getTime() + lifetime))
                                    .signWith(SignatureAlgorithm.HS256, secret)
                                    .compact();
        return jwts;
    }
}
