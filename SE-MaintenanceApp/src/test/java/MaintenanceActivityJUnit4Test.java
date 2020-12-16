/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.MaintenanceActivity;
import com.team14.se.maintenanceapp.Material;
import com.team14.se.maintenanceapp.MyConnection;
import com.team14.se.maintenanceapp.Procedure;
import com.team14.se.maintenanceapp.Site;
import com.team14.se.maintenanceapp.Typology;
import com.team14.se.maintenanceapp.User;
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
public class MaintenanceActivityJUnit4Test {
    
    public MaintenanceActivityJUnit4Test() {
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
     * Test of getActivityId method, of class MaintenanceActivity.
     */
    @Test
    public void testGetActivityId() {
        System.out.println("getActivityId");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        int expResult = 0;
        int result = instance.getActivityId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class MaintenanceActivity.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class MaintenanceActivity.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInterruptable method, of class MaintenanceActivity.
     */
    @Test
    public void testGetInterruptable() {
        System.out.println("getInterruptable");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        boolean expResult = false;
        boolean result = instance.getInterruptable();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstimatedIntervention method, of class MaintenanceActivity.
     */
    @Test
    public void testGetEstimatedIntervention() {
        System.out.println("getEstimatedIntervention");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        int expResult = 0;
        int result = instance.getEstimatedIntervention();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEwo method, of class MaintenanceActivity.
     */
    @Test
    public void testGetEwo() {
        System.out.println("getEwo");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        boolean expResult = false;
        boolean result = instance.getEwo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeek method, of class MaintenanceActivity.
     */
    @Test
    public void testGetWeek() {
        System.out.println("getWeek");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        int expResult = 0;
        int result = instance.getWeek();
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class MaintenanceActivity.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        boolean expResult = false;
        boolean result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcedure method, of class MaintenanceActivity.
     */
    @Test
    public void testGetProcedure() {
        System.out.println("getProcedure");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        Procedure expResult = null;
        Procedure result = instance.getProcedure();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSite method, of class MaintenanceActivity.
     */
    @Test
    public void testGetSite() {
        System.out.println("getSite");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        Site expResult = null;
        Site result = instance.getSite();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTypology method, of class MaintenanceActivity.
     */
    @Test
    public void testGetTypology() {
        System.out.println("getTypology");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        Typology expResult = null;
        Typology result = instance.getTypology();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaterials method, of class MaintenanceActivity.
     */
    @Test
    public void testGetMaterials() {
        System.out.println("getMaterials");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        LinkedList<Material> expResult = new LinkedList<>();
        LinkedList<Material> result = instance.getMaterials();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNote method, of class MaintenanceActivity.
     */
    public void testGetNote(){
        System.out.println("getNote");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        String expResult = "";
        String result = instance.getNote();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class MaintenanceActivity.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        ArrayList expResult = null;
        ArrayList result = instance.getUsers();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActivityId method, of class MaintenanceActivity.
     */
    @Test
    public void testSetActivityId() {
        System.out.println("setActivityId");
        int activityId = 0;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setActivityId(activityId);
    }

    /**
     * Test of setName method, of class MaintenanceActivity.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setName(name);
    }

    /**
     * Test of setDescription method, of class MaintenanceActivity.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setDescription(description);
    }

    /**
     * Test of setInterruptable method, of class MaintenanceActivity.
     */
    @Test
    public void testSetInterruptable() {
        System.out.println("setInterruptable");
        boolean interruptible = false;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setInterruptable(interruptible);
    }

    /**
     * Test of setEstimatedIntervention method, of class MaintenanceActivity.
     */
    @Test
    public void testSetEstimatedIntervention() {
        System.out.println("setEstimatedIntervention");
        int estimatedIntervention = 0;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setEstimatedIntervention(estimatedIntervention);
    }

    /**
     * Test of setEwo method, of class MaintenanceActivity.
     */
    @Test
    public void testSetEwo() {
        System.out.println("setEwo");
        boolean ewo = false;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setEwo(ewo);
    }

    /**
     * Test of setWeek method, of class MaintenanceActivity.
     */
    @Test
    public void testSetWeek() {
        System.out.println("setWeek");
        int week = 0;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setWeek(week);
    }

    /**
     * Test of setState method, of class MaintenanceActivity.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        boolean state = false;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setState(state);
    }

    /**
     * Test of setProcedure method, of class MaintenanceActivity.
     */
    @Test
    public void testSetProcedure() {
        System.out.println("setProcedure");
        Procedure procedure = null;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setProcedure(procedure);
    }

    /**
     * Test of setSite method, of class MaintenanceActivity.
     */
    @Test
    public void testSetSite() {
        System.out.println("setSite");
        Site site = null;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setSite(site);
    }

    /**
     * Test of setTypology method, of class MaintenanceActivity.
     */
    @Test
    public void testSetTypology() {
        System.out.println("setTypology");
        Typology typology = null;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setTypology(typology);
    }

    /**
     * Test of setMaterials method, of class MaintenanceActivity.
     */
    @Test
    public void testSetMaterials() {
        System.out.println("setMaterials");
        LinkedList<Material> materials = new LinkedList<>();
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setMaterials(materials);
    }
    
    /**
     * Test of setNote method, of class MaintenanceActivity.
     */
    @Test
    public void testSetNote() {
        System.out.println("setNote");
        String note = "";
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setNote(note);
    }

    /**
     * Test of setUsers method, of class MaintenanceActivity.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        ArrayList<User> users = null;
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        instance.setUsers(users);
    }

    /**
     * Test of toString method, of class MaintenanceActivity.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MaintenanceActivity instance = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        String expResult = "MaintenanceActivity{" + "activityId=" + instance.getActivityId() + ", name=" + instance.getName() + ", description=" + instance.getDescription() + ", interruptible=" + instance.getInterruptable() + ", estimatedIntervention=" + instance.getEstimatedIntervention() + ", ewo=" + instance.getEwo()+ ", week=" + instance.getWeek() + ", state=" + instance.getState() + ", procedure=" + instance.getProcedure() + ", site=" + instance.getSite() + ", typology=" + instance.getTypology() + ", material=" + instance.getMaterials() + ", users=" + instance.getUsers() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of resultQueryGetActivities method, of class MaintenanceActivity.
     * @throws java.lang.Exception
     */
    @Test
    public void testResultQueryGetActivities() throws Exception {
        System.out.println("resultQueryGetActivities");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        String query = "";
        LinkedList<MaintenanceActivity> expResult = null;
        LinkedList<MaintenanceActivity> result = MaintenanceActivity.resultQueryGetActivities(conn, query);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaintenanceActivities method, of class MaintenanceActivity.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaintenanceActivities() throws Exception {
        System.out.println("getMaintenanceActivities");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        LinkedList<MaintenanceActivity> expResult = new LinkedList<>();
        LinkedList<MaintenanceActivity> result = MaintenanceActivity.getMaintenanceActivities(conn);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaintenanceActivitiesByWeek method, of class MaintenanceActivity.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaintenanceActivitiesByWeek() throws Exception {
        System.out.println("getMaintenanceActivitiesByWeek");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        int week_number = 0;
        LinkedList<MaintenanceActivity> expResult = new LinkedList<>();
        LinkedList<MaintenanceActivity> result = MaintenanceActivity.getMaintenanceActivitiesByWeek(conn, week_number);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getMaterialsForActivity method, of class MaintenanceActivity.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMaterialsForActivity()throws Exception{
        System.out.println("getMaterialsForActivity");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        int activityId = 0;
        LinkedList<Material> expResult = new LinkedList<>();
        LinkedList<Material> result = MaintenanceActivity.getMaterialsForActivity(conn, activityId);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addMaintenanceActivity method, of class MaintenanceActivity.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddMaintenanceActivity() throws Exception {
        System.out.println("addMaintenanceActivity");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        Procedure procedure = new Procedure("", "", null);
        Site site = new Site("");
        Typology typology = new Typology("");
        procedure.addProcedure(conn, procedure);
        site.addSite(conn, site);
        typology.addTypology(conn, typology);
        MaintenanceActivity maintActivity = new MaintenanceActivity("", "", false, 0, false, 1, procedure, site, typology, "");
        MaintenanceActivity.addMaintenanceActivity(conn, maintActivity);
    }

    /**
     * Test of removeMaintenanceActivity method, of class MaintenanceActivity.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveMaintenanceActivity() throws Exception {
       System.out.println("removeMaintenanceActivity");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        Procedure procedure = new Procedure("", "", null);
        Site site = new Site("");
        Typology typology = new Typology("");
        MaintenanceActivity maintActivity = new MaintenanceActivity("", "", false, 0, false, 1, procedure, site, typology, "");
        MaintenanceActivity.removeMaintenanceActivity(conn, maintActivity);
    }

    /**
     * Test of updateMaintenanceActivity method, of class MaintenanceActivity.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateMaintenanceActivity() throws Exception {
        System.out.println("updateMaintenanceActivity");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        MaintenanceActivity maintActivity = new MaintenanceActivity("", "", false, 0, false, 0, null, null, null, "");
        int oldActivityId = 0;
        MaintenanceActivity.updateMaintenanceActivity(conn, maintActivity, oldActivityId);
    }
    
}
