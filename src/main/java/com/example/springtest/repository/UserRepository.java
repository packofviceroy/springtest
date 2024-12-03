package com.example.springtest.repository;
import java.util.Optional;

import com.example.springtest.model.User;

public interface UserRepository {
    Optional<User> getUserById(int personId);
    Optional<User> getUserByName(String name);
}
