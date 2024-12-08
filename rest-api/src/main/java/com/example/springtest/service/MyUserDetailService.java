
package com.example.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springtest.model.MyUserDetails;
import com.example.springtest.model.User;
import com.example.springtest.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{

    
    UserRepository userRepo;

    @Autowired
    public MyUserDetailService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {    
        User user = userRepo.getUserByName(username).orElseThrow(() -> 
                                new UsernameNotFoundException(String.format("User %s not found", username)));
        
        return new MyUserDetails(user);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
