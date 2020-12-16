/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.Log;
import com.team14.se.maintenanceapp.MyConnection;
import com.team14.se.maintenanceapp.User;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
public class LogJUnit4Test {
    
    public LogJUnit4Test() {
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
     * Test of getId method, of class Log.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Log instance = new Log("",null);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getUsername method, of class Log.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Log instance = new Log("", null);
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateTime method, of class Log.
     */
    @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        Log instance = new Log("", null);
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getDateTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Log.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Log instance = new Log(0, "", null);
        instance.setId(id);
    }

    /**
     * Test of setUsername method, of class Log.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Log instance = new Log("", null);
        instance.setUsername(username);
    }

    /**
     * Test of setDateTime method, of class Log.
     */
    @Test
    public void testSetDateTime() {
        System.out.println("setDateTime");
        LocalDateTime timestamp = null;
        Log instance = new Log("", null);
        instance.setDateTime(timestamp);
    }

    /**
     * Test of toString method, of class Log.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Log instance = new Log("", null);
        String expResult = "Log{" + "id=" + instance.getId() + ", username=" + instance.getUsername() + ", date=" + instance.getDateTime() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLogs method, of class Log.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetLogs() throws Exception {
        System.out.println("getLogs");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        LinkedList<Log> expResult = new LinkedList<>();
        LinkedList<Log> result = Log.getLogs(conn);
        assertEquals(expResult, result);
    }

    /**
     * Test of addLog method, of class Log.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddLog() throws Exception {
        System.out.println("addLog");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        User user = new User("", "", "", "", false, "SystemAdministrator");
        user.addUser(conn, user);
        Log log = new Log(user.getName(), LocalDateTime.now());
        Log.addLog(conn, log);
    }

    /**
     * Test of removeLog method, of class Log.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveLog() throws Exception {
        System.out.println("removeLog");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        Log log = new Log(" ", null);
        Log.removeLog(conn, log);
    }

    /**
     * Test of updateLog method, of class Log.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateLog() throws Exception {
        System.out.println("updateLog");
        Connection conn = new MyConnection("jdbc:postgresql://localhost/maintenanceDBTest", "team14", "team14").getConnection();
        Log log = new Log(" ", LocalDateTime.now());
        int oldId = 0;
        Log.updateLog(conn, log, oldId);
    }
    
}
