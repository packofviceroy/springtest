
package com.example.springtest.model;

import java.util.Collection;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{
    
    private String password;
    private String name;
    private int id;
    private String roles;
    

    public MyUserDetails(String password, String name, int id, String roles){
        this.password = password;
        this.name = name;
        this.id = id;
        this.roles = roles;
    }
    
    public static MyUserDetails build(User user) {
        return new MyUserDetails(user.getPassword(), user.getName(), user.getId(), user.getRoles());
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
        // throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
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
