/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.MyConnection;
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
        String expResult = "Typology{" + "name=" + instance.getName() + "}";
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
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDB", "team14", "team14").getConnection();
        LinkedList<Typology> expResult = new LinkedList<>();
        LinkedList<Typology> result = Typology.getTypologies(conn);
        assertEquals(expResult, result);
    }

    /**
     * Test of addTypology method, of class Typology.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddTypology() throws Exception {
        System.out.println("addTypology");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDB", "team14", "team14").getConnection();
        Typology typology = new Typology("");
        Typology.addTypology(conn, typology);
    }

    /**
     * Test of removeTypology method, of class Typology.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveTypology() throws Exception {
        System.out.println("removeTypology");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDB", "team14", "team14").getConnection();
        Typology typology = new Typology("");;
        Typology.removeTypology(conn, typology);
    }

    /**
     * Test of updateTypology method, of class Typology.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateTypology() throws Exception {
        System.out.println("updateTypology");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDB", "team14", "team14").getConnection();
        Typology typology = new Typology("");;
        String oldName = "";
        Typology.updateTypology(conn, typology, oldName);
    }
    
}
