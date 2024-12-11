package com.example.springtest.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springtest.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findUserById(int personId);
    Optional<User> findUserByName(String name);
}
