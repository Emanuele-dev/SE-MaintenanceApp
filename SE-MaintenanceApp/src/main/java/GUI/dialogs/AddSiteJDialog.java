/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.dialogs;

import GUI.Messages;
import com.team14.se.maintenanceapp.Site;
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
public class AddSiteJDialog extends javax.swing.JDialog {

    private final AddSiteJDialog frame = this;
    
    private Connection connection;
    private Site newSite;
    
    /**
     * Creates new form AddSiteJDialog
     * 
     * @param parent the parent frame
     * @param modal control if the dialog should be modal
     */
    public AddSiteJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.newSite = null;
        initComponents();
    }
    
        /**
     * Creates new form AddUserJDialog
     * 
     * @param parent the parent frame
     * @param modal control if the dialog should be modal
     * @param connection the database connection
     */
    public AddSiteJDialog(java.awt.Frame parent, boolean modal, Connection connection) {
        super(parent, modal);
        this.newSite = null;
        this.connection = connection;
        initComponents();
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        addJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        nameJLabel.setText("Name");

        addJButton.setText("Add Site");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
                .addGap(13, 13, 13))
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

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        for(Component component:this.getContentPane().getComponents()){
            component.setEnabled(false);
        }

        String name = this.nameJTextField.getText();

        if (name.isBlank()) {
            Messages.showErrorEmptyfield(this, "Name");
        } else {
            newSite = new Site(name);
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
                Site.addSite(connection, newSite);
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
                    JOptionPane.showMessageDialog(frame, "Site Created!");
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

    
    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    // End of variables declaration//GEN-END:variables
}
