/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.Competence;
import com.team14.se.maintenanceapp.MyConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author domal
 */
public class CompetenceJUnit4Test {
    
    public CompetenceJUnit4Test() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
        
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
   

    /**
     * Test of getId method, of class Competence.
     */
    @org.junit.Test
    public void testGetId() {
        System.out.println("getId");
        Competence instance = new Competence (0, "");
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Competence.
     */
    @org.junit.Test
    public void testGetName() {
        System.out.println("getName");
        Competence instance = new Competence (0, "");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class Competence.
     */
    @org.junit.Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Competence instance = new Competence (0, "", null);
        ArrayList expResult = null;
        ArrayList result = instance.getUsers();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Competence.
     */
    @org.junit.Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Competence instance = new Competence (0, "");
        instance.setId(id);
    }

    /**
     * Test of setName method, of class Competence.
     */
    @org.junit.Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Competence instance = new Competence (0, "");
        instance.setName(name);
    }

    /**
     * Test of setAuthors method, of class Competence.
     */
    @org.junit.Test
    public void testSetUsers() {
        System.out.println("setAuthors");
        ArrayList users = null;
        Competence instance = new Competence (0, "");
        instance.setUsers(users);
    }

    /**
     * Test of toString method, of class Competence.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Competence instance = new Competence("");
        String expResult = "Competence{" + "name=" + instance.getName() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompetences method, of class Competence.
     */
    @org.junit.Test
    public void testGetCompetences() throws Exception {
        System.out.println("getCompetences");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDB", "team14", "team14").getConnection();
        LinkedList<Competence> result = Competence.getCompetences(conn);
        assertEquals(0, result.size());
    }

    /**
     * Test of addCompetence method, of class Competence.
     */
    @org.junit.Test
    public void testAddCompetence() throws Exception {
        System.out.println("addCompetence");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDB", "team14", "team14").getConnection();
        Competence competence = new Competence(0, "");
        Competence instance = new Competence (0, "");
        instance.addCompetence(conn, competence);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeCompetence method, of class Competence.
     */
    @org.junit.Test
    public void testRemoveCompetence() throws Exception {
        System.out.println("removeCompetence");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDB", "team14", "team14").getConnection();
        Competence competence = new Competence (0, "");
        Competence instance = new Competence (0, "");
        instance.removeCompetence(conn, competence);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateCompetence method, of class Competence.
     */
    @org.junit.Test
    public void testUpdateCompetence() throws Exception {
        System.out.println("updateCompetence");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDB", "team14", "team14").getConnection();;
        Competence competence = new Competence (1, "");
        int oldId = 0;
        Competence instance = new Competence (0, "");
        instance.updateCompetence(conn, competence, oldId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Competence.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Competence instance = new Competence (0, "");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
