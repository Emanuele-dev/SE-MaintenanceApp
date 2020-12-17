/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.DatabaseUserTest;
import com.team14.se.maintenanceapp.MyConnection;
import com.team14.se.maintenanceapp.Typology;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    private static Connection conn;
    private static MyConnection myconn;
    
    public TypologyJUnit4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
       myconn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest?allowMultiQueries=true", DatabaseUserTest.USER_DATABASE, DatabaseUserTest.PASSWORD_DATABASE);
       conn = myconn.getConnection();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        conn.createStatement().executeUpdate(Files.readString(Paths.get("../Database Repo/ScriptTest.sql")));
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
        Typology typology = new Typology("");;
        String oldName = "";
        Typology.updateTypology(conn, typology, oldName);
    }
    
}
