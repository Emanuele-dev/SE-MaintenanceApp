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
    
}
