package model;

import java.awt.Point;
import java.util.ArrayList;

public class PontosFotonAni {
    private static final int numeroDePontos = 45; // Definindo o número de pontos como um atributo estático

    public static ArrayList<Point> obterPontosDaLinha(Point p1, Point p2) {
        ArrayList<Point> pontos = new ArrayList<>();

        int x1 = p1.x;
        int y1 = p1.y;
        int x2 = p2.x;
        int y2 = p2.y;

        // Gera os pontos com base no número de pontos definido na classe
        for (int i = 0; i < numeroDePontos; i++) {
            double t = (double) i / (numeroDePontos - 1); // Proporção entre 0 e 1
            
            // Calcula as coordenadas do ponto interpolado
            int x = (int) Math.round(x1 + t * (x2 - x1));
            int y = (int) Math.round(y1 + t * (y2 - y1));
            
            pontos.add(new Point(x, y)); // Adiciona o ponto à lista
        }

        return pontos; // Retorna a lista de pontos
    }
    
    public static int getNumeroDePontos(){
        return numeroDePontos;
    }
}

