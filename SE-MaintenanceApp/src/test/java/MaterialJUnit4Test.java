/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.DatabaseUserTest;
import com.team14.se.maintenanceapp.Material;
import com.team14.se.maintenanceapp.MyConnection;
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
public class MaterialJUnit4Test {
    private static Connection conn;
    private static MyConnection myconn;
    
    public MaterialJUnit4Test() {
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
     * Test of getName method, of class Material.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Material instance = new Material("", "");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Material.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Material instance = new Material("", "");
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Material.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Material instance = new Material("", "");
        instance.setName(name);
    }

    /**
     * Test of setDescription method, of class Material.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Material instance = new Material("", "");
        instance.setDescription(description);
    }

    /**
     * Test of toString method, of class Material.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Material instance = new Material("", "");
        String expResult = "Material{" + "name=" + instance.getName() + ", description=" + instance.getDescription() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaterials method, of class Material.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterials() throws Exception {
        System.out.println("getMaterials");
        LinkedList<Material> expResult = new LinkedList<>();
        LinkedList<Material> result = Material.getMaterials(conn);
        assertEquals(expResult, result);
    }

    /**
     * Test of addMaterial method, of class Material.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddMaterial() throws Exception {
        System.out.println("addMaterial");
        Material material = new Material("", "");
        Material.addMaterial(conn, material);
    }

    /**
     * Test of removeMaterial method, of class Material.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveMaterial() throws Exception {
        System.out.println("removeMaterial");
        Material material = new Material("", "");
        Material.removeMaterial(conn, material);
    }

    /**
     * Test of updateMaterial method, of class Material.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateMaterial() throws Exception {
        System.out.println("updateMaterial");
        Material material = new Material("", "");
        String oldName = "";
        Material.updateMaterial(conn, material, oldName);
    }
    
}
