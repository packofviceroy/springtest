
package com.example.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springtest.model.MyUserDetails;
import com.example.springtest.model.User;


@Service
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    UserServiceImpl usersServiceImpl;

    public MyUserDetailService() {}

    public MyUserDetailService(UserServiceImpl usersServiceImpl) {
        this.usersServiceImpl = usersServiceImpl;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {    
        User user = usersServiceImpl.getUserByName(username);
        return MyUserDetails.build(user);
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
