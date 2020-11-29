/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;

import java.util.*;
/**
 *
 * @author mario
 */
public class User {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String role;
    


    public User(String nome, String cognome, String username, String password, String role) {
        this.name = nome;
        this.surname = cognome;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setRole(String role){
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }
    
    
    
}
