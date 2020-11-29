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
    
    public Note(int id, String text) {
        this.id = id;
        this.text = text;
    }
    
    public Note(String text) {
        this.text = text;
    }
    
    public int getId(){
        return id;
    }
    public String getText(){
        return text;
    }
    public void setId(int id){
        this.id = id;
}
    public void setText(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", text=" + text + '}';
    }
    
    
    
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
    
    
    public void addNote(Connection conn, Note note) throws SQLException{
        String query_insert_note="";
        PreparedStatement stmtNote;
        query_insert_note = "INSERT INTO nota (testo) VALUES (?);";
        
        stmtNote = conn.prepareStatement(query_insert_note);
        stmtNote.setString(1, note.getText());
        
        stmtNote.executeUpdate();
    }
}
