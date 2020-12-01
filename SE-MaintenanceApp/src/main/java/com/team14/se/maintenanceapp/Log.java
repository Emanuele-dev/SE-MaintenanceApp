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
    
    public Log(String username, Timestamp timestamp){
        this.username = username;
        this.timestamp = timestamp;  
    }
  
    public Log(int id, String username, Timestamp timestamp){
        this.id = id;
        this.username = username;
        this.timestamp = timestamp;  
    }
    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public Timestamp getTimestamp(){
        return timestamp;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setUsername(String name){
        this.username = username;
    }
    public void setTimestamp(Timestamp timestamp){
        this.timestamp = timestamp; 
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", username=" + username + ", timestamp=" + timestamp + '}';
    }

    //Access to database methods
    //Acquire list of compentencies
    public static LinkedList<Log> getLogs (Connection conn) throws SQLException{
        LinkedList<Log> logs = new LinkedList<>();
        String query = "SELECT * FROM logging";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            logs.add(new Log(rst.getInt("id"), rst.getString("username"), rst.getTimestamp("log_time")));
        }
        return logs;    
    }
    
    public void addLog(Connection conn, Log log) throws SQLException{
        String query_insert_log="";
        PreparedStatement stmtLog;
        query_insert_log = "INSERT INTO logging (username, log_time) VALUES (?, ?);";
        
        stmtLog = conn.prepareStatement(query_insert_log);
        stmtLog.setString(1, log.getUsername());
        stmtLog.setTimestamp(2, log.getTimestamp());
        stmtLog.executeUpdate();
    }
    
    public void removeLog(Connection conn, Log log) throws SQLException{
        String query_insert_log="";
        PreparedStatement stmtLog;
        query_insert_log = "DELETE FROM logging WHERE (id) = (?)";
        
        stmtLog = conn.prepareStatement(query_insert_log);
        stmtLog.setInt(1, log.getId());
        stmtLog.executeUpdate();
    }

    public void updateLog(Connection conn, Log log, int oldId) throws SQLException{
        String query_insert_log="";
        PreparedStatement stmtLog;
        query_insert_log = "UPDATE logging SET username = (?), log_time = (?) WHERE id = (?)";
        stmtLog= conn.prepareStatement(query_insert_log);
        stmtLog.setString(1, log.getUsername());
        stmtLog.setTimestamp(2, log.getTimestamp());
        stmtLog.setInt(3, oldId);
        stmtLog.executeUpdate();
        
    }
    
}
