
package com.example.springtest.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.context.annotation.Configuration;

import com.example.springtest.model.MyUserDetails;
import com.example.springtest.service.UserService;

import io.jsonwebtoken.Jwts;

@Configuration
public class JWTAuthenticator {

    @Autowired
    UserService userService;

    @Value("${myapp.myvars.security.lifetime}")
    private int lifetime;

    @Value("${myapp.myvars.security.secret}")
    private String secret;

    private SecretKey secretKey = Jwts.SIG.HS256.key().build();

    public JWTAuthenticator(UserService userService){
        this.userService = userService;
    }

    
    public String generateToken(Authentication authentication){
        MyUserDetails mud = (MyUserDetails)authentication.getPrincipal();
        String jwts = Jwts.builder().subject(mud.getUsername()).issuedAt(new Date()).
                                    expiration(new Date((new Date()).getTime() + lifetime))
                                    .signWith(secretKey)
                                    .compact();
        return jwts;
    }

    public String getNameFromToken(String jwtToken){
        return Jwts.parser().verifyWith(secretKey).build().parse(jwtToken).getPayload().toString();
    }
}
