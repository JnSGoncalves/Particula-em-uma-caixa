package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.FuncaoOnda;
import model.Pontos;
import model.PontosPixel;
import view.JanelaSimulacao;
import view.OndaPanel;

public class SimulacaoController {
    private final JanelaSimulacao view;
    private final FuncaoOnda funcao;
    private int ondaAtual;
    private final double L;
    private final int numPontos;
    private Timer timer;
    private double tempo;
    
    private final int fps = 60;

    public SimulacaoController(JanelaSimulacao view) {
        this.view = view;
        this.funcao = new FuncaoOnda();
        this.L = funcao.getL();
        this.numPontos = funcao.getMaxPontos();
        tempo = 0;
        ondaAtual = 1;
    }
  
    public void iniciarAnimacao() {
        timer = new Timer(1000 / fps, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animacaoOnda();
                tempo += 3e-16;
            }
        });
        timer.start(); // Inicia o timer
    }
    
    public void animacaoOnda(){
        Pontos pontos;
        pontos = funcao.calcularFuncaoOnda(ondaAtual, tempo);
        PontosPixel pontosPixel;
        JPanel panel = null;
        
        switch (ondaAtual) {
            case 1 -> panel = view.getJpOnda1();
            case 2 -> panel = view.getJpOnda2();
            case 3 -> panel = view.getJpOnda3();
            case 4 -> panel = view.getJpOnda4();
            case 5 -> panel = view.getJpOnda5();
        }
        
        pontosPixel = convertToPixels(pontos, panel);
        
        desenharLinhas(panel, pontosPixel);
    }
    
    public void desenharLinhas(JPanel panel, PontosPixel pontosPixel){
        int[] pontosX = pontosPixel.getX();
        int[] pontosY= pontosPixel.getY();
        
        Point[] pontos = new Point[pontosX.length];
        for(int i = 0; i < pontosX.length; i++){
            pontos[i] = new Point(pontosX[i], pontosY[i]);
        }
        
        ((OndaPanel) panel).limpar();
        ((OndaPanel) panel).adicionarLinha(pontos);
    }
    
    public PontosPixel convertToPixels(Pontos pontos, JPanel panel) {
        // Define os limites de x e y
        double xMin = 0;
        double xMax = L;
        double yMin = -Math.sqrt(2 / L);
        double yMax = Math.sqrt(2 / L);

        // Obtém as coordenadas x e y dos pontos
        double[] pontosX = pontos.getX();
        double[] pontosY = pontos.getY();

        // Cria arrays para armazenar as coordenadas convertidas para pixels
        int[] pontosXPixel = new int[numPontos];
        int[] pontosYPixel = new int[numPontos];

        // Obtém as dimensões do painel
        int width = panel.getWidth();
        int height = panel.getHeight();

        // Converte os pontos para coordenadas de pixels
        for (int i = 0; i < numPontos; i++) {
            // Mapeia as coordenadas x para a largura do painel
            pontosXPixel[i] = (int) Math.round((pontosX[i] - xMin) / (xMax - xMin) * width);
            // Mapeia as coordenadas y para a altura do painel, centralizando o eixo y = 0 no meio do painel
            pontosYPixel[i] = (int) (30 + Math.round(height / 2 - ((pontosY[i] - yMin) / (yMax - yMin)) * (height / 2)));
        }

        return new PontosPixel(pontosXPixel, pontosYPixel);
    }

    public void trocarN() {
        if(ondaAtual != 5){
            ondaAtual++;
            tempo = 0;
        }else{
            ondaAtual = 1;
        }
    }
}
