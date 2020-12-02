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
public class MaintenanceActivity {
    private int activityId;
    private String name;
    private String description;
    private boolean interruptible;
    private int estimatedIntervention;
    private boolean ewo;
    private int week;
    private boolean state; // completa o no
    private Procedure procedure;
    private Site site;
    private Typology typology;
    private Material material;
    private ArrayList<User> users; //Maintainers
    
    public MaintenanceActivity(String name, String description, 
            boolean interruptible, int estimatedIntervention, boolean ewo, int week, 
            Procedure procedure, Site site, Typology typology){
        
        this.name = name;
        this.description = description;
        this.interruptible = interruptible;
        this.estimatedIntervention = estimatedIntervention;
        this.ewo = ewo;
        this.week = week;
        this.procedure = procedure;
        this.site = site;
        this.typology = typology;
    }
    
    public MaintenanceActivity(int activityId, String name, String description, 
            boolean interruptible, int estimatedIntervention, boolean ewo, int week, boolean state, 
            Procedure procedure, Site site, Typology typology, 
            Material material, ArrayList<User> users){
        
        this.activityId = activityId;
        this.name = name;
        this.description = description;
        this.interruptible = interruptible;
        this.estimatedIntervention = estimatedIntervention;
        this.ewo = ewo;
        this.week = week;
        this.state = state;
        this.procedure = procedure;
        this.site = site;
        this.typology = typology;
        this.material = material;
        this.users = users;  
    }
    public int getActivityId(){
        return activityId;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public boolean getInterruptable(){
        return interruptible;
    }
    public int getEstimatedIntervention(){
        return estimatedIntervention;
    }
    public boolean getEwo(){
        return ewo;
    }
    public int getWeek(){
        return week;
    }
    public boolean getState(){
        return state;
    }
    public Procedure getProcedure(){
        return procedure;
    }
    public Site getSite(){
        return site;
    }
    public Typology getTypology(){
        return typology;
    }
    public Material getMaterial(){
        return material;
    }
    public ArrayList getUsers(){
        return users;
    }
    
    
    public void setActivityId(int activityId){
        this.activityId = activityId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
         this.description = description;
    }
    public void setInterruptable(boolean interruptible){
        this.interruptible = interruptible;
    }
    public void setEstimatedIntervention(int estimatedIntervention){
        this.estimatedIntervention = estimatedIntervention;
    }
    public void setEwo(boolean ewo){
        this.ewo = ewo;
    }
    public void setWeek(int week){
        this.week = week;
    }
    public void setState(boolean state){
        this.state = state;
    }
    public void setProcedure(Procedure procedure){
        this.procedure = procedure;
    }
    public void setSite(Site site){
        this.site = site;
    }
    public void setTypology(Typology typology){
        this.typology = typology;
    }
    public void setMaterial(Material material){
        this.material = material;
    }
    public void setUsers(ArrayList users){
        this.users = users;
    }

    @Override
    public String toString() {
        return "MaintenanceActivity{" + "activityId=" + activityId + ", name=" + name + ", description=" + description + ", interruptible=" + interruptible + ", estimatedIntervention=" + estimatedIntervention + ", ewo=" + ewo + ", week=" + week + ", state=" + state + ", procedure=" + procedure + ", site=" + site + ", typology=" + typology + ", material=" + material + ", users=" + users + '}';
    }

    
    //Access to database methods
    public static LinkedList<MaintenanceActivity> resultQueryGetActivities(Connection conn, String query) throws SQLException{
        int competenceId = 0;
        int procedureId = 0;
        String procedureSmp = null;
        String competenceName = null;
        Procedure procedure;
        
        LinkedList<MaintenanceActivity> maintenaceActivities = new LinkedList<>();
        
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            String procedureName = rst.getString("procedura");            
            String query2 = "SELECT * FROM procedura WHERE nome = '" + procedureName + "'";
            PreparedStatement stm2 = conn.prepareStatement(query2);
            ResultSet rst2 = stm2.executeQuery();
            while (rst2.next()) {
                procedureId = rst2.getInt("id");
                procedureSmp = rst2.getString("smp");
                competenceName = rst2.getString("competenza"); 
                String query3 = "SELECT id FROM competenza WHERE nome = '" + competenceName + "'";
                PreparedStatement stm3 = conn.prepareStatement(query3);
                ResultSet rst3 = stm3.executeQuery();
                while (rst3.next()){
                    competenceId = rst3.getInt("id");
                }
            }
            procedure = new Procedure(procedureId, procedureName, procedureSmp, 
                    new Competence(competenceId, competenceName));
            
            maintenaceActivities.add(
                    new MaintenanceActivity(
                    rst.getString("nome"), 
                    rst.getString("descrizione"), 
                    rst.getBoolean("interrompibile"), 
                    rst.getInt("intervento_stimato"), 
                    rst.getBoolean("ewo"), 
                    rst.getInt("settimana"), 
                    procedure, 
                    new Site(rst.getString("sito")), 
                    new Typology(rst.getString("tipologia"))));
            }
        return maintenaceActivities;
    }
    
