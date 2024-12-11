
package com.example.springtest.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{
    
    private String password;
    private String name;
    private int id;
    private String roles;
    

    MyUserDetails(String password, String name, int id, String roles){

    }
    
    public static MyUserDetails build(User user) {
        return new MyUserDetails(user.getPassword(), user.getName(), user.getId(), user.getRoles());
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    
}
