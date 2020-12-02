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
public class Note {
    private int id;
    private String text;
    
    /**
     * Constructor Note: create a note with an id and a text
     * @param id
     * @param text 
     */
    public Note(int id, String text) {
        this.id = id;
        this.text = text;
    }
    /**
     * Constructor Note: create a note with a text
     * @param text 
     */
    public Note(String text) {
        this.text = text;
    }
    /**
     * 
     * @return note id
     */
    public int getId(){
        return id;
    }
    /**
     * 
     * @return note text
     */
    public String getText(){
        return text;
    }
    /**
     * 
     * @param id new note id
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * 
     * @param text new note text
     */
    public void setText(String text){
        this.text = text;
    }

    /**
     * print note
     * @return string containing data for a single note
     */
    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", text=" + text + '}';
    }
    
    
    /**
     * Get all the notes in the database 
     * @param conn connection with the database opened
     * @return list of notes present
     * @throws SQLException 
     */
    //Access to database methods
    //Acquire list of notes
    public static LinkedList<Note> getNotes (Connection conn) throws SQLException{
        LinkedList<Note> notes = new LinkedList<>();
        String query = "SELECT * FROM nota";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            notes.add(new Note(rst.getInt("id"), rst.getString("testo")));
        }
        return notes;    
    }
    
    /**
     * Add a note in the database 
     * @param conn connection with the database opened
     * @param note new note to add
     * @throws SQLException 
     */
    public void addNote(Connection conn, Note note) throws SQLException{
        String query_insert_note="";
        PreparedStatement stmtNote;
        query_insert_note = "INSERT INTO nota (testo) VALUES (?);";
        
        stmtNote = conn.prepareStatement(query_insert_note);
        stmtNote.setString(1, note.getText());
        
        stmtNote.executeUpdate();
    }
    
    /**
     * Remove a note from the database
     * @param conn connection with the database opened
     * @param note note to remove 
     * @throws SQLException 
     */
    public void removeNote(Connection conn, Note note) throws SQLException{
        String query_insert_note="";
        PreparedStatement stmtNote;
        query_insert_note = "DELETE FROM nota WHERE (id) = (?);";
        
        stmtNote = conn.prepareStatement(query_insert_note);
        stmtNote.setInt(1, note.getId());
        
        stmtNote.executeUpdate();
    }
    
    /**
     * Update a note in the database
     * @param conn connection with the database opened
     * @param note new note informations
     * @param oldId old note to update
     * @throws SQLException 
     */
    public void updateNote(Connection conn, Note note, int oldId) throws SQLException{
        String query_insert_note="";
        PreparedStatement stmtNote;
        query_insert_note = "UPDATE nota SET testo = (?) WHERE id = (?)";
        stmtNote= conn.prepareStatement(query_insert_note);
        stmtNote.setString(1, note.getText());
        stmtNote.setInt(2, oldId);
        stmtNote.executeUpdate();
        
    }
}
