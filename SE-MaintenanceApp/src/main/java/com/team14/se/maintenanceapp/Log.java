/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;
import java.util.Date; // format year, month, day)
import java.sql.Time; //format hour, minutes, seconds

/**
 *
 * @author domal
 */
public class Log {
    private int id;
    private String username;
    private Date date;
    private Time time; 
    
  
    public Log(int id, String username, Date date, Time time){
        this.id = id;
        this.username = username;
        this.date = date;
        this.time = time;
        
    }
    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public Date getDate(){
        return date;
    }
    public Time getTime(){
        return time;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setUsername(String name){
        this.username = username;
    }
    public void setDate(Date date){
        this.date = date; 
    }
    public void setTime(Time time){
        this.time = time; 
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", username=" + username + ", date=" + date + ", time=" + time + '}';
    }
    
    
    
    
    

    
}
