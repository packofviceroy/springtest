
package com.example.springtest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springtest.exception.UserNotFoundException;
import com.example.springtest.model.MyUserDetails;
import com.example.springtest.model.User;
import com.example.springtest.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    UserRepository userRepo;

    public MyUserDetailService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {    
        Optional<User> user = userRepo.getUserByName(username);
        
        return user.map(MyUserDetails::new).orElseThrow(() -> new UserNotFoundException(username));
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
