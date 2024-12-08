
package com.example.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.service.UserService;


@RestController
@RequestMapping("/api/rest/security")
public class SecurityController {
    
    @Autowired
    UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("signin")
    public String signin(@RequestBody String entity) {
         
        return entity;
    }
    
}
