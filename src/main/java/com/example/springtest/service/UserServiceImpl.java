package com.example.springtest.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.springtest.exception.UserNotFoundException;
import com.example.springtest.model.User;
import com.example.springtest.repository.UserRepository;

@Primary
@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @Override
    // public User getUserById(int personId) {
    //     return userRepository.getUserById(personId)
    //             .orElseThrow(() -> new UserNotFoundException(personId));
    // }

    @Override
    public User getUserByName(String name) {
        return userRepository.findUserByName(name)
                            .orElseThrow(() -> new UserNotFoundException(name));
    }

    

}
