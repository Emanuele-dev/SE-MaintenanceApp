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
 * @author mario
 */
public class User {
    private String name;
    private String surname;
    private String username;
    private String password;
    private boolean state; //attivo o non attivo
    private String role;
    
    public User(String nome, String cognome, String username, String password, boolean state, String role) {
        this.name = nome;
        this.surname = cognome;
        this.username = username;
        this.password = password;
        this.state = state;
        this.role = role;
    }
    
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public boolean getState(){
        return state;
    }
    public String getRole(){
        return role;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setState(boolean state){
        this.state = state;
    }
    public void setRole(String role){
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }
    
    //Access to database methods
    //Acquire list of users
    public static LinkedList<User> getUsers (Connection conn) throws SQLException{
        LinkedList<User> users = new LinkedList<>();
        String query = "SELECT * FROM utente";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            users.add(new User(rst.getString("nome"), rst.getString("cognome"), 
                   rst.getString("username"), rst.getString("pass"),
                   rst.getBoolean("attivo"), rst.getString("ruolo")));
        }
        return users;    
    }
    
    public void addUser(Connection conn, User user) throws SQLException{
        String query_insert_user="";
        PreparedStatement stmtUser;
        query_insert_user = "INSERT INTO utente (nome, cognome, username, pass, attivo, ruolo) VALUES (?, ?, ?, ?, ?, ?);";
        
        stmtUser= conn.prepareStatement(query_insert_user);
        stmtUser.setString(1, user.getName());
        stmtUser.setString(2, user.getSurname());
        stmtUser.setString(3, user.getUsername());
        stmtUser.setString(4, user.getPassword());
        stmtUser.setBoolean(5, user.getState());
        stmtUser.setString(6, user.getRole());
        
        stmtUser.executeUpdate();
        
    }
    public void removeUser(Connection conn, User user) throws SQLException{
        String query_insert_user="";
        PreparedStatement stmtUser;
        query_insert_user = "DELETE FROM utente WHERE nome) = (?);";
        
        stmtUser= conn.prepareStatement(query_insert_user);
        stmtUser.setString(1, user.getName());
        
        stmtUser.executeUpdate();
        
    }
    
    public void updateUser(Connection conn, User user, String oldUsername) throws SQLException{
        String query_insert_user="";
        PreparedStatement stmtUser;
        query_insert_user = "UPDATE utente SET nome = (?),"
                                        + " cognome = (?)," 
                                        + " username = (?),"
                                        + " pass = (?)," 
                                        + " attivo = (?),"
                                        + " ruolo = (?) WHERE username = (?)";
        stmtUser= conn.prepareStatement(query_insert_user);
        stmtUser.setString(1, user.getName());
        stmtUser.setString(2, user.getSurname());
        stmtUser.setString(3, user.getUsername());
        stmtUser.setString(4, user.getPassword());
        stmtUser.setBoolean(5, user.getState());
        stmtUser.setString(6, user.getRole());
        stmtUser.setString(7, oldUsername);
        stmtUser.executeUpdate();
        
    }
    
    
    
}

