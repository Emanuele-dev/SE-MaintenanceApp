/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.Material;
import com.team14.se.maintenanceapp.MyConnection;
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
    
    public MaterialJUnit4Test() {
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
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDB", "team14", "team14").getConnection();
        LinkedList<Material> result = Material.getMaterials(conn);
        assertEquals(0, result.size());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMaterial method, of class Material.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddMaterial() throws Exception {
        System.out.println("addMaterial");
        Connection conn = null;
        Material material = null;
        Material.addMaterial(conn, material);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMaterial method, of class Material.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveMaterial() throws Exception {
        System.out.println("removeMaterial");
        Connection conn = null;
        Material material = null;
        Material.removeMaterial(conn, material);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMaterial method, of class Material.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateMaterial() throws Exception {
        System.out.println("updateMaterial");
        Connection conn = null;
        Material material = null;
        int oldName = 0;
        Material.updateMaterial(conn, material, oldName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
