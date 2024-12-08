
package com.example.springtest.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetails implements UserDetails{
    User user;

    public MyUserDetails() {
    }

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String getPassword() {
       return user.password();
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getUsername() {
        return user.name();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
