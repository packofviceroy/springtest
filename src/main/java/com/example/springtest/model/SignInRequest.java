package com.example.springtest.model;

public class SignInRequest {
    private String username;
    private String password;

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void SetUsername(String username){
        this.username = username;
    }

    public void SetPassword(String password){
        this.password = password;
    }
}
