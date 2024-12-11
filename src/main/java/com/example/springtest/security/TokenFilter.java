
package com.example.springtest.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springtest.service.MyUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenFilter extends OncePerRequestFilter{

    private JWTAuthenticator jwtAuthenticator;
    private MyUserDetailService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwt = null;
        String username = null;
        UserDetails userDetails = null;
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;

        try {
            String headerAuth = request.getHeader("Authorisation");
            if ( headerAuth != null && headerAuth.startsWith("Bearer "))
            {
                jwt = headerAuth.substring(7);
            }
            if (jwt != null){
                try {
                    username = jwtAuthenticator.getNameFromToken(jwt);
                }catch(Exception e){

                }
            }else {
            }
        }catch(Exception e){

        }
        filterChain.doFilter(request, response);
    }

}
