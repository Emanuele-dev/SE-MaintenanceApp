/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;
import java.util.*;
import java.sql.*;

/**
 *
 * @author domal
 */
public class Typology {
    private String name;
    
    public Typology(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Typology{" + "name=" + name + '}';
    }
    
    
    //Access to database methods
    //Acquire list of typologies
    public static LinkedList<Typology> getTypologies (Connection conn) throws SQLException{
        LinkedList<Typology> typologies = new LinkedList<>();
        String query = "SELECT * FROM tipologia";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            typologies.add(new Typology(rst.getString("nome")));
        }
        return typologies;    
    }
}
