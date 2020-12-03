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
    
    /**
     * Constructor Typology: create a typology with its name
     * @param name 
     */
    public Typology(String name){
        this.name = name;
    }
    /**
     * 
     * @return typology name
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @param name new typology name 
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Print typology
     * @return string containing data for a single typology
     */
    @Override
    public String toString() {
        return "Typology{" + "name=" + name + '}';
    }
    
    /**
     * Get all the typologies in the database
     * @param conn connection with the database opened
     * @return list of typologies present
     * @throws SQLException 
     */
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
    
    /**
     * Add a typology in the database
     * @param conn connection with the database opened
     * @param typology new typology to add
     * @throws SQLException 
     */
    public static void addTypology(Connection conn, Typology typology) throws SQLException{
        String query_insert_typology="";
        PreparedStatement stmtTypology;
        query_insert_typology = "INSERT INTO tipologia (nome) VALUES (?);";
        
        stmtTypology = conn.prepareStatement(query_insert_typology);
        stmtTypology.setString(1, typology.getName());
        stmtTypology.executeUpdate();
    }
    /**
     * Remove a typology from the database
     * @param conn connection with the database opened
     * @param typology typology to remove 
     * @throws SQLException 
     */
    public static void removeTypology(Connection conn, Typology typology) throws SQLException{
        String query_insert_typology="";
        PreparedStatement stmtTypology;
        query_insert_typology = "DELETE FROM tipologia WHERE (nome) = (?);";
        
        stmtTypology = conn.prepareStatement(query_insert_typology);
        stmtTypology.setString(1, typology.getName());
        
        stmtTypology.executeUpdate();
    }
    /**
     * Update a typology in the database 
     * @param conn connection with the database opened
     * @param typology new typology information
     * @param oldName old typology to update
     * @throws SQLException 
     */
    public static void updateTypology(Connection conn, Typology typology, String oldName) throws SQLException{
        String query_insert_user="";
        PreparedStatement stmtUser;
        query_insert_user = "UPDATE tipologia SET nome = (?) WHERE nome = (?)";
        stmtUser= conn.prepareStatement(query_insert_user);
        stmtUser.setString(1, typology.getName());
        stmtUser.setString(2, oldName);
        stmtUser.executeUpdate();
        
    }
}
