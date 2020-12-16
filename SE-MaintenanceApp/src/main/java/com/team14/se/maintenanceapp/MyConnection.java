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

    /**
     * Constructor MyConnection: crea a connection with url, username and password
     * @param url url of the database
     * @param username username to access the database
     * @param password password to access the database 
     */
    public MyConnection(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }
    /**
     * Return the connection established 
     * @return connection created
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn == null){
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,username,password);  
        }
        return conn;
    }
    /**
     * Close the connection to the database
     * @param conn connection to the database to close 
     * @throws SQLException 
     */
    public void closeConnection(Connection conn) throws SQLException{
        conn.close();
    }
    
        
}
