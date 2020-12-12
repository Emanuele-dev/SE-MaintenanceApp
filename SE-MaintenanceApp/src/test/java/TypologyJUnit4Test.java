/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.Typology;
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
public class TypologyJUnit4Test {
    
    public TypologyJUnit4Test() {
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
     * Test of getName method, of class Typology.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Typology instance = new Typology("");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Typology.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Typology instance = new Typology("");
        instance.setName(name);
    }

    /**
     * Test of toString method, of class Typology.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Typology instance = new Typology("");
        String expResult = "Typology{" + "name=" + instance.getName() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTypologies method, of class Typology.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetTypologies() throws Exception {
        System.out.println("getTypologies");
        Connection conn = null;
        LinkedList<Typology> expResult = null;
        LinkedList<Typology> result = Typology.getTypologies(conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTypology method, of class Typology.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddTypology() throws Exception {
        System.out.println("addTypology");
        Connection conn = null;
        Typology typology = null;
        Typology.addTypology(conn, typology);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTypology method, of class Typology.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveTypology() throws Exception {
        System.out.println("removeTypology");
        Connection conn = null;
        Typology typology = null;
        Typology.removeTypology(conn, typology);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateTypology method, of class Typology.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateTypology() throws Exception {
        System.out.println("updateTypology");
        Connection conn = null;
        Typology typology = null;
        String oldName = "";
        Typology.updateTypology(conn, typology, oldName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
