package com.example.springtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springtest.model.User;
import com.example.springtest.service.UserService;


@RestController
@RequestMapping("/")
public class UserController{

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
        public ModelAndView getMethodName() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        return modelAndView;
    }


    @GetMapping(value = "database/user/{value}")
    public User getUserByID(@PathVariable int value) {
        return userService.getUser(value);
    }
    
}