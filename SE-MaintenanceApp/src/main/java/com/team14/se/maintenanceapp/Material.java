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
public class Material {
    private String name;
    private String description;
    
    /**
     * Constructor Log: create a material with a name and a description
     * @param name material name
     * @param description material description
     */
    public Material(String name, String description) {
        this.name = name;
        this.description = description;
    }
    /**
     * 
     * @return material name
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @return description name
     */
    public String getDescription(){
        return description;
    }
    /**
     * 
     * @param name new material name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * 
     * @param description new description
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Print material 
     * @return string containing data for a single material
     */
    @Override
    public String toString() {
        return "Material{" + "name=" + name + ", description=" + description + '}';
    }
    
    /**
     * Get all the materials in the database
     * @param conn connection with the database opened
     * @return list of materials present 
     * @throws SQLException 
     */
    public static LinkedList<Material> getMaterials (Connection conn) throws SQLException{
        LinkedList<Material> materials = new LinkedList<>();
        String query = "SELECT * FROM materiale";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            if ((rst.getString("nome") != null) & (rst.getString("descrizione") != null)){ //aavoid to return null row
                materials.add(new Material(rst.getString("nome"), rst.getString("descrizione")));
            }
        }
        return materials;    
    }
    
    /**
     * Add a material in the database 
     * @param conn connection with the database opened
     * @param material new material information
     * @throws SQLException 
     */
    public static void addMaterial(Connection conn, Material material) throws SQLException{
        PreparedStatement stmtMaterial;
        String query_insert_material = "INSERT INTO materiale (nome, descrizione) VALUES (?, ?);";
        
        stmtMaterial = conn.prepareStatement(query_insert_material);
        stmtMaterial.setString(1, material.getName());
        stmtMaterial.setString(2, material.getDescription());
        stmtMaterial.executeUpdate();
    }
    
    /**
     * Remove a material from the database
     * @param conn connection with the database opened
     * @param material material to remove
     * @throws SQLException 
     */
    public static void removeMaterial(Connection conn, Material material) throws SQLException{
        PreparedStatement stmtMaterial;
        String query_insert_material = "DELETE FROM materiale WHERE (nome) = (?);";
        
        stmtMaterial = conn.prepareStatement(query_insert_material);
        stmtMaterial.setString(1, material.getName());
        
        stmtMaterial.executeUpdate();
    }
    /**
     * Update a material in the database
     * @param conn connection with the database opened
     * @param material new material information
     * @param oldName old material to update 
     * @throws SQLException 
     */
    public static void updateMaterial(Connection conn, Material material, int oldName) throws SQLException{
        PreparedStatement stmtMaterial;
        String query_insert_material = "UPDATE materiale SET nome = (?), descrizione = (?) WHERE nome = (?)";
        stmtMaterial= conn.prepareStatement(query_insert_material);
        stmtMaterial.setString(1, material.getName());
        stmtMaterial.setString(2, material.getDescription());
        stmtMaterial.setInt(3, oldName);
        stmtMaterial.executeUpdate();
        
    }
    
}
