/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author mario
 */
public class Messages {
    
    public static void showErrorEmptyfield(Component parent, String name){
        JOptionPane.showMessageDialog(parent,
            name + " cannot be empty",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showErrorDelete(Component parent, String name){
        JOptionPane.showMessageDialog(parent,
                        "An error occurred, make sure the " + name + " is not alredy "
                                + "assigned to some activity",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
    } 
}
