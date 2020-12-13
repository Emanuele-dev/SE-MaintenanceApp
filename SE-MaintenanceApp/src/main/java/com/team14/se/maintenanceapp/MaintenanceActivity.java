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
    private String note;
    private LinkedList<Material> materials;
    private ArrayList<User> users; //Maintainers
    
    /**
     * Constructor Maintenance activity: create a maintenance activity 
     * @param name name of the activity
     * @param description description of the activity
     * @param interruptible flag that indicates if the activity can be interrupted
     * @param estimatedIntervention estimated duration of the intervention in minute
     * @param ewo flag that indicates if the activity is an Emergency Work Order
     * @param week week in which the activity must be performed
     * @param procedure procedure that the activity must follow
     * @param site area in which the activity must take place
     * @param typology typology of the activity to perform
     * @param note note related to the activity
     */
    public MaintenanceActivity(String name, String description, 
            boolean interruptible, int estimatedIntervention, boolean ewo, int week, 
            Procedure procedure, Site site, Typology typology, String note){
        
        this.name = name;
        this.description = description;
        this.interruptible = interruptible;
        this.estimatedIntervention = estimatedIntervention;
        this.ewo = ewo;
        this.week = week;
        this.procedure = procedure;
        this.site = site;
        this.typology = typology;
        this.note = note;
    }
    
    /**
     * Constructor Maintenance activity: create a maintenance activity 
     * @param activityId id of the activity
     * @param name name of the activity
     * @param description description of the activity
     * @param interruptible flag that indicates if the activity can be interrupted
     * @param estimatedIntervention estimated duration of the intervention in minute
     * @param ewo flag that indicates if the activity is an Emergency Work Order
     * @param week week in which the activity must be performed
     * @param procedure procedure that the activity must follow
     * @param site area in which the activity must take place
     * @param typology typology of the activity to perform
     * @param note note to add to the activity
     */
    public MaintenanceActivity(int activityId, String name, String description, 
            boolean interruptible, int estimatedIntervention, boolean ewo, int week, 
            Procedure procedure, Site site, Typology typology, String note){
        this.activityId = activityId;
        this.name = name;
        this.description = description;
        this.interruptible = interruptible;
        this.estimatedIntervention = estimatedIntervention;
        this.ewo = ewo;
        this.week = week;
        this.procedure = procedure;
        this.site = site;
        this.typology = typology;
        this.note = note;
    }
    
    /**
     * Constructor Maintenance activity: create a maintenance activity 
     * @param activityId id of the activity
     * @param name name of the activity
     * @param description description of the activity
     * @param interruptible flag that indicates if the activity can be interrupted
     * @param estimatedIntervention estimated duration of the intervention in minute
     * @param ewo flag that indicates if the activity is an Emergency Work Order
     * @param week week in which the activity must be performed
     * @param state flag to indicate if the activity is completed or not
     * @param procedure procedure that the activity must follow
     * @param site area in which the activity must take place
     * @param typology typology of the activity to perform
     * @param materials list of material to use during the activity
     * @param note note to add to the activity
     * @param users users assigned to this activity
     */
    public MaintenanceActivity(int activityId, String name, String description, 
            boolean interruptible, int estimatedIntervention, boolean ewo, int week, boolean state, 
            Procedure procedure, Site site, Typology typology, 
            LinkedList<Material> materials, String note, ArrayList<User> users){
        
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
        this.materials = materials;
        this.note = note;
        this.users = users;  
    }
    
    /**
     * 
     * @return activity id
     */
    public int getActivityId(){
        return activityId;
    }
    /**
     * 
     * @return activity name
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @return activity description
     */
    public String getDescription(){
        return description;
    }
    /**
     * 
     * @return activity interruptable flag
     */ 
    public boolean getInterruptable(){
        return interruptible;
    }
    /**
     * 
     * @return activity estimated intervention time
     */
    public int getEstimatedIntervention(){
        return estimatedIntervention;
    }
    /**
     * 
     * @return activity ewo flag
     */
    public boolean getEwo(){
        return ewo;
    }
    /**
     * 
     * @return activity week
     */
    public int getWeek(){
        return week;
    }
    /**
     * 
     * @return activity state
     */
    public boolean getState(){
        return state;
    }
    /**
     * 
     * @return activity procedure
     */
    public Procedure getProcedure(){
        return procedure;
    }
    /**
     * 
     * @return activity site
     */
    public Site getSite(){
        return site;
    }
    /**
     * 
     * @return typology of the activity
     */
    public Typology getTypology(){
        return typology;
    }
    /**
     * 
     * @return list of materials to use during the activity
     */
    public LinkedList<Material> getMaterials(){
        return materials;
    }
    /**
     * 
     * @return note realated to the activity
     */
    public String getNote(){
        return note;
    }
    /**
     * 
     * @return users assigned to the activity
     */
    public ArrayList getUsers(){
        return users;
    }
    
    /**
     * 
     * @param activityId new activity id
     */
    public void setActivityId(int activityId){
        this.activityId = activityId;
    }
    /**
     * 
     * @param name new name
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
     * 
     * @param interruptible new interruptible flag
     */
    public void setInterruptable(boolean interruptible){
        this.interruptible = interruptible;
    }
    /**
     * 
     * @param estimatedIntervention new estimated intervention time
     */
    public void setEstimatedIntervention(int estimatedIntervention){
        this.estimatedIntervention = estimatedIntervention;
    }
    /**
     * 
     * @param ewo new ewo flag
     */
    public void setEwo(boolean ewo){
        this.ewo = ewo;
    }
    /**
     * 
     * @param week new activity week
     */
    public void setWeek(int week){
        this.week = week;
    }
    /**
     * 
     * @param state new activity state
     */
    public void setState(boolean state){
        this.state = state;
    }
    /**
     * 
     * @param procedure new activity procedure
     */
    public void setProcedure(Procedure procedure){
        this.procedure = procedure;
    }
    /**
     * 
     * @param site new activity state
     */
    public void setSite(Site site){
        this.site = site;
    }
    /**
     * 
     * @param typology new activity typology
     */
    public void setTypology(Typology typology){
        this.typology = typology;
    }
    /**
     * 
     * @param materials list of new materials to use during the activity
     */
    public void setMaterials(LinkedList<Material> materials){
        this.materials = materials;
    }
    /**
     * 
     * @param note note to add to the activity
     */
    public void setNote(String note){
        this.note = note;
    }
    /**
     * 
     * @param users new users assigned to the activity
     */
    public void setUsers(ArrayList users){
        this.users = users;
    }

    /**
     * Print maintenance activity
     * @return string containing data for a single maintenance activity
     */
    @Override
    public String toString() {
        return "MaintenanceActivity{" + "activityId=" + activityId + ", name=" + name + ", description=" + description + ", interruptible=" + interruptible + ", estimatedIntervention=" + estimatedIntervention + ", ewo=" + ewo + ", week=" + week + ", state=" + state + ", procedure=" + procedure + ", site=" + site + ", typology=" + typology + ", material=" + materials + ", users=" + users + '}';
    }

    
    /**
     * Access to the database to execute queries
     * @param conn connection to the database opened
     * @param query query to perform on maintenance activities
     * @return list of maintenance activities 
     * @throws SQLException 
     */
    public static LinkedList<MaintenanceActivity> resultQueryGetActivities(Connection conn, String query) throws SQLException{
        int procedureId = 0;
        String procedureSmp = null;
        LinkedList<Competence> competences = new LinkedList<>();
        LinkedList<MaintenanceActivity> maintenaceActivities = new LinkedList<>();
        
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            
            String procedureName = rst.getString("procedura");
            if(!procedureName.equals("")){
                String query2 = "SELECT * FROM procedura WHERE nome = '" + procedureName + "'";
                PreparedStatement stm2 = conn.prepareStatement(query2);
                ResultSet rst2 = stm2.executeQuery();
                while (rst2.next()) {
                    if(rst2.getInt("id") != 0){
                        procedureId = rst2.getInt("id");
                        procedureSmp = rst2.getString("smp"); 
                        String query3 = "SELECT competenza FROM assegnazione WHERE id_procedura = '" + procedureId + "'";
                        PreparedStatement stm3 = conn.prepareStatement(query3);
                        ResultSet rst3 = stm3.executeQuery();
                        while (rst3.next()) {
                            if(!rst3.getString("competenza").equals("")){
                                competences.add(new Competence(rst3.getString("competenza")));
                            }
                        }
                    }
                }
            }
            maintenaceActivities.add(
                    new MaintenanceActivity(rst.getInt("activity_id"),
                    rst.getString("nome"), 
                    rst.getString("descrizione"), 
                    rst.getBoolean("interrompibile"), 
                    rst.getInt("intervento_stimato"), 
                    rst.getBoolean("ewo"), 
                    rst.getInt("settimana"), 
                    new Procedure(procedureId, procedureName, procedureSmp, competences), 
                    new Site(rst.getString("sito")), 
                    new Typology(rst.getString("tipologia")),
                    rst.getString("Nota")));
        }
        return maintenaceActivities;
    }
    
    /**
     * Get all the Maintenance Activities from the database
     * @param conn connection to the database opened
     * @return list of maintenance activities
     * @throws SQLException 
     */
    public static LinkedList<MaintenanceActivity> getMaintenanceActivities (Connection conn) throws SQLException{
        String query = "SELECT * FROM attivita_manutenzione";
        return resultQueryGetActivities(conn, query);
    }
    
    
    /**
     * Get all the Maintenance Activities in a particular week from the database
     * @param conn connection to the database opened
     * @param week_number week in which the activities are performed
     * @return list of maintenance activities
     * @throws SQLException 
     */
    public static LinkedList<MaintenanceActivity> getMaintenanceActivitiesByWeek (Connection conn, int week_number) throws SQLException{
        String query = "SELECT * FROM attivita_manutenzione WHERE settimana = " + week_number;
        return resultQueryGetActivities(conn, query);
    }
    
    /**
     * Get all the material associated to the activity
     * @param conn connection to the database opened
     * @param activityId activity whose material you want to know
     * @return list of all materials used for the specific activity
     * @throws SQLException 
     */
    public static LinkedList<Material> getMaterialsForActivity(Connection conn, int activityId)throws SQLException{
        LinkedList<Material> materials = new LinkedList<>();
        String query = "SELECT materiale FROM utilizzo WHERE activity_id = " + activityId;
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            if(!rst.getString("materiale").equals("")){ 
                materials.add(new Material(rst.getString("materiale")));
            }
        }
        return materials;
    }
    
    /**
     * Add a maintenance activity in the database 
     * @param conn connection to the database opened
     * @param maintActivity maintenance activity to add
     * @throws SQLException 
     */
    public static void addMaintenanceActivity(Connection conn, MaintenanceActivity maintActivity) throws SQLException{
        PreparedStatement stmtMainActivity;
        String query_insert_maintActivity = "INSERT INTO attivita_manutenzione "
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
    
    /**
     * Remove a competence from the database
     * @param conn connection to the database opened
     * @param maintActivity maintenance activity to remove
     * @throws SQLException 
     */
    public static void removeMaintenanceActivity(Connection conn, MaintenanceActivity maintActivity) throws SQLException{
        PreparedStatement stmtMainActivity;
        String query_insert_maintActivity = "DELETE FROM attivita_manutenzione WHERE (activity_id) = (?)";
        
        stmtMainActivity = conn.prepareStatement(query_insert_maintActivity);
        stmtMainActivity.setInt(1, maintActivity.getActivityId());
        stmtMainActivity.executeUpdate();
    }
    
    
    /**
     * Update a competence in the database
     * @param conn connection to the database opened
     * @param maintActivity new activity information
     * @param oldActivityId old activity to update
     * @throws SQLException 
     */
    public static void updateMaintenanceActivity(Connection conn, MaintenanceActivity maintActivity, int oldActivityId) throws SQLException{
        PreparedStatement stmtMainActivity;
        String query_insert_maintActivity = "UPDATE attivita_manutenzione SET nome = (?), "
                + "descrizione = (?), interrompibile = (?), "
                + "intervento_stimato = (?), ewo = (?),"
                + "settimana = (?), procedura = (?), "
                + "sito = (?), tipologia = (?),"
                + "completa = (?), "
                + "nota = (?) WHERE id = (?)";
        
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
        stmtMainActivity.setString(11, maintActivity.getNote());
        stmtMainActivity.setInt(12, oldActivityId);
        stmtMainActivity.executeUpdate();
        
    }
    
    
}

