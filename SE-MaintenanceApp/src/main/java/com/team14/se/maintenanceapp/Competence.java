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
    
    //Access to database methods
    //Acquire list of compentencies
    public static LinkedList<Competence> getCompetences (Connection conn) throws SQLException{
        LinkedList<Competence> competences = new LinkedList<>();
        String query = "SELECT * FROM competenza";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            competences.add(new Competence(rst.getInt("id"), rst.getString("nome")));
        }
        return competences;    
    }
    
}
