/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;
import java.sql.Timestamp; //format hour, minutes, seconds
import java.util.*;
import java.sql.*;

/**
 *
 * @author domal
 */
public class Log {
    private int id;
    private String username;
    private Timestamp timestamp; 
    
    /**
     * Constructor Log: create a log with the username of the user and a timestamp
     * @param username username of the user that log in 
     * @param timestamp date and time in which the user logged in
     */
    public Log(String username, Timestamp timestamp){
        this.username = username;
        this.timestamp = timestamp;  
    }
    /**
     * Constructor Log: create a log with the username of the user and a timestamp
     * @param id log id 
     * @param username username of the user that log in 
     * @param timestamp date and time in which the user logged in
     */
    public Log(int id, String username, Timestamp timestamp){
        this.id = id;
        this.username = username;
        this.timestamp = timestamp;  
    }
    /**
     * 
     * @return log id
     */
    public int getId(){
        return id;
    }
    /**
     * 
     * @return username of the user logged in
     */
    public String getUsername(){
        return username;
    }
    /**
     * 
     * @return date and time of the user log in
     */
    public Timestamp getTimestamp(){
        return timestamp;
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
     * @param username new username for the user
     */
    public void setUsername(String username){
        this.username = username;
    }
    /**
     * 
     * @param timestamp new date and time of the user log in
     */
    public void setTimestamp(Timestamp timestamp){
        this.timestamp = timestamp; 
    }
    
    /**
     * Print log
     * @return string containing data for a single log
     */
    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", username=" + username + ", timestamp=" + timestamp + '}';
    }

    /**
     * Get all the logs in the database
     * @param conn connection with the database opened
     * @return list of logs present
     * @throws SQLException 
     */
    public static LinkedList<Log> getLogs (Connection conn) throws SQLException{
        LinkedList<Log> logs = new LinkedList<>();
        String query = "SELECT * FROM logging";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            if ((rst.getInt("id") != 1) & (rst.getString("username") != null) & (rst.getTimestamp("log_time") != null)){ //aavoid to return null row
                logs.add(new Log(rst.getInt("id"), rst.getString("username"), rst.getTimestamp("log_time")));
            }
            
        }
        return logs;    
    }
    
    /**
     * Add a log in the database
     * @param conn connection with the database opened
     * @param log new log to add
     * @throws SQLException 
     */
    public static void addLog(Connection conn, Log log) throws SQLException{
        PreparedStatement stmtLog;
        String query_insert_log = "INSERT INTO logging (username, log_time) VALUES (?, ?);";
        
        stmtLog = conn.prepareStatement(query_insert_log);
        stmtLog.setString(1, log.getUsername());
        stmtLog.setTimestamp(2, log.getTimestamp());
        stmtLog.executeUpdate();
    }
    
    /**
     * Remove a log from the database
     * @param conn connection with the database opened
     * @param log log to remove 
     * @throws SQLException 
     */
    public static void removeLog(Connection conn, Log log) throws SQLException{
        PreparedStatement stmtLog;
        String query_insert_log = "DELETE FROM logging WHERE (id) = (?)";
        
        stmtLog = conn.prepareStatement(query_insert_log);
        stmtLog.setInt(1, log.getId());
        stmtLog.executeUpdate();
    }

    /**
     * Update a log in the database 
     * @param conn connection with the database opened
     * @param log new log information
     * @param oldId old log to update
     * @throws SQLException 
     */
    public static void updateLog(Connection conn, Log log, int oldId) throws SQLException{
        PreparedStatement stmtLog;
        String query_insert_log = "UPDATE logging SET username = (?), log_time = (?) WHERE id = (?)";
        stmtLog= conn.prepareStatement(query_insert_log);
        stmtLog.setString(1, log.getUsername());
        stmtLog.setTimestamp(2, log.getTimestamp());
        stmtLog.setInt(3, oldId);
        stmtLog.executeUpdate();
        
    }
    
}
