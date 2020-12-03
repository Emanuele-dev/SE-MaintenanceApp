/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.team14.se.maintenanceapp.Note;
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
public class NoteJUnit4Test {
    
    public NoteJUnit4Test() {
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
     * Test of getId method, of class Note.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Note instance = new Note(0, "");
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getText method, of class Note.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        Note instance = new Note(0, "");
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Note.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Note instance = new Note(0, "");
        instance.setId(id);
    }

    /**
     * Test of setText method, of class Note.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String text = "";
        Note instance = new Note(0, "");
        instance.setText(text);
    }

    /**
     * Test of toString method, of class Note.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Note instance = new Note(0, "");
        String expResult = "Note{" + "id=" + instance.getId() + ", text=" + instance.getText() + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNotes method, of class Note.
     */
    @Test
    public void testGetNotes() throws Exception {
        System.out.println("getNotes");
        Connection conn = null;
        LinkedList<Note> expResult = null;
        LinkedList<Note> result = Note.getNotes(conn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNote method, of class Note.
     */
    @Test
    public void testAddNote() throws Exception {
        System.out.println("addNote");
        Connection conn = null;
        Note note = null;
        Note instance = null;
        instance.addNote(conn, note);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeNote method, of class Note.
     */
    @Test
    public void testRemoveNote() throws Exception {
        System.out.println("removeNote");
        Connection conn = null;
        Note note = null;
        Note instance = null;
        instance.removeNote(conn, note);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateNote method, of class Note.
     */
    @Test
    public void testUpdateNote() throws Exception {
        System.out.println("updateNote");
        Connection conn = null;
        Note note = null;
        int oldId = 0;
        Note instance = null;
        instance.updateNote(conn, note, oldId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
