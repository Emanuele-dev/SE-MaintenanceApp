/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.sql.*;

/**
 *
 * @author domal
 */
public class Log {
    private int id;
    private String username;
    private LocalDateTime date;
    
    /**
     * Constructor Log: create a log with the username of the user and a timestamp
     * @param username username of the user that log in 
     * @param date date and time in which the user logged in
     */
    public Log(String username, LocalDateTime date){
        this.username = username;
        this.date = date;  
    }
    /**
     * Constructor Log: create a log with the username of the user and a timestamp
     * @param id log id 
     * @param username username of the user that log in 
     * @param date date and time in which the user logged in
     */
    public Log(int id, String username, LocalDateTime date){
        this.id = id;
        this.username = username;
        this.date = date;  
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
    public LocalDateTime getDateTime(){
        return date;
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
     * @param date new date and time of the user log in
     */
    public void setDateTime(LocalDateTime date){
        this.date = date; 
    }
    
    /**
     * Print log
     * @return string containing data for a single log
     */
    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", username=" + username + ", date=" + date + '}';
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
                logs.add(new Log(rst.getInt("id"), rst.getString("username"), rst.getTimestamp("log_time").toLocalDateTime()));
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
        stmtLog.setTimestamp(2, Timestamp.valueOf(log.getDateTime()));
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
        stmtLog.setTimestamp(2, Timestamp.valueOf(log.getDateTime()));
        stmtLog.setInt(3, oldId);
        stmtLog.executeUpdate();
        
    }
    
}
