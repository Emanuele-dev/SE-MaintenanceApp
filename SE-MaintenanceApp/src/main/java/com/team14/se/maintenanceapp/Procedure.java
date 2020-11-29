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
public class Procedure {
    private int id;
    private String name;
    private String smpName;
    private Competence competence;
    
    
  
    public Procedure(int id, String name, String smpName, Competence competence){
        this.id = id;
        this.name = name;
        this.smpName = smpName;
        this.competence = competence;
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
    public Competence getCompetence(){
        return competence;
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

    public void setCompetence(Competence competence){
        this.competence = competence;
    }

    @Override
    public String toString() {
        return "Procedure{" + "id=" + id + ", name=" + name + ", smpName=" + smpName + ", competence=" + competence + '}';
    }
    

    //Access to database methods
    //Acquire list of procedures
    public static LinkedList<Procedure> getProcedures (Connection conn) throws SQLException{
        int competenceId = 0;
        LinkedList<Procedure> procedures = new LinkedList<>();
        String query = "SELECT * FROM procedura";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            String competenceName = rst.getString("competenza");            
            String query2 = "SELECT id FROM competenza WHERE nome = '" + competenceName + "'";
            PreparedStatement stm2 = conn.prepareStatement(query);
            ResultSet rst2 = stm2.executeQuery();
            while (rst2.next()) {
                competenceId = rst2.getInt("id");
            }
            System.out.println("L'id della competenza è " + competenceId);
            procedures.add(new Procedure(rst.getInt("id"),rst.getString("nome"), 
                    rst.getString("smp"), new Competence(competenceId, competenceName)));
            }
        return procedures;    
    }
    
    
}
