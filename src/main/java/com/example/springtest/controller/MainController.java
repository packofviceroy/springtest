package com.example.springtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springtest.model.User;
import com.example.springtest.service.UserService;



@RestController
@RequestMapping("/")
public class MainController{

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "j_spring_security_check", consumes="application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.OK)
    public void auth(@RequestBody String body) {
        System.out.println(body);
    }
    
    @GetMapping("main")
    // @PreAuthorize("hasAuthority('ROLE_USER')")
        public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main_page.html");
        return modelAndView;
    }

    // @GetMapping("login")
    // // @PreAuthorize("hasAuthority('ROLE_USER')")
    //     public ModelAndView login() {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("login.html");
    //     return modelAndView;
    // }

    @GetMapping("loginError")
    // @PreAuthorize("hasAuthority('ROLE_USER')")
        public ModelAndView loginError() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginError.html");
        return modelAndView;
    }


    @GetMapping(value = "database/user/{value}")
    @PreAuthorize("hasAuthority('ROLE_DB')")
    public User getUserByID(@PathVariable String value) {
        return userService.getUserByName(value);
    }
    
}