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
    private LinkedList<Competence> competences;
    
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
     * Constructor User: create an user with name, surname, username, password, state, role, competences
     * @param nome name of the user
     * @param cognome surnama of the user 
     * @param username username of the user
     * @param password password of the user
     * @param state indicate if the user is active or not
     * @param role indicate the role of the user in the system
     * @param competences list of competences of the user
     */
    public User(String nome, String cognome, String username, String password, boolean state, String role, LinkedList<Competence> competences) {
        this.name = nome;
        this.surname = cognome;
        this.username = username;
        this.password = password;
        this.state = state;
        this.role = role;
        this.competences = competences;
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
     * @return list of competences assigned to the user
     */
    public LinkedList<Competence> getCompetences(){
        return competences;
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
     * 
     * @param competences list of competences to asssingn to the user
     */
    public void setCompetences(LinkedList<Competence> competences){
        this.competences = competences;
    }
    
    /**
     * Print user
     * @return string containing data for a single user
     */
    @Override
    public String toString (){
        return "User{" + "name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password + ", state=" + state + ", role=" + role + ", competences=" + competences + '}';    
    }

    /**
     * Get all the active users in the database
     * @param conn connection with the database opened
     * @return list of active users present
     * @throws SQLException 
     */
    public static LinkedList<User> getUsers(Connection conn) throws SQLException {
        LinkedList<User> users = new LinkedList<>();
        String query = "SELECT * FROM utente WHERE attivo = 'true'";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            if (rst.getString("ruolo").equals("Maintainer")){
                LinkedList<Competence> competences = new LinkedList<>();
                String query2 = "SELECT competenza FROM qualificazione WHERE maintainer = ?";
                PreparedStatement stm2 = conn.prepareStatement(query2);
                stm2.setString(1, rst.getString("username"));
                ResultSet rst2 = stm2.executeQuery();
                while (rst2.next()) {
                    if(!rst2.getString("competenza").equals("")){
                        competences.add(new Competence(rst2.getString("competenza")));
                    }
                }
                users.add(new User(rst.getString("nome"), rst.getString("cognome"),
                            rst.getString("username"), rst.getString("pass"),
                            rst.getBoolean("attivo"), rst.getString("ruolo"), 
                            competences));
            } else {
                users.add(new User(rst.getString("nome"), rst.getString("cognome"),
                            rst.getString("username"), rst.getString("pass"),
                            rst.getBoolean("attivo"), rst.getString("ruolo")));
            }
        }
        return users;    
    }
    
    /**
     * Get all the competences of a specific user
     * @param conn connection with the database opened
     * @param username user whose skills you want to know
     * @return list of competences assigned to the user
     * @throws java.sql.SQLException 
     */
    public static LinkedList<Competence> getUserCompetences(Connection conn, String username)throws SQLException{
        LinkedList<Competence> competences = new LinkedList<>();
        String query = "SELECT competenza FROM qualificazione WHERE maintainer = '" + username + "'";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            competences.add(new Competence(rst.getString("competenza")));
        }
        return competences;
    }
    
    /**
     * Assign a list of competences to a user
     * @param conn connection with the database opened
     * @param user user whose skills you want to assign
     * @param competences list of competences to assign to the user
     * @throws java.sql.SQLException
     */
    public static void assignCompetencesToUser(Connection conn, User user, LinkedList<Competence> competences)throws SQLException{
        PreparedStatement stmQual;
        String query_insert_qualification = "INSERT INTO qualificazione (maintainer, competenza) VALUES (?, ?)";
        
        stmQual = conn.prepareStatement(query_insert_qualification);
        
        for (int i=0; i<competences.size (); i++){
            stmQual.setString(1, user.getUsername());
            stmQual.setString(2, competences.get(i).getName());
            stmQual.executeUpdate();
        }
    }
    
    /**
     * Add a user in the database
     * @param conn connection with the database opened
     * @param user new user to add
     * @throws SQLException 
     */
    public static void addUser(Connection conn, User user) throws SQLException{
        PreparedStatement stmtUser;
        String query_insert_user = "INSERT INTO utente (nome, cognome, username, pass, attivo, ruolo) VALUES (?, ?, ?, ?, ?, ?);";
        
        stmtUser = conn.prepareStatement(query_insert_user);
        stmtUser.setString(1, user.getName());
        stmtUser.setString(2, user.getSurname());
        stmtUser.setString(3, user.getUsername());
        stmtUser.setString(4, user.getPassword());
        stmtUser.setBoolean(5, user.getState());
        stmtUser.setString(6, user.getRole());
        
        stmtUser.executeUpdate();
        
    }
    /**
     * Deactivate a user from the system deselecting the state variable, maintaining
     * the link to the user, useful for the log activity.
     * @param conn connection with the database opened
     * @param user user to deactivate
     * @throws SQLException 
     */
    public static void deactivateUser(Connection conn, User user) throws SQLException{
        PreparedStatement stmtUser;
        String query_insert_user = "UPDATE utente SET attivo = 'false' WHERE username = (?);";
        
        stmtUser= conn.prepareStatement(query_insert_user);
        stmtUser.setString(1, user.getUsername());
        
        stmtUser.executeUpdate();
        
    }
    
    /**
     * Update a user in the database 
     * @param conn connection with the database opened
     * @param user new user information
     * @param oldUsername old username to update
     * @throws SQLException 
     */
    public static void updateUser(Connection conn, User user, String oldUsername) throws SQLException{
        PreparedStatement stmtUser;
        String query_insert_user = "UPDATE utente SET nome = (?),"
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

