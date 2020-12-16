/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.Competence;
import com.team14.se.maintenanceapp.MyConnection;
import com.team14.se.maintenanceapp.Procedure;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
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
    private static Connection conn;
    private static MyConnection myconn;
    
    public ProcedureJUnit4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
       myconn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest?allowMultiQueries=true", "postgres", "2036");
       conn = myconn.getConnection();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception{
        conn.createStatement().executeUpdate(Files.readString(Paths.get("../Database Repo/ScriptTest.sql")));
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
     * Test of getCompetences method, of class Procedure.
     */
    @Test
    public void testGetCompetences() {
        System.out.println("getCompetences");
        Procedure instance = new Procedure(0, "", "", null);
        LinkedList<Competence> expResult = null;
        LinkedList<Competence> result = instance.getCompetences();
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
     * Test of setCompetences method, of class Procedure.
     */
    @Test
    public void testSetCompetences() {
        System.out.println("setCompetences");
        LinkedList<Competence> competences = null;
        Procedure instance = new Procedure(0, "", "", null);
        instance.setCompetences(competences);
    }

    /**
     * Test of toString method, of class Procedure.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Procedure instance = new Procedure(0, "", "", null);
        String expResult = "Procedure{" + "id=" + instance.getId() + ", name=" + instance.getName() + ", smpName=" + instance.getSmpName() + ", competences=" + instance.getCompetences() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcedures method, of class Procedure.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetProcedures() throws Exception {
        System.out.println("getProcedures");
        LinkedList<Procedure> expResult = new LinkedList<>();
        LinkedList<Procedure> result = Procedure.getProcedures(conn);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of GetProcedureCompetences method, of class Procedure.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetProcedureCompetences()throws Exception{
        System.out.println("getProcedureCompetences");
        int procedureId = 0;
        LinkedList<Competence> expResult = new LinkedList<>();
        LinkedList<Competence> result = Procedure.getProcedureCompetences(conn, procedureId);
        assertEquals(expResult, result);
    }

    /**
     * Test of assignCompetencesToProcedure method, of class Procedure.
     * @throws java.lang.Exception
     */
    @Test
    public void testAssignCompetencesToProcedure()throws Exception{
        System.out.println("assignCompetenceToprocedure");
        Procedure procedure = null;
        LinkedList<Competence> competences = new LinkedList<>();
        Procedure.assignCompetencesToProcedure(conn, procedure, competences);
    }
    
    /**
     * Test of addProcedure method, of class Procedure.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddProcedure() throws Exception {
        System.out.println("addProcedure");
        Procedure procedure =  new Procedure(0, "", "", null);
        Procedure.addProcedure(conn, procedure);
    }

    /**
     * Test of removeProcedure method, of class Procedure.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveProcedure() throws Exception {
        System.out.println("removeProcedure");
        Procedure procedure = new Procedure(0, "", "", null);;
        Procedure.removeProcedure(conn, procedure);
    }

    /**
     * Test of updateProcedure method, of class Procedure.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateProcedure() throws Exception {
        System.out.println("updateProcedure");
        Procedure procedure = new Procedure(0, "", "", null);;
        int oldId = 0;
        Procedure.updateProcedure(conn, procedure, oldId);
    }
    
}
