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
public class Competence {
    private int id; 
    private String name;
    private ArrayList<User> users; //Maintainers
    
    /**
     * Constructor Compentence: create a competence with its name
     * @param name competence name
     */
    public Competence(String name){
        this.name = name;
    }
    /**
     * Constructor Competence: create a competence with an id and a name
     * @param id competence id
     * @param name competence name
     */
    public Competence(int id, String name){
        this.id = id; 
        this.name = name;
    }
    /**
     * Construtor Competence: create a competence with an id, a neme and a list
     * of users 
     * @param id competence id
     * @param name competence name
     * @param users users that could have this competence
     */
    public Competence(int id, String name, ArrayList users){
        this.id = id; 
        this.name = name;
        this.users = users;
    }
    /**
     * 
     * @return competence id
     */
    public int getId(){
        return id;
    }
    /**
     * 
     * @return competence name
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @return list of user who have this competence
     */
    public ArrayList getUsers(){
        return users;
    }
    /**
     * 
     * @param id new id 
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * 
     * @param name new competence name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * 
     * @param users list of user who have this competence 
     */
    public void setUsers(ArrayList users){
        this.users = users;
    }
    
    /**
     * Print competence
     * @return string containing data for a single competence
     */
    @Override
    public String toString (){
        return "Competence{" + "name=" + name + '}';    
    }

    /**
     * Get all the competences in the database
     * @param conn connection with the database opened
     * @return list of competences present
     * @throws SQLException 
     */
    public static LinkedList<Competence> getCompetences(Connection conn) throws SQLException {
        LinkedList<Competence> competences = new LinkedList<>();
        String query = "SELECT * FROM competenza";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            if ((rst.getInt("id") != 1) & (rst.getString("nome") != null)){ //avoid to return null row
                competences.add(new Competence(rst.getInt("id"), rst.getString("nome")));
            }
        }
        return competences;    
    }
    
    /**
     * Add a competence in the database 
     * @param conn connection with the database opened
     * @param competence new competence to add
     * @throws SQLException 
     */
    public void addCompetence(Connection conn, Competence competence) throws SQLException{
        String query_insert_competence="";
        PreparedStatement stmtCompetence;
        query_insert_competence = "INSERT INTO competenza (nome) VALUES (?);";
        
        stmtCompetence = conn.prepareStatement(query_insert_competence);
        stmtCompetence.setString(1, competence.getName());
        stmtCompetence.executeUpdate();
    }
    
    /**
     * Remove a competence from the database
     * @param conn connection with the database opened
     * @param competence competence to remove
     * @throws SQLException 
     */
    public void removeCompetence(Connection conn, Competence competence) throws SQLException{
        String query_insert_competence="";
        PreparedStatement stmtCompetence;
        query_insert_competence = "DELETE FROM competenza WHERE (id) = (?)";
        
        stmtCompetence = conn.prepareStatement(query_insert_competence);
        stmtCompetence.setInt(1, competence.getId());
        stmtCompetence.executeUpdate();
    }
    
    /**
     * Update a competence in the database
     * @param conn connection with the database opened
     * @param competence new competence informations
     * @param oldId old competence to update
     * @throws SQLException 
     */
    public void updateCompetence(Connection conn, Competence competence, int oldId) throws SQLException{
        String query_insert_competence="";
        PreparedStatement stmtCompetence;
        query_insert_competence = "UPDATE competenza SET nome = (?) WHERE id = (?)";
        stmtCompetence= conn.prepareStatement(query_insert_competence);
        stmtCompetence.setString(1, competence.getName());
        stmtCompetence.setInt(2, oldId);
        stmtCompetence.executeUpdate();
        
    }
    
    /**
     * Check if the competence on which is called is equal to the one given as parameter
     * @param obj new competence to check
     * @return name of the competence if they are equal, false if the they are not
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Competence) {
            Competence comp = (Competence)obj;
            return name==comp.name;
        }
        else {
            return false;
        }
    }
    
}
