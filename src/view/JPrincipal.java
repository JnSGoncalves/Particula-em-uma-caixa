/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerPrincipal;

/**
 *
 * @author jnsil
 */
public class JPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JPrincipal
     */
    public JPrincipal(ControllerPrincipal c) {
        initComponents();
        this.c = c;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btSimulacao = new javax.swing.JToggleButton();
        btInfo = new javax.swing.JToggleButton();
        btParametros = new javax.swing.JToggleButton();
        btProbabilidade = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Particula em uma Caixa");

        btSimulacao.setBackground(new java.awt.Color(204, 255, 255));
        btSimulacao.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btSimulacao.setForeground(new java.awt.Color(0, 0, 0));
        btSimulacao.setText("Simulação");
        btSimulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimulacaoActionPerformed(evt);
            }
        });

        btInfo.setBackground(new java.awt.Color(204, 255, 255));
        btInfo.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btInfo.setForeground(new java.awt.Color(0, 0, 0));
        btInfo.setText("Informações");

        btParametros.setBackground(new java.awt.Color(204, 255, 255));
        btParametros.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btParametros.setForeground(new java.awt.Color(0, 0, 0));
        btParametros.setText("Calculo de Parametros");
        btParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParametrosActionPerformed(evt);
            }
        });

        btProbabilidade.setBackground(new java.awt.Color(204, 255, 255));
        btProbabilidade.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btProbabilidade.setForeground(new java.awt.Color(0, 0, 0));
        btProbabilidade.setText("Calculo de Probabilidade");
        btProbabilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProbabilidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(195, 195, 195))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btProbabilidade)
                    .addComponent(btParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btProbabilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSimulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimulacaoActionPerformed
        c.openSimulacao();
    }//GEN-LAST:event_btSimulacaoActionPerformed

    private void btParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParametrosActionPerformed
        c.openParametros();
    }//GEN-LAST:event_btParametrosActionPerformed

    private void btProbabilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProbabilidadeActionPerformed
        c.openProbabilidade();
    }//GEN-LAST:event_btProbabilidadeActionPerformed

    
    ControllerPrincipal c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btInfo;
    private javax.swing.JToggleButton btParametros;
    private javax.swing.JToggleButton btProbabilidade;
    private javax.swing.JToggleButton btSimulacao;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
