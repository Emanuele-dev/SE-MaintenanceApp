/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;
import java.util.*;

/**
 *
 * @author domal
 */
public class Competence {
    private int id; 
    private String name;
    private ArrayList<User> users; //Maintainers
    
    public Competence(int id, String name){
        this.id = id; 
        this.name = name;
    }
    public Competence(int id, String name, ArrayList users){
        this.id = id; 
        this.name = name;
        this.users = users;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public ArrayList getUsers(){
        return users;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAuthors(ArrayList users){
        this.users = users;
    }

    @Override
    public String toString() {
        return "Competence{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
