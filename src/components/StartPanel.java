/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;

import connection.DBConnection;
import controller.PanelController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server.Server;

/**
 *
 * @author Gazi
 */
public class StartPanel extends javax.swing.JPanel {

    private Server server;

    /**
     * Creates new form StartPanel
     */
    public StartPanel() {
        initComponents();
        stopServerBtn.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startServerBtn = new javax.swing.JButton();
        stopServerBtn = new javax.swing.JToggleButton();
        statusLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(600, 350));
        setMinimumSize(new java.awt.Dimension(600, 350));

        startServerBtn.setText("Start server");
        startServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerBtnActionPerformed(evt);
            }
        });

        stopServerBtn.setText("Stop server");
        stopServerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopServerBtnActionPerformed(evt);
            }
        });

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText("Status: Server stopped");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startServerBtn)
                        .addGap(18, 18, 18)
                        .addComponent(stopServerBtn)))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startServerBtn)
                    .addComponent(stopServerBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusLabel)
                .addContainerGap(152, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerBtnActionPerformed
        try {
            DBConnection.getInstance().connect();
            server = new Server();
            server.start();
            stopServerBtn.setEnabled(true);
            startServerBtn.setEnabled(false);
            statusLabel.setText("Status: Server running");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Connection with database failed!");
            ex.printStackTrace();
        }

    }//GEN-LAST:event_startServerBtnActionPerformed

    private void stopServerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopServerBtnActionPerformed
        if (server != null) {
            server.shutdown();
            stopServerBtn.setEnabled(false);
            startServerBtn.setEnabled(true);
            statusLabel.setText("Status: Server stopped");
        }
    }//GEN-LAST:event_stopServerBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton startServerBtn;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JToggleButton stopServerBtn;
    // End of variables declaration//GEN-END:variables
}
