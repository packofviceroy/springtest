
package com.example.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    public SecurityController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("signin")
    ResponseEntity<?> signin(@RequestBody SignInRequest entity) {
        
        //TODO: Add username password validation
        User user = null;
        try{
            user = userService.getUserByName(entity.getUsername());
            if (user != null){
                if (passwordEncoder.matches(entity.getPassword(),user.getPassword())){
                    return ResponseEntity.ok("123");
                }else{
                    throw new UserNotFoundException(user.getName());
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.badRequest().build();
    }
    
}
