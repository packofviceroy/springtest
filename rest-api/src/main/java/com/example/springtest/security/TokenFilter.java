
package com.example.springtest.security;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class TokenFilter extends OncePerRequestFilter{

    public JWTAuthenticator jwtAith;

}
