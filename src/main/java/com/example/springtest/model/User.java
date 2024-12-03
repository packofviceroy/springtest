package com.example.springtest.model;


public record User(
    int id,
    String name,
    String password,
    String roles
) {

}

