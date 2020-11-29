/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;

/**
 *
 * @author domal
 */
public class Material {
    private String name;
    private String description;
    
    
    public Material(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Material{" + "name=" + name + ", description=" + description + '}';
    }
    
    
}
