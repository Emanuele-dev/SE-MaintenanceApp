/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;
import java.sql.Connection;
import java.sql.*;


/**
 *
 * @author domal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenance", "team14", "team14").getConnection();
            System.out.println(conn);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
