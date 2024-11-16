package com.mycompany.peladaautomatica.pages;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mycompany.peladaautomatica.classes.Jogador;
import com.mycompany.peladaautomatica.exceptions.JogadorNaoEncontradoException;
import com.mycompany.peladaautomatica.exceptions.NotaInvalidaException;
import com.mycompany.peladaautomatica.service.DataBase;

public class MainScreen extends javax.swing.JFrame {

    public MainScreen() {
        initComponents();
        setLocationRelativeTo(null);
    }
                         
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        Button2Times = new javax.swing.JToggleButton();
        Button3Times = new javax.swing.JToggleButton();
        ButtonSortear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        convocados = new ArrayList<>();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Button2Times.setText("2 Times");
        Button2Times.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button2TimesActionPerformed(evt);
            }
        });

        Button3Times.setText("3 Times");
        Button3Times.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3TimesActionPerformed(evt);
            }
        });

        ButtonSortear.setBackground(new java.awt.Color(154, 205, 50));
        ButtonSortear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ButtonSortear.setForeground(new java.awt.Color(0, 0, 0));
        ButtonSortear.setText("Sortear");
        ButtonSortear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSortearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Button2Times, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button3Times, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(ButtonSortear, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSortear, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button3Times, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button2Times, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 48)); // NOI18N
        jLabel1.setText("Pelada Automática");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Insira a lista de participantes...\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void Button2TimesActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Button2Times.setBackground(Color.BLUE); 
        Button3Times.setBackground(Color.LIGHT_GRAY);
    }                                            

    private void Button3TimesActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Button3Times.setBackground(Color.BLUE);
        Button2Times.setBackground(Color.LIGHT_GRAY);
    }                                            

    private void ButtonSortearActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String participantes = jTextArea1.getText();
        String[] nomes = participantes.split("\\n");
    
        for (String nome : nomes) {
            if(nome == null) continue;
            nome = nome.toLowerCase();
            nome = nome.replace("-", "");
            nome = nome.trim();
            try{
                Jogador w = DataBase.getJogador(nome);
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
                Jogador w = new Jogador(nome, nota);
                DataBase.addJogador(nome, w);
                convocados.add(w);
                DataBase.updateData(nome, nota);
            }
        }
        
        DataBase.sorteio(convocados);
        DataBase.printTime();
        TeamsPage teams = new TeamsPage(3);
        teams.setVisible(true);
    }                                             

    
    public static void main(String args[]) {
        
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
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JToggleButton Button2Times;
    private javax.swing.JToggleButton Button3Times;
    private javax.swing.JButton ButtonSortear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private ArrayList<Jogador> convocados;
    // End of variables declaration                   
}
