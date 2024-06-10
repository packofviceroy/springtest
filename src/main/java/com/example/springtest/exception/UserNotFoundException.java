package com.example.springtest.exception;

public class UserNotFoundException extends RuntimeException{
    private final int userId;

    public UserNotFoundException(int userId) {
        this.userId = userId;
    }

    @Override
    public String getMessage() {
        return "Profile with id = " + userId + " not found";
    }
}
