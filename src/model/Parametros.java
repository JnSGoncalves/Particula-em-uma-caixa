/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.JTextField;

/**
 *
 * @author pedro
 */
public class Parametros {
    // Atributos dos campos de texto
    private JTextField txtA;
    private JTextField txtK;
    private JTextField txtLarguraCaixa;
    private JTextField txtNivelQuantico;
    private JTextField txtPropabilidade;
    private JTextField txtXp;

    // Construtor que recebe os campos de texto
    public Parametros(JTextField txtA, JTextField txtK, JTextField txtLarguraCaixa,
                      JTextField txtNivelQuantico, JTextField txtPropabilidade,
                      JTextField txtXp) {
        this.txtA = txtA;
        this.txtK = txtK;
        this.txtLarguraCaixa = txtLarguraCaixa;
        this.txtNivelQuantico = txtNivelQuantico;
        this.txtPropabilidade = txtPropabilidade;
        this.txtXp = txtXp;
    }

    // Método para calcular L
    public double calcularL(double constante) {
        return 2 / (constante * constante);
    }

    // Método para calcular n
    public double calcularN(double L, double constanteK) {
        return (constanteK * L) / Math.PI;
    }

    // Método para calcular Px
    public double calcularP(double constanteA, double constanteK, double x, double L) {
        return (constanteA * constanteA) * Math.pow(Math.sin(constanteK * x * L), 2);
    }
    

    
    public JTextField getTxtA() {
        return txtA;
    }

    public JTextField getTxtK() {
        return txtK;
    }

    public JTextField getTxtLarguraCaixa() {
        return txtLarguraCaixa;
    }

    public JTextField getTxtNivelQuantico() {
        return txtNivelQuantico;
    }

    public JTextField getTxtPropabilidade() {
        return txtPropabilidade;
    }

    public JTextField getTxtXp() {
        return txtXp;
    }

    // Métodos para atualizar os campos de texto com os resultados
    public void setLarguraCaixa(double L) {
        txtLarguraCaixa.setText(String.format("%.6e", L));
    }

    public void setNivelQuantico(double n) {
        txtNivelQuantico.setText(String.format("%.2f", n));
    }

    public void setProbabilidade(double P) {
        txtPropabilidade.setText(String.format("%.6f", P));
    }
}
