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
    
    /**
     * Constructor Procedure: create a procedure with a name, a competence and a smpName
     * @param name
     * @param smpName
     * @param competence 
     */
    public Procedure(String name, String smpName, Competence competence){
        this.name = name;
        this.smpName = smpName;
        this.competence = competence;
    }
    /**
     * Constructor Procedure: create a procedure with an id, a name, a competence and a smpName
     * @param id
     * @param name
     * @param smpName
     * @param competence 
     */
    public Procedure(int id, String name, String smpName, Competence competence){
        this.id = id;
        this.name = name;
        this.smpName = smpName;
        this.competence = competence;
    }
    /**
     * 
     * @return procedure id 
     */
    public int getId(){
        return id;
    }
    /**
     * 
     * @return procedute name
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @return procedure smpName
     */
    public String getSmpName(){
        return smpName;
    }
    /**
     * 
     * @return competence of the procedure
     */
    public Competence getCompetence(){
        return competence;
    }
    /**
     * 
     * @param id new procedure id 
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * 
     * @param name new procedure name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * 
     * @param smpName new procedure smpName
     */
    public void setSmpName(String smpName){
        this.smpName = smpName;
    }
    /**
     * 
     * @param competence new competence of this procedure
     */
    public void setCompetence(Competence competence){
        this.competence = competence;
    }

    /**
     * Print procedure
     * @return string containing data for a single procedure
     */
    @Override
    public String toString() {
        return "Procedure{" + "id=" + id + ", name=" + name + ", smpName=" + smpName + ", competence=" + competence + '}';
    }
    
    /**
     * Get all the procedures in the database
     * @param conn connection with the database opened
     * @return list of procedures present
     * @throws SQLException 
     */
    public static LinkedList<Procedure> getProcedures (Connection conn) throws SQLException{
        int competenceId = 0;
        LinkedList<Procedure> procedures = new LinkedList<>();
        String query = "SELECT * FROM procedura";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            String competenceName = rst.getString("competenza");            
            String query2 = "SELECT id FROM competenza WHERE nome = '" + competenceName + "'";
            PreparedStatement stm2 = conn.prepareStatement(query2);
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
    
    /**
     * Add a procedure in the database 
     * @param conn connection with the database opened
     * @param procedure new procedure to add
     * @throws SQLException 
     */
    public static void addProcedure(Connection conn, Procedure procedure) throws SQLException{
        String query_insert_procedure="";
        PreparedStatement stmtProcedure;
        query_insert_procedure = "INSERT INTO procedura (nome, smp, competenza) VALUES (?, ?, ?);";
        
        stmtProcedure = conn.prepareStatement(query_insert_procedure);
        stmtProcedure.setString(1, procedure.getName());
        stmtProcedure.setString(2, procedure.getSmpName());
        stmtProcedure.setString(3, procedure.getCompetence().getName());
        stmtProcedure.executeUpdate();
    }
    
    /**
     * Remove a competence from the database
     * @param conn connection with the database opened
     * @param procedure procedure to remove
     * @throws SQLException 
     */
    public static void removeProcedure(Connection conn, Procedure procedure) throws SQLException{
        String query_insert_procedure="";
        PreparedStatement stmtProcedure;
        query_insert_procedure = "DELETE FROM procedura WHERE (id) = (?)";
        
        stmtProcedure = conn.prepareStatement(query_insert_procedure);
        stmtProcedure.setInt(1, procedure.getId());
        stmtProcedure.executeUpdate();
    }
    /**
     * Update a procedure in the database
     * @param conn connection with the database opened
     * @param procedure new procedure information
     * @param oldId old procedure to update
     * @throws SQLException 
     */
    public static void updateProcedure(Connection conn, Procedure procedure, int oldId) throws SQLException{
        String query_insert_procedure="";
        PreparedStatement stmtProcedure;
        query_insert_procedure = "UPDATE procedura SET nome = (?), smp = (?), competenza = (?) WHERE id = (?)";
        
        stmtProcedure = conn.prepareStatement(query_insert_procedure);
        stmtProcedure.setString(1, procedure.getName());
        stmtProcedure.setString(2, procedure.getSmpName());
        stmtProcedure.setString(3, procedure.getCompetence().getName());
        stmtProcedure.setInt(4, oldId);
        stmtProcedure.executeUpdate();
    }
    
}

