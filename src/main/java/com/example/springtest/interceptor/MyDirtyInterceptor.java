package com.example.springtest.interceptor;

import java.time.LocalDate;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyDirtyInterceptor implements HandlerInterceptor{
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("THIS IS PRE HANDLE INTERCEPTOR CALLING");
         System.out.println(LocalDate.now() + "[DIRTY INTERCEPTOR] GOT REQUEST" + request.getMethod() + " " + request.getRequestURI());
                return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
                System.out.println("THIS IS POST HANDLE INTERCEPTOR CALLING");
                System.out.println(LocalDate.now() + "[DIRTY INTERCEPTOR] COMPLETED REQUEST " + request.getMethod() + " " + request.getRequestURI());
            }
}
