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
    
    public void addTypology(Connection conn, Typology typology) throws SQLException{
        String query_insert_typology="";
        PreparedStatement stmtTypology;
        query_insert_typology = "INSERT INTO tipologia (nome) VALUES (?);";
        
        stmtTypology = conn.prepareStatement(query_insert_typology);
        stmtTypology.setString(1, typology.getName());
        stmtTypology.executeUpdate();
    }
    public void removeTypology(Connection conn, Typology typology) throws SQLException{
        String query_insert_typology="";
        PreparedStatement stmtMaterial;
        query_insert_typology = "DELETE FROM tipologia WHERE (nome) = (?);";
        
        stmtMaterial = conn.prepareStatement(query_insert_typology);
        stmtMaterial.setString(1, typology.getName());
        
        stmtMaterial.executeUpdate();
    }
    
}
