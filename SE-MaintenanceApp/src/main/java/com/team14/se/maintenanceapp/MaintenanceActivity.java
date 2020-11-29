/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team14.se.maintenanceapp;
import java.util.*;


/**
 *
 * @author domal
 */
public class MaintenanceActivity {
    private int activityId;
    private String description;
    private boolean interruptible;
    private boolean ewo;
    private int week;
    private boolean state; // completa o no
    private Procedure procedure;
    private Site site;
    private Typology typology;
    private Material material;
    private ArrayList<User> users; //Maintainers
    
    
    public MaintenanceActivity(int activityId, String description, 
            boolean interruptible, boolean ewo, int week, boolean state, 
            Procedure procedure, Site site, Typology typology, 
            Material material, ArrayList<User> users){
        
        this.activityId = activityId;
        this.description = description;
        this.interruptible = interruptible;
        this.ewo = ewo;
        this.week = week;
        this.state = state;
        this.procedure = procedure;
        this.site = site;
        this.typology = typology;
        this.material = material;
        this.users = users;
        
    }
    public int getActivityId(){
        return activityId;
    }
    public String getDescription(){
        return description;
    }
    public boolean getInterruptable(){
        return interruptible;
    }
    public boolean getEwo(){
        return ewo;
    }
    public int getWeek(){
        return week;
    }
    public boolean getState(){
        return state;
    }
    public Procedure getProcedure(){
        return procedure;
    }
    public Site getSite(){
        return site;
    }
    public Typology getTypology(){
        return typology;
    }
    public Material getMaterial(){
        return material;
    }
    public ArrayList getUsers(){
        return users;
    }
    
    
    public void setActivityId(int activityId){
         this.activityId = activityId;
    }
    public void setDescription(String description){
         this.description = description;
    }
    public void setInterruptable(boolean interruptible){
        this.interruptible = interruptible;
    }
    public void setEwo(boolean ewo){
        this.ewo = ewo;
    }
    public void setWeek(int week){
        this.week = week;
    }
    public void setState(boolean state){
        this.state = state;
    }
    public void setProcedure(Procedure procedure){
        this.procedure = procedure;
    }
    public void setSite(Site site){
        this.site = site;
    }
    public void setTypology(Typology typology){
        this.typology = typology;
    }
    public void setMaterial(Material material){
        this.material = material;
    }
    public void setUsers(ArrayList users){
        this.users = users;
    }

    @Override
    public String toString() {
        return "MaintenanceActivity{" + "activityId=" + activityId + ", description=" + description + ", interruptible=" + interruptible + ", ewo=" + ewo + ", week=" + week + ", state=" + state + ", procedure=" + procedure + ", site=" + site + ", typology=" + typology + ", material=" + material + ", users=" + users + '}';
    }
    
    
    
    
}
