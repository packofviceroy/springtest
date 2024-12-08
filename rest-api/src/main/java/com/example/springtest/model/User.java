package com.example.springtest.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User{
    
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String roles;

    public String getName(){return this.name;}
    public String getPassword(){return this.password;}
    public int getId(){return this.id;}
    public String getRoles(){return this.roles;}
    public String getAuthorities(){return this.roles;}
}