package com.example.springtest.service;
import com.example.springtest.model.User;

public interface UserService {
    // User getUserById(int personId);
    User getUserByName(String name);
}
