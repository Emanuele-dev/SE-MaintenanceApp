/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.team14.se.maintenanceapp.Competence;
import com.team14.se.maintenanceapp.MaintenanceActivity;
import com.team14.se.maintenanceapp.Procedure;
import com.team14.se.maintenanceapp.User;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class MaintainerGUI extends javax.swing.JFrame {

    private User loggedUser;
    private Connection connection;
    private LinkedList<MaintenanceActivity> activityList;
    private MaintenanceActivity targetActivity;
    private DefaultListModel listModel = new DefaultListModel();

    /**
     * Creates new form PlannerGUI
     */
    public MaintainerGUI() {
        initComponents();
    }

    /**
     * Creates new form PlannerGUI
     *
     * @param loggedUser the logged user
     * @param connection the database connection
     */
    public MaintainerGUI(User loggedUser, Connection connection) {
        this.loggedUser = loggedUser;
        this.connection = connection;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainJPanel = new javax.swing.JPanel();
        topJPanel = new javax.swing.JPanel();
        refreshJButton = new javax.swing.JButton();
        weekNumberJLabel = new javax.swing.JLabel();
        weekJSpinner = new javax.swing.JSpinner();
        detailsJPanel = new javax.swing.JPanel();
        detailsWeekJLabel = new javax.swing.JLabel();
        detailsActivityJLabel = new javax.swing.JLabel();
        detailsSMPJLabel = new javax.swing.JLabel();
        detailsWeekJTextField = new javax.swing.JTextField();
        detailsActivityJTextField = new javax.swing.JTextField();
        detailsSMPJTextField = new javax.swing.JTextField();
        detailsDescriptionJScrollPane = new javax.swing.JScrollPane();
        detailsDescriptionJTextArea = new javax.swing.JTextArea();
        detailsSkillsJScrollPane = new javax.swing.JScrollPane();
        detailsSkillsJList = new javax.swing.JList<>();
        detailsNotesJScrollPane = new javax.swing.JScrollPane();
        detailsNotesJTextArea = new javax.swing.JTextArea();
        detailsStatusJLabel = new javax.swing.JLabel();
        detailsStatusJTextField = new javax.swing.JTextField();
        statusActivityJButton = new javax.swing.JButton();
        activitiesJScrollPane = new javax.swing.JScrollPane();
        activitiesJTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainJPanel.setLayout(new java.awt.BorderLayout());

        refreshJButton.setText("Refresh List");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        weekNumberJLabel.setText("Week N.");

        weekJSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 53, 1));

        javax.swing.GroupLayout topJPanelLayout = new javax.swing.GroupLayout(topJPanel);
        topJPanel.setLayout(topJPanelLayout);
        topJPanelLayout.setHorizontalGroup(
            topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(weekNumberJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshJButton)
                .addGap(611, 611, 611))
        );
        topJPanelLayout.setVerticalGroup(
            topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshJButton)
                    .addComponent(weekNumberJLabel)
                    .addComponent(weekJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        mainJPanel.add(topJPanel, java.awt.BorderLayout.PAGE_START);

        detailsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected Activity Details"));

        detailsWeekJLabel.setText("Week N.");

        detailsActivityJLabel.setText("Activity");

        detailsSMPJLabel.setText("SMP");

        detailsWeekJTextField.setText("--");
        detailsWeekJTextField.setEnabled(false);
        detailsWeekJTextField.setFocusable(false);

        detailsActivityJTextField.setEnabled(false);
        detailsActivityJTextField.setFocusable(false);

        detailsSMPJTextField.setEnabled(false);
        detailsSMPJTextField.setFocusable(false);

        detailsDescriptionJScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));

        detailsDescriptionJTextArea.setColumns(20);
        detailsDescriptionJTextArea.setRows(5);
        detailsDescriptionJTextArea.setEnabled(false);
        detailsDescriptionJTextArea.setFocusable(false);
        detailsDescriptionJScrollPane.setViewportView(detailsDescriptionJTextArea);

        detailsSkillsJScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Skills Nedded"));

        detailsSkillsJList.setEnabled(false);
        detailsSkillsJScrollPane.setViewportView(detailsSkillsJList);

        detailsNotesJScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Workspace Notes"));

        detailsNotesJTextArea.setColumns(20);
        detailsNotesJTextArea.setRows(5);
        detailsNotesJTextArea.setEnabled(false);
        detailsNotesJTextArea.setFocusable(false);
        detailsNotesJScrollPane.setViewportView(detailsNotesJTextArea);

        detailsStatusJLabel.setText("Status:");

        detailsStatusJTextField.setText("N/D");
        detailsStatusJTextField.setEnabled(false);
        detailsStatusJTextField.setFocusable(false);
        detailsStatusJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsStatusJTextFieldActionPerformed(evt);
            }
        });

        statusActivityJButton.setText("Declare activity complete");
        statusActivityJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActivityJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout detailsJPanelLayout = new javax.swing.GroupLayout(detailsJPanel);
        detailsJPanel.setLayout(detailsJPanelLayout);
        detailsJPanelLayout.setHorizontalGroup(
            detailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailsNotesJScrollPane)
                    .addGroup(detailsJPanelLayout.createSequentialGroup()
                        .addGroup(detailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(statusActivityJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(detailsDescriptionJScrollPane)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detailsJPanelLayout.createSequentialGroup()
                                .addComponent(detailsWeekJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(detailsWeekJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(detailsStatusJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(detailsStatusJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detailsJPanelLayout.createSequentialGroup()
                                .addComponent(detailsSMPJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(detailsSMPJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detailsJPanelLayout.createSequentialGroup()
                                .addComponent(detailsActivityJLabel)
                                .addGap(18, 18, 18)
                                .addComponent(detailsActivityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(detailsSkillsJScrollPane))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        detailsJPanelLayout.setVerticalGroup(
            detailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsJPanelLayout.createSequentialGroup()
                .addGroup(detailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(detailsStatusJLabel)
                        .addComponent(detailsStatusJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(detailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(detailsWeekJLabel)
                        .addComponent(detailsWeekJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailsActivityJLabel)
                    .addComponent(detailsActivityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailsSMPJLabel)
                    .addComponent(detailsSMPJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(detailsDescriptionJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(detailsSkillsJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(detailsNotesJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusActivityJButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainJPanel.add(detailsJPanel, java.awt.BorderLayout.LINE_END);

        activitiesJScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Assigned Mantainance Activities"));

        activitiesJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Area", "Type", "EIT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        activitiesJTable.getTableHeader().setReorderingAllowed(false);
        activitiesJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activitiesJTableMouseClicked(evt);
            }
        });
        activitiesJScrollPane.setViewportView(activitiesJTable);

        mainJPanel.add(activitiesJScrollPane, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(mainJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        refreshElements();
        
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void activitiesJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activitiesJTableMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        String id = source.getModel().getValueAt(row, 0) + "";
        activityList.forEach((MaintenanceActivity activity) -> {
            if (activity.getActivityId() == Integer.parseInt(id)) {
                try {
                    targetActivity = activity;
                    detailsActivityJTextField.setText(activity.getName());
                    detailsWeekJTextField.setText(String.valueOf(activity.getWeek()));
                    detailsSMPJTextField.setText(activity.getProcedure().getSmpName());
                    detailsDescriptionJTextArea.setText(activity.getDescription());
                    detailsNotesJTextArea.setText(activity.getNote());
                    listModel = new DefaultListModel();
                    LinkedList<Competence> competenceList = Procedure.getProcedureCompetences(connection, activity.getProcedure().getId());
                    competenceList.forEach(competence -> {
                        listModel.addElement(competence.getName());
                    });
                    detailsSkillsJList.setModel(listModel);
                    detailsNotesJTextArea.setEnabled(true);
                    detailsStatusJTextField.setEnabled(true);
                    if (!activity.getState()) {
                        detailsStatusJTextField.setText("Not Complete");
                        detailsStatusJTextField.setBackground(Color.red);
                    } else {
                        detailsStatusJTextField.setText("Complete");
                        detailsStatusJTextField.setBackground(Color.green);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MaintainerGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }//GEN-LAST:event_activitiesJTableMouseClicked

    private void detailsStatusJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsStatusJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsStatusJTextFieldActionPerformed

    private void statusActivityJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActivityJButtonActionPerformed
        if (targetActivity == null) {
            JOptionPane.showMessageDialog(rootPane, "Please, select an activity to declar complete", "Error: No activity selected", JOptionPane.ERROR_MESSAGE);
        } else {
            if (targetActivity.getState()) {
                JOptionPane.showMessageDialog(rootPane, "This activity is already complete. Please select a valid activity", "Error: Activity Already Complete", JOptionPane.ERROR_MESSAGE);
            } else {
                int input = JOptionPane.showConfirmDialog(rootPane,
                        "Are you sure to declare this activity ?",
                        "Select an Option...", JOptionPane.YES_NO_CANCEL_OPTION);

                if (input == 0) {
                    try {
                        targetActivity.setState(true);
                        System.out.println(targetActivity.getState());
                        System.out.println(targetActivity.getActivityId());
                        MaintenanceActivity.updateMaintenanceActivity(connection, targetActivity, targetActivity.getActivityId());
                         JOptionPane.showMessageDialog(rootPane, "Operation completed successfully");
                         refreshElements();
                    } catch (SQLException ex) {
                        Logger.getLogger(MaintainerGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Operation canceled");
                }
            }
        }
    }//GEN-LAST:event_statusActivityJButtonActionPerformed

    

    private void initTable(int n_week) {
        try {
            activityList = MaintenanceActivity.getMaintenanceActivities(connection);
            DefaultTableModel activitiesTabelModel = (DefaultTableModel) activitiesJTable.getModel();
            activitiesTabelModel.setNumRows(0);
            activitiesTabelModel.fireTableDataChanged();
            activityList.forEach((MaintenanceActivity activity) -> {
                if (activity.getWeek() == n_week) {
                    String queryCheckIfAssigned = "SELECT * FROM ESECUZIONE WHERE activity_id ='" + activity.getActivityId() + "'"
                            + "AND maintainer='" + loggedUser.getUsername() + "';";
                    try {
                        PreparedStatement statementForCheck = connection.prepareStatement(queryCheckIfAssigned);
                        ResultSet rsCheck = statementForCheck.executeQuery();
                        if (rsCheck.next()) {
                            activitiesTabelModel.addRow(new Object[]{activity.getActivityId(), activity.getSite().getName(), activity.getTypology().getName(), activity.getEstimatedIntervention() + " min."});
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(MaintainerGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(PlannerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane activitiesJScrollPane;
    private javax.swing.JTable activitiesJTable;
    private javax.swing.JLabel detailsActivityJLabel;
    private javax.swing.JTextField detailsActivityJTextField;
    private javax.swing.JScrollPane detailsDescriptionJScrollPane;
    private javax.swing.JTextArea detailsDescriptionJTextArea;
    private javax.swing.JPanel detailsJPanel;
    private javax.swing.JScrollPane detailsNotesJScrollPane;
    private javax.swing.JTextArea detailsNotesJTextArea;
    private javax.swing.JLabel detailsSMPJLabel;
    private javax.swing.JTextField detailsSMPJTextField;
    private javax.swing.JList<String> detailsSkillsJList;
    private javax.swing.JScrollPane detailsSkillsJScrollPane;
    private javax.swing.JLabel detailsStatusJLabel;
    private javax.swing.JTextField detailsStatusJTextField;
    private javax.swing.JLabel detailsWeekJLabel;
    private javax.swing.JTextField detailsWeekJTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainJPanel;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton statusActivityJButton;
    private javax.swing.JPanel topJPanel;
    private javax.swing.JSpinner weekJSpinner;
    private javax.swing.JLabel weekNumberJLabel;
    // End of variables declaration//GEN-END:variables

    private void refreshElements() {
        int week_n = (int) weekJSpinner.getValue();
        initTable(week_n);
        detailsNotesJTextArea.setEnabled(false);
        detailsWeekJTextField.setText("--");
        detailsSMPJTextField.setText("");
        detailsActivityJTextField.setText("");
        detailsDescriptionJTextArea.setText("");
        detailsSkillsJList.removeAll();
        detailsStatusJTextField.setEnabled(false);
        detailsNotesJTextArea.setText("");
        listModel.removeAllElements();
        detailsStatusJTextField.setText("N/D");
        targetActivity = null;
    }
}
