/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.MyConnection;
import com.team14.se.maintenanceapp.Site;
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
public class SiteJUnit4Test {
    
    public SiteJUnit4Test() {
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
     * Test of getName method, of class Site.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Site instance = new Site("");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Site.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Site instance = new Site("");
        instance.setName(name);
    }

    /**
     * Test of toString method, of class Site.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Site instance = new Site("");
        String expResult = "Site{" + "name=" + instance.getName() + "}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSites method, of class Site.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetSites() throws Exception {
        System.out.println("getSites");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        LinkedList<Site> expResult = new LinkedList<>();
        LinkedList<Site> result = Site.getSites(conn);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSite method, of class Site.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddSite() throws Exception {
        System.out.println("addSite");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        Site site = new Site("");
        Site.addSite(conn, site);
    }

    /**
     * Test of removeSite method, of class Site.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveSite() throws Exception {
        System.out.println("removeSite");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        Site site = new Site("");
        Site.removeSite(conn, site);
    }

    /**
     * Test of updateSite method, of class Site.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateSite() throws Exception {
        System.out.println("updateSite");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        Site site = new Site("");;
        String oldName = "";
        Site.updateSite(conn, site, oldName);
    }
    
}
