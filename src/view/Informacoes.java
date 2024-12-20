/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package view;

/**
 *
 * @author pedro
 */
public class Informacoes extends javax.swing.JFrame {

    /** Creates new form Informacoes */
    public Informacoes() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMAÇÕES");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Neste projeto, o usuário explora conceitos de mecânica quântica por meio de simulações e cálculos interativos. Com quatro \nopções principais, é possível acessar informações detalhadas, visualizar formas de onda, calcular parâmetros e \nprobabilidades para partículas confinadas.\n\nInformações: direciona o usuário a uma tela com uma explicação detalhada do projeto, abordando os conceitos \nfundamentais e os objetivos do estudo.\n\nSimulação: apresenta uma simulação interativa das formas de onda de um elétron em diferentes níveis de energia, \nilustrando as mudanças de níveis de excitação devido à absorção e emissão de fótons.\n\nCálculo de Parâmetros: abre uma tela onde o usuário insere dados específicos e escolhe o tipo de partícula \na ser confinada — próton ou elétron. A partir dessas entradas, os parâmetros necessários serão calculados.\n\nCálculo de Probabilidade: direciona o usuário a uma interface para fornecer dados detalhados, divididos em duas partes:\n\nDados da Caixa: entrada dos valores da largura da caixa, do número quântico inicial (N inicial) e do número quântico final \n(N final).\n\nProbabilidade: entrada dos valores para A e B.\n\nApós fornecer essas informações, o usuário escolhe a ação desejada entre as opções: confinar elétron, confinar próton ou\nvisualizar gráficos, utilizando os botões correspondentes.\n\nEssas funcionalidades garantem uma experiência interativa e educativa, permitindo ao usuário explorar conceitos de\nmecânica quântica e simulações práticas.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */ 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
