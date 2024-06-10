package com.example.springtest.repository;
import com.example.springtest.model.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserById(int personId);
}
