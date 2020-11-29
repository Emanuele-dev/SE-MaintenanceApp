/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;
/**
 *
 * @author mario
 */
public class User {
    String name;
    String surname;
    String username;
    String password;


    public User(String nome, String cognome, String username, String password) {
        this.name = nome;
        this.surname = cognome;
        this.username = username;
        this.password = password;
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
    public void setName(){
        this.name = name;
    }
    public void setSurname(){
        this.surname = surname;
    }
    public void setUsername(){
        this.username = username;
    }
    public void setPassword(){
        this.password = password;
    }
    
}
