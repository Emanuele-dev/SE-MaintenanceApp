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
public class Site {
    private String name;
    
    /**
     * Constructor Site: create a site with its name
     * @param name 
     */
    public Site(String name){
        this.name = name;
    }
    /**
     * 
     * @return site name
     */
    public String getName(){
        return name;
    }
    /**
     * 
     * @param name new site name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Print site
     * @return string containing data for a single site
     */
    @Override
    public String toString() {
        return "Site{" + "name=" + name + '}';
    }
    
    /**
     * Get all the sites in the database
     * @param conn connection with the database opened
     * @return list of sites present
     * @throws SQLException 
     */
    public static LinkedList<Site> getSites (Connection conn) throws SQLException{
        LinkedList<Site> sites = new LinkedList<>();
        String query = "SELECT * FROM sito";
        PreparedStatement stm = conn.prepareStatement(query);
        ResultSet rst = stm.executeQuery();
        while(rst.next()){
            sites.add(new Site(rst.getString("nome")));
        }
        return sites;    
    }
    /**
     * Add a site in the database
     * @param conn connection with the database opened
     * @param site new site to add
     * @throws SQLException 
     */
    public static void addSite(Connection conn, Site site) throws SQLException{
        String query_insert_site="";
        PreparedStatement stmtSite;
        query_insert_site = "INSERT INTO sito (nome) VALUES (?);";
        
        stmtSite = conn.prepareStatement(query_insert_site);
        stmtSite.setString(1, site.getName());
        stmtSite.executeUpdate();
    }
    /**
     * Remove a site from the database
     * @param conn connection with the database opened
     * @param site site to remove 
     * @throws SQLException 
     */
    public static void removeSite(Connection conn, Site site) throws SQLException{
        String query_insert_site="";
        PreparedStatement stmtSite;
        query_insert_site = "DELETE FROM sito WHERE (nome) = (?);";
        
        stmtSite = conn.prepareStatement(query_insert_site);
        stmtSite.setString(1, site.getName());
        stmtSite.executeUpdate();
    }
    /**
     * Update a site in the database 
     * @param conn connection with the database opened
     * @param site new site information
     * @param oldName old site to update
     * @throws SQLException 
     */
    public static void updateSite(Connection conn, Site site, String oldName) throws SQLException{
        String query_insert_site="";
        PreparedStatement stmtSite;
        query_insert_site = "UPDATE sito SET nome = (?) WHERE nome = (?)";
        stmtSite= conn.prepareStatement(query_insert_site);
        stmtSite.setString(1, site.getName());
        stmtSite.setString(2, oldName);
        stmtSite.executeUpdate();
        
    }


}