    //Acquire list of Maintenance Activities
    public static LinkedList<MaintenanceActivity> getMaintenanceActivities (Connection conn) throws SQLException{
        String query = "SELECT * FROM attivita_manutenzione";
        return resultQueryGetActivities(conn, query);
    }
    
    
    //Acquire list of Maintenance Activities in a particular week
    public static LinkedList<MaintenanceActivity> getMaintenanceActivitiesByWeek (Connection conn, int week_number) throws SQLException{
        String query = "SELECT * FROM attivita_manutenzione WHERE settimana = " + week_number;
        return resultQueryGetActivities(conn, query);
    }
    
    public void addMaintenanceActivity(Connection conn, MaintenanceActivity maintActivity) throws SQLException{
        String query_insert_maintActivity="";
        PreparedStatement stmtMainActivity;
        query_insert_maintActivity = "INSERT INTO attivita_manutenzione "
                + "(nome, descrizione, interrompibile, intervento_stimato,"
                + " ewo, settimana,procedura, sito, tipologia) "
                + "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?);";
        
        stmtMainActivity = conn.prepareStatement(query_insert_maintActivity);
        stmtMainActivity.setString(1, maintActivity.getName());
        stmtMainActivity.setString(2, maintActivity.getDescription());
        stmtMainActivity.setBoolean(3, maintActivity.getInterruptable());
        stmtMainActivity.setInt(4, maintActivity.getEstimatedIntervention());
        stmtMainActivity.setBoolean(5, maintActivity.getEwo());
        stmtMainActivity.setInt(6, maintActivity.getWeek());
        stmtMainActivity.setString(7, maintActivity.getProcedure().getName());
        stmtMainActivity.setString(8, maintActivity.getSite().getName());
        stmtMainActivity.setString(9, maintActivity.getTypology().getName());
        stmtMainActivity.executeUpdate();
    }
    public void removeMaintenanceActivity(Connection conn, MaintenanceActivity maintActivity) throws SQLException{
        String query_insert_maintActivity="";
        PreparedStatement stmtMainActivity;
        query_insert_maintActivity = "DELETE FROM attivita_manutenzione WHERE (activity_id) = (?)";
        
        stmtMainActivity = conn.prepareStatement(query_insert_maintActivity);
        stmtMainActivity.setInt(1, maintActivity.getActivityId());
        stmtMainActivity.executeUpdate();
    }
    
    public void updateMaintenanceActivity(Connection conn, MaintenanceActivity maintActivity, int oldActivityId) throws SQLException{
        String query_insert_maintActivity="";
        PreparedStatement stmtMainActivity;
        query_insert_maintActivity = "UPDATE attivita_manutenzione SET nome = (?), "
                + "descrizione = (?), interrompibile = (?), "
                + "intervento_stimato = (?), ewo = (?),"
                + "settimana = (?), procedura = (?), "
                + "sito = (?), tipologia = (?),"
                + "completa = (?) WHERE id = (?)";
        
        stmtMainActivity = conn.prepareStatement(query_insert_maintActivity);
        stmtMainActivity.setString(1, maintActivity.getName());
        stmtMainActivity.setString(2, maintActivity.getDescription());
        stmtMainActivity.setBoolean(3, maintActivity.getInterruptable());
        stmtMainActivity.setInt(4, maintActivity.getEstimatedIntervention());
        stmtMainActivity.setBoolean(5, maintActivity.getEwo());
        stmtMainActivity.setInt(6, maintActivity.getWeek());
        stmtMainActivity.setString(7, maintActivity.getProcedure().getName());
        stmtMainActivity.setString(8, maintActivity.getSite().getName());
        stmtMainActivity.setString(9, maintActivity.getTypology().getName());
        stmtMainActivity.setBoolean(10, maintActivity.getState());
        stmtMainActivity.setInt(11, oldActivityId);
        stmtMainActivity.executeUpdate();
        
    }
    
    
}

