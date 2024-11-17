/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.peladaautomatica.pages;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mycompany.peladaautomatica.classes.Jogador;
import com.mycompany.peladaautomatica.exceptions.JogadorNaoEncontradoException;
import com.mycompany.peladaautomatica.exceptions.NotaInvalidaException;
import com.mycompany.peladaautomatica.service.DataBase;

/**
 *
 * @author joaozin
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public MainScreen() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        tglTimes = new javax.swing.JButton();
        lblTimes = new javax.swing.JLabel();
        btnSortear = new javax.swing.JButton();
        lblLista = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        convocados = new ArrayList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI", 1, 48)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblTitle.setText("Pelada Automática");

        tglTimes.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        tglTimes.setText("2");
        tglTimes.setBackground(new java.awt.Color(100, 149, 237)); 
        tglTimes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tglTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglTimesActionPerformed(evt);
            }
        });
        

        lblTimes.setFont(new java.awt.Font("Ubuntu Sans Mono", 1, 18)); // NOI18N
        lblTimes.setText("TIMES");

        btnSortear.setBackground(new java.awt.Color(154, 205, 50));
        btnSortear.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnSortear.setText("Sortear");
        btnSortear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSortear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortearActionPerformed(evt);
            }
        });

        lblLista.setFont(new java.awt.Font("Ubuntu Sans", 1, 15)); // NOI18N
        lblLista.setText("Lista de participantes");

        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLista)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(tglTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblTimes)
                                        .addGap(108, 108, 108)))
                                .addComponent(btnSortear, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSortear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tglTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(lblLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSortearActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String participantes = jTextArea1.getText();
        String[] nomes = participantes.split("\\n");
    
        for (String nome : nomes) {
            if(nome == null) continue;
            String aux[] = nome.split("-"); //aux 1 = nome do jogador após o hifen (entrada normalmente ou é "1- joaoz" ou "- joaoz")
            if(aux.length == 1) continue;
            aux[1] = aux[1].toLowerCase();
            aux[1] = aux[1].replace("-", "");
            aux[1] = aux[1].trim();
            try{
                Jogador w = DataBase.getJogador(aux[1]);
                convocados.add(w);
            }catch(JogadorNaoEncontradoException e){
                boolean notaValida = false;
                String snota = "";
                while(!notaValida){
                    snota = JOptionPane.showInputDialog(this, e.getMessage());
                    if(snota == null) return;
                    try{
                        notaValida = DataBase.notaValida(snota);
                    }catch(NotaInvalidaException n){
                        JOptionPane.showMessageDialog(this, n.getMessage(), "Nota Inválida", JOptionPane.ERROR_MESSAGE);
                    }
                }
                int nota = Integer.parseInt(snota);
                Jogador w = new Jogador(aux[1], nota);
                DataBase.addJogador(aux[1], w);
                convocados.add(w);
                DataBase.updateData(aux[1], nota);
            }
        }
        
        int n = Integer.parseInt(tglTimes.getText());
        DataBase.sorteio(convocados, n);
        DataBase.printTime(n);
        TeamsScreen teams = new TeamsScreen(n);
        teams.setVisible(true);
        convocados = new ArrayList<>();
    }

    private void tglTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglTimesActionPerformed
        if(tglTimes.getText().equals("2")){
            tglTimes.setBackground(new java.awt.Color(255, 102, 102)); // Vermelho claro
            tglTimes.setText("3");
        }else{
            tglTimes.setBackground(new java.awt.Color(100, 149, 237)); // Azul claro
            tglTimes.setText("2");
        }
    }//GEN-LAST:event_tglTimesActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSortear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblLista;
    private javax.swing.JLabel lblTimes;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton tglTimes;
    private ArrayList<Jogador> convocados;
    // End of variables declaration//GEN-END:variables
}
