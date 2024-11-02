/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.Parametros;

/**
 *
 * @author pedro
 */
public class Controller {
    private Parametros model;

    public Controller(Parametros model) {
        this.model = model;
    }

    public void calcular() {
        try {
            double constanteA = Double.parseDouble(model.getTxtA().getText());
            double constanteK = Double.parseDouble(model.getTxtK().getText());

            // Calculando L
            double L = model.calcularL(constanteA);
            model.setLarguraCaixa(L); // Atualizando o campo de largura da caixa

            // Calculando n
            double n = model.calcularN(L, constanteK);
            model.setNivelQuantico(n); // Atualizando o campo do nível quântico

            // Obtendo o valor de x
            double x = Double.parseDouble(model.getTxtXp().getText());

            // Calculando P(x)
            double P = model.calcularP(constanteA, constanteK, x, L);
            model.setProbabilidade(P); // Atualizando o campo da probabilidade
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
