package com.example.springtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.service.UserService;





@RestController
@RequestMapping("/")
public class MainController{

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/database/{id}")
    public String getUserWithId(@RequestParam String param) {
        userService.getUserByName("123");
        return new String("123");
    }
    
    
}