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
    
    /**
     * Constructor User: create an user with name, surname, username, password, state, role
     * @param nome name of the user
     * @param cognome surnama of the user 
     * @param username username of the user
     * @param password password of the user
     * @param state indicate if the user is active or not
     * @param role indicate the role of the user in the system
     */
    public User(String nome, String cognome, String username, String password, boolean state, String role) {
        this.name = nome;
        this.surname = cognome;
        this.username = username;
        this.password = password;
        this.state = state;
        this.role = role;
    }
    /**
     * 
     * @return name of the user
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @return surname of the user
     */
    public String getSurname(){
        return surname;
    }
    /**
     * 
     * @return username of the user
     */
    public String getUsername(){
        return username;
    }
    /**
     * 
     * @return password of the user
     */
    public String getPassword(){
        return password;
    }
    /**
     * 
     * @return state of the user
     */
    public boolean getState(){
        return state;
    }
    /**
     * 
     * @return role of the user
     */
    public String getRole(){
        return role;
    }
    /**
     * 
     * @param name new name of the user
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * 
     * @param surname new surname of the user
     */
    public void setSurname(String surname){
        this.surname = surname;
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
     * @param password new password for the user
     */
    public void setPassword(String password){
        this.password = password;
    }
    /**
     * 
     * @param state new state for the use (active or not)
     */
    public void setState(boolean state){
        this.state = state;
    }
    /**
     * 
     * @param role new role of the user
     */
    public void setRole(String role){
        this.role = role;
    }
    /**
     * Print user
     * @return string containing data for a single user
     */
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }
    
    /**
     * Get all the users in the database
     * @param conn connection with the database opened
     * @return list of users present
     * @throws SQLException 
     */
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
    /**
     * Add a user in the database
     * @param conn connection with the database opened
     * @param user new user to add
     * @throws SQLException 
     */
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
    /**
     * Remove a user from the database
     * @param conn connection with the database opened
     * @param user user to remove 
     * @throws SQLException 
     */
    public void removeUser(Connection conn, User user) throws SQLException{
        String query_insert_user="";
        PreparedStatement stmtUser;
        query_insert_user = "DELETE FROM utente WHERE nome) = (?);";
        
        stmtUser= conn.prepareStatement(query_insert_user);
        stmtUser.setString(1, user.getName());
        
        stmtUser.executeUpdate();
        
    }
    
    /**
     * Update a user in the database 
     * @param conn connection with the database opened
     * @param user new user informations
     * @param oldUsername old username to update
     * @throws SQLException 
     */
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

