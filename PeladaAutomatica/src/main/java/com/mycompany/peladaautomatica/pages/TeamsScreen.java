/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.peladaautomatica.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

import com.mycompany.peladaautomatica.classes.Jogador;
import com.mycompany.peladaautomatica.service.DataBase;

/**
 *
 * @author joaozin
 */
public class TeamsScreen extends javax.swing.JFrame {

    /**
     * Creates new form TeamsScreen
     */
    public TeamsScreen(int n) {
        initComponents(n);
        setLocationRelativeTo(null);
    }

    private void initComponents(int n) {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtBranco = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPreto = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAzul = new javax.swing.JTextPane();
        lblBranco = new javax.swing.JLabel();
        lblPreto = new javax.swing.JLabel();
        lblAzul = new javax.swing.JLabel();
        btnCopy = new javax.swing.JButton();
        wppText = "";

        txtBranco.setEditable(false);
        txtPreto.setEditable(false);
        txtAzul.setEditable(false);

        txtBranco.setFont(new java.awt.Font("Liberation Sans", 2, 15)); // NOI18N
        jScrollPane1.setViewportView(txtBranco);

        txtPreto.setFont(new java.awt.Font("Liberation Sans", 2, 15)); // NOI18N
        jScrollPane2.setViewportView(txtPreto);

        txtAzul.setFont(new java.awt.Font("Liberation Sans", 2, 15)); // NOI18N
        jScrollPane3.setViewportView(txtAzul);

        lblBranco.setFont(new java.awt.Font("Dhurjati", 0, 36)); // NOI18N
        lblBranco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBranco.setText("BRANCO");

        lblPreto.setFont(new java.awt.Font("Dhurjati", 0, 36)); // NOI18N
        lblPreto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPreto.setText("PRETO");

        lblAzul.setFont(new java.awt.Font("Dhurjati", 0, 36)); // NOI18N
        lblAzul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAzul.setText("AZUL");

        String equipe = "";
        for(int i=0; i<n; i++){
            if(i == 0) wppText += "Branco: \n";
            else if(i == 1) wppText += "Preto: \n";
            else wppText += "Azul: \n";

            ArrayList<Jogador> time = DataBase.times[i].getJogadores();
            for(Jogador w : time){
                String nome = w.getNome();
                equipe += "- " + nome + '\n';
                wppText += "- " + nome + '\n';
            }
            equipe += '\n';
            wppText += '\n';
            
            if(i == 0) txtBranco.setText(equipe);
            else if(i == 1) txtPreto.setText(equipe);
            else txtAzul.setText(equipe);

            equipe = "";
        }
        
        btnCopy.setBackground(new java.awt.Color(204, 204, 204));
        btnCopy.setFont(new java.awt.Font("Dhurjati", 1, 48)); // NOI18N
        btnCopy.setText("COPY");
        btnCopy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StringSelection stringSelection = new StringSelection(wppText);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblBranco, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(lblPreto, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(lblAzul, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBranco)
                    .addComponent(lblPreto)
                    .addComponent(lblAzul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TeamsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeamsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeamsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeamsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeamsScreen(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopy;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAzul;
    private javax.swing.JLabel lblBranco;
    private javax.swing.JLabel lblPreto;
    private javax.swing.JTextPane txtAzul;
    private javax.swing.JTextPane txtBranco;
    private javax.swing.JTextPane txtPreto;
    private String wppText;
    // End of variables declaration//GEN-END:variables
}
