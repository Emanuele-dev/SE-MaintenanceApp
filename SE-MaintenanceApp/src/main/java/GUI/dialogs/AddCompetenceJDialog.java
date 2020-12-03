/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.dialogs;

import GUI.Messages;
import com.team14.se.maintenanceapp.Competence;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author mario
 */
public class AddCompetenceJDialog extends javax.swing.JDialog {
    
    private final AddCompetenceJDialog frame = this;
    
    private Connection connection;
    private Competence newCompetence;

    /**
     * Creates new form AddCompetenceJdialog
     * 
     * @param parent the parent frame
     * @param modal control if the dialog should be modal
     */
    public AddCompetenceJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.newCompetence = null;
        initComponents();
    }
    
    /**
     * Creates new form AddUserJDialog
     * 
     * @param parent the parent frame
     * @param modal control if the dialog should be modal
     * @param connection the database connection
     */
    public AddCompetenceJDialog(java.awt.Frame parent, boolean modal, Connection connection) {
        super(parent, modal);
        this.newCompetence = null;
        this.connection = connection;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        addJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Competence");
        setPreferredSize(new java.awt.Dimension(400, 70));
        setResizable(false);

        nameJLabel.setText("Name");

        addJButton.setText("Add Competence");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        cancelJButton.setText("Cancel");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameJTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 155, Short.MAX_VALUE)
                        .addComponent(cancelJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addJButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJLabel)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addJButton)
                    .addComponent(cancelJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        for(Component component:this.getContentPane().getComponents()){
            component.setEnabled(false);
        }
        
        String name = this.nameJTextField.getText();
        
        if (name.isBlank()) {
            Messages.showErrorEmptyfield(this, "Name");
        } else {
            newCompetence = new Competence(name);
            new AddCompetenceWorker().execute();
            return;
        }
        
        for(Component component:this.getContentPane().getComponents()){
            component.setEnabled(true);
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    private class AddCompetenceWorker extends SwingWorker<Boolean , Void> {
        @Override
        protected Boolean doInBackground() throws Exception {
            try {
                newCompetence.addCompetence(connection, newCompetence);
                return true;
            } catch(SQLException ex){
                Logger.getLogger(AddCompetenceJDialog.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }

        @Override
        protected void done() {
            try {
                boolean result = get();
                if (result) {
                    JOptionPane.showMessageDialog(frame, "Competence Created!");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame,
                        "An error has occurred",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    for(Component component:frame.getContentPane().getComponents()){
                        component.setEnabled(true);
                    }
                }
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(AddUserJDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddCompetenceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCompetenceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCompetenceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCompetenceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddCompetenceJDialog dialog = new AddCompetenceJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    // End of variables declaration//GEN-END:variables

}