package model;

import javax.swing.*;

public class PixelConverter {
    private double maxX = 1e-9; // Valor máximo de x
    private double maxY = (Math.sqrt(2 / 1e-9) + Math.sqrt(2 / 1e-9)); // Valor máximo de y

    // Método para converter x em pixels, considerando o JPanel
    public int convertXToPixels(JPanel panel, double x) {
        // Garantir que x esteja dentro do intervalo [0, maxX]
        if (x < 0) x = 0;
        if (x > maxX) x = maxX;

        // Calcular a posição em pixels considerando a posição e o tamanho do JPanel
        return (int) ((x / maxX) * panel.getWidth()) + panel.getX();
    }

    // Método para converter y em pixels, considerando o JPanel
    public int convertYToPixels(JPanel panel, double y) {
        // Garantir que y esteja dentro do intervalo [0, maxY]
        if (y < 0) y = 0;
        if (y > maxY) y = maxY;

        // Calcular a posição em pixels considerando a posição e o tamanho do JPanel
        return (int) ((y / maxY) * panel.getHeight()) + panel.getY();
    }
}
