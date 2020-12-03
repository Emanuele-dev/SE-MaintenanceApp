/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.User;
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
public class UserJUnit4Test {
    
    public UserJUnit4Test() {
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
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User("", "", "", "", false, "");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSurname method, of class User.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        User instance = new User("", "", "", "", false, "");
        String expResult = "";
        String result = instance.getSurname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("", "", "", "", false, "");
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("", "", "", "", false, "");
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class User.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        User instance = new User("", "", "", "", false, "");
        boolean expResult = false;
        boolean result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRole method, of class User.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        User instance = new User("", "", "", "", false, "");
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = new User("", "", "", "", false, "");
        instance.setName(name);
    }

    /**
     * Test of setSurname method, of class User.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = "";
        User instance = new User("", "", "", "", false, "");
        instance.setSurname(surname);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        User instance = new User("", "", "", "", false, "");
        instance.setUsername(username);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User("", "", "", "", false, "");
        instance.setPassword(password);
    }

    /**
     * Test of setState method, of class User.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        boolean state = false;
        User instance = new User("", "", "", "", false, "");
        instance.setState(state);
    }

    /**
     * Test of setRole method, of class User.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        User instance = new User("", "", "", "", false, "");
        instance.setRole(role);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User("", "", "", "", false, "");
        String expResult = "User{" + "name=" + instance.getName() + ", surname=" + instance.getSurname() + ", username=" + instance.getUsername() + ", password=" + instance.getPassword() + ", role=" + instance.getRole() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class User.
     */
    @Test
    public void testGetUsers() throws Exception {
        System.out.println("getUsers");
        Connection conn = null;
        LinkedList<User> expResult = null;
        LinkedList<User> result = User.getUsers(conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class User.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        Connection conn = null;
        User user = null;
        User instance = null;
        instance.addUser(conn, user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class User.
     */
    @Test
    public void testRemoveUser() throws Exception {
        System.out.println("removeUser");
        Connection conn = null;
        User user = null;
        User instance = null;
        instance.removeUser(conn, user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class User.
     */
    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        Connection conn = null;
        User user = null;
        String oldUsername = "";
        User instance = null;
        instance.updateUser(conn, user, oldUsername);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
