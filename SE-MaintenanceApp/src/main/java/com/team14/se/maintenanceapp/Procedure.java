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
public class Procedure {
    private int id;
    private String name;
    private String smpName;
    
    
  
    public Procedure(int id, String name, String smpName){
        this.id = id;
        this.name = name;
        this.smpName = smpName;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSmpName(){
        return smpName;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSmpName(String smpName){
        this.smpName = smpName;
    }

    @Override
    public String toString() {
        return "Procedure{" + "id=" + id + ", name=" + name + ", smpName=" + smpName + '}';
    }

}
