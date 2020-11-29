/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private final String url;
    private final String username;
    private final String password;
    private Connection conn = null;

    public MyConnection(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn == null){
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,username,password);  
        }
        return conn;
    }
    
    public void closeConnection(Connection conn) throws SQLException{
        conn.close();
    }
        
}
