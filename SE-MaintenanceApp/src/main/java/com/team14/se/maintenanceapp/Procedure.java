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
    private LinkedList<Competence> competences;
    
    /**
     * Constructor Procedure: create a procedure with a name, a smpName and a list of competences
     * @param name
     * @param smpName
     * @param competences 
     */
    public Procedure(String name, String smpName, LinkedList<Competence> competences){
        this.name = name;
        this.smpName = smpName;
        this.competences = competences;
    }
    /**
     * Constructor Procedure: create a procedure with an id, a name, a smpName and a list of competences
     * @param id
     * @param name
     * @param smpName
     * @param competences
     */
    public Procedure(int id, String name, String smpName, LinkedList<Competence> competences){
        this.id = id;
        this.name = name;
        this.smpName = smpName;
        this.competences = competences;
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
     * @return list of competences of the procedure
     */
    public LinkedList<Competence> getProcedureCompetences(){
        return competences;
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
     * @param competences new list of competences to assign to this procedure
     */
    public void setProcedureCompetences(LinkedList<Competence> competences){
        this.competences = competences;
    }

    /**
     * Print procedure
     * @return string containing data for a single procedure
     */
    @Override
    public String toString() {
        return "Procedure{" + "id=" + id + ", name=" + name + ", smpName=" + smpName + ", competences=" + competences + '}';
    }
    
    /**
     * Get all the procedures in the database
     * @param conn connection with the database opened
     * @return list of procedures present
     * @throws SQLException 
     */
    public static LinkedList<Procedure> getProcedures (Connection conn) throws SQLException{
        LinkedList<Competence> competences = new LinkedList<>();
        LinkedList<Procedure> procedures = new LinkedList<>();
        String query = "SELECT * FROM procedura";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            if(rst.getInt("id") != 0){
                int procedureId = rst.getInt("id");
                String query2 = "SELECT competenza FROM assegnazione WHERE id_procedura = '" + procedureId + "'";
                PreparedStatement stm2 = conn.prepareStatement(query2);
                ResultSet rst2 = stm2.executeQuery();
                while (rst2.next()) {
                    if(!rst2.getString("competenza").equals("")){
                        competences.add(new Competence(rst2.getString("competenza")));
                    }
                }
                procedures.add(new Procedure(rst.getInt("id"),rst.getString("nome"), rst.getString("smp"), competences));
            }
        }
        return procedures;
    }
    
    /**
     * Get all the competences of a specific procedure
     * @param conn connection with the database opened
     * @param procedureId procedure whose competences you want to know
     * @return list of competences assigned to a procedure
     * @throws java.sql.SQLException 
     */
    public static LinkedList<Competence> getProcedureCompetences(Connection conn, int procedureId)throws SQLException{
        LinkedList<Competence> competences = new LinkedList<>();
        String query = "SELECT competenza FROM assegnazione WHERE id_procedura = '" + procedureId + "'";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            if(!rst.getString("competenza").equals("")){ 
                competences.add(new Competence(rst.getString("competenza")));
            }
        }
        return competences;
    }
    
    /**
     * Assign a list of competences to a procedure
     * @param conn connection with the database opened
     * @param procedure user whose skills you want to assign
     * @param competences list of competences to assign to the user
     * @throws java.sql.SQLException
     */
    public static void assignCompetencesToProcedure(Connection conn, Procedure procedure, LinkedList<Competence> competences)throws SQLException{
        PreparedStatement stmAssign;
        String query_insert_assignment = "INSERT INTO assegnazione (id_procedura, competenza) VALUES (?, ?)";
        
        stmAssign = conn.prepareStatement(query_insert_assignment);
        
        for (int i=0; i<competences.size (); i++){
            stmAssign.setInt(1, procedure.getId());
            stmAssign.setString(2, competences.get(i).getName());
            stmAssign.executeUpdate();
        }
    }
    
    /**
     * Add a procedure in the database 
     * @param conn connection with the database opened
     * @param procedure new procedure to add
     * @throws SQLException 
     */
    public static void addProcedure(Connection conn, Procedure procedure) throws SQLException{
        PreparedStatement stmtProcedure;
        String query_insert_procedure = "INSERT INTO procedura (nome, smp) VALUES (?, ?);";
        
        stmtProcedure = conn.prepareStatement(query_insert_procedure);
        stmtProcedure.setString(1, procedure.getName());
        stmtProcedure.setString(2, procedure.getSmpName());
        stmtProcedure.executeUpdate();
        
        // get the new id
        PreparedStatement stmtId;
        String query_get_procedure_id = "SELECT id FROM procedura WHERE nome = ?";
        stmtId = conn.prepareStatement(query_get_procedure_id);
        stmtId.setString(1, procedure.getName());
        ResultSet rst = stmtId.executeQuery();
        rst.next();
        procedure.setId(rst.getInt("id"));
    }
    
    /**
     * Remove a procedure from the database
     * @param conn connection with the database opened
     * @param procedure procedure to remove
     * @throws SQLException 
     */
    public static void removeProcedure(Connection conn, Procedure procedure) throws SQLException{
        PreparedStatement stmtProcedure;
        String query_insert_procedure = "DELETE FROM procedura WHERE (id) = (?)";
        
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
        PreparedStatement stmtProcedure;
        String query_insert_procedure = "UPDATE procedura SET nome = (?), smp = (?) WHERE id = (?)";
        
        stmtProcedure = conn.prepareStatement(query_insert_procedure);
        stmtProcedure.setString(1, procedure.getName());
        stmtProcedure.setString(2, procedure.getSmpName());
        stmtProcedure.setInt(3, oldId);
        stmtProcedure.executeUpdate();
    }
    
}

