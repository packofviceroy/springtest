package com.example.springtest.exception;

public class UserNotFoundException extends RuntimeException{
    // private final int userId;
    private final String userName;

    public UserNotFoundException(String userName) {
        this.userName = userName;
    }

    @Override
    public String getMessage() {
        return "Profile with name = " + this.userName + " not found";
    }
}
