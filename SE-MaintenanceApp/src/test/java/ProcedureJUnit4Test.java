/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.Competence;
import com.team14.se.maintenanceapp.Procedure;
import java.sql.Connection;
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
public class ProcedureJUnit4Test {
    
    public ProcedureJUnit4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Procedure.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Procedure instance = new Procedure(0, "", "", null);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Procedure.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Procedure instance = new Procedure(0, "", "", null);
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSmpName method, of class Procedure.
     */
    @Test
    public void testGetSmpName() {
        System.out.println("getSmpName");
        Procedure instance = new Procedure(0, "", "", null);
        String expResult = "";
        String result = instance.getSmpName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompetence method, of class Procedure.
     */
    @Test
    public void testGetCompetence() {
        System.out.println("getCompetence");
        Procedure instance = new Procedure(0, "", "", null);
        Competence expResult = null;
        Competence result = instance.getCompetence();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Procedure.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Procedure instance = new Procedure(0, "", "", null);
        instance.setId(id);
    }

    /**
     * Test of setName method, of class Procedure.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Procedure instance = new Procedure(0, "", "", null);
        instance.setName(name);
    }

    /**
     * Test of setSmpName method, of class Procedure.
     */
    @Test
    public void testSetSmpName() {
        System.out.println("setSmpName");
        String smpName = "";
        Procedure instance = new Procedure(0, "", "", null);
        instance.setSmpName(smpName);
    }

    /**
     * Test of setCompetence method, of class Procedure.
     */
    @Test
    public void testSetCompetence() {
        System.out.println("setCompetence");
        Competence competence = null;
        Procedure instance = new Procedure(0, "", "", null);
        instance.setCompetence(competence);
    }

    /**
     * Test of toString method, of class Procedure.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Procedure instance = new Procedure(0, "", "", null);
        String expResult = "Procedure{" + "id=" + instance.getId() + ", name=" + instance.getName() + ", smpName=" + instance.getSmpName() + ", competence=" + instance.getCompetence() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcedures method, of class Procedure.
     */
    @Test
    public void testGetProcedures() throws Exception {
        System.out.println("getProcedures");
        Connection conn = null;
        LinkedList<Procedure> expResult = null;
        LinkedList<Procedure> result = Procedure.getProcedures(conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProcedure method, of class Procedure.
     */
    @Test
    public void testAddProcedure() throws Exception {
        System.out.println("addProcedure");
        Connection conn = null;
        Procedure procedure = null;
        Procedure instance = null;
        instance.addProcedure(conn, procedure);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeProcedure method, of class Procedure.
     */
    @Test
    public void testRemoveProcedure() throws Exception {
        System.out.println("removeProcedure");
        Connection conn = null;
        Procedure procedure = null;
        Procedure instance = null;
        instance.removeProcedure(conn, procedure);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProcedure method, of class Procedure.
     */
    @Test
    public void testUpdateProcedure() throws Exception {
        System.out.println("updateProcedure");
        Connection conn = null;
        Procedure procedure = null;
        int oldId = 0;
        Procedure instance = null;
        instance.updateProcedure(conn, procedure, oldId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
