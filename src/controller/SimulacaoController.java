package controller;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import model.PontosFotonAni;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.FuncaoOnda;
import model.Pontos;
import model.PontosPixel;
import view.JanelaSimulacao;
import view.OndaPanel;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import view.FotonPanel;

public class SimulacaoController {
    private final JanelaSimulacao view;
    private final FuncaoOnda funcao;
    private int ondaAtual;
    private int novaOnda;
    private int ondaAnterior;
    private final double L;
    private final int numPontos;
    private Timer timerAnimacao;
    private Timer timerOnda;
    private Timer timerFoton;
    private double tempo;
    
    private ArrayList<Point> pontosAniFoton1;
    private ArrayList<Point> pontosAniFoton2;
    private int pFotonAtual;
    
    private boolean aniFotonOn = false;
    private final int fps = 60;

    public SimulacaoController(JanelaSimulacao view) {
        this.view = view;
        this.funcao = new FuncaoOnda();
        this.L = funcao.getL();
        this.numPontos = funcao.getMaxPontos();
        tempo = 0;
        ondaAtual = 1;
    }
    
    public void stopSimulacao(){
        timerAnimacao.stop();
        timerOnda.stop();
        try{
            timerFoton.stop();
        }catch(Exception e){
        }
    }
  
    public void iniciarAnimacao() {
        tempo = 0;
        timerAnimacao = new Timer(1000 / fps, (ActionEvent e) -> {
            animacaoOnda();
            tempo += 2e-16;
        });
        timerAnimacao.start(); // Inicia o timer
        
        timerOnda = new Timer(3000, (ActionEvent e) -> {
            Random random = new Random();
            float ver = random.nextFloat();
            if(ver > 0.3){
                trocarN();
            }
        });
        timerOnda.start();
    }
    
    public void animacaoOnda(){
        Pontos pontos;
        pontos = funcao.calcularFuncaoOnda(ondaAtual, tempo);
        PontosPixel pontosPixel;
        JPanel panel = getPanel(ondaAtual);
        
        pontosPixel = convertToPixels(pontos, panel);
        
        desenharLinhas(panel, pontosPixel);
    }
    
    public void iniciarFoton(int jpFotonN){
        aniFotonOn = true;
        pFotonAtual = 0;
        
        setImageFoton(jpFotonN);
        
        if(jpFotonN == 1){
            getPontosAniFoton1();
        }else if(jpFotonN == 2){
            getPontosAniFoton2();
            JPanel panel = getPanel(ondaAtual);   
            ((OndaPanel) panel).limpar();
            ondaAtual = novaOnda;
        }
        timerFoton = new Timer(1000 / PontosFotonAni.getNumeroDePontos(), (ActionEvent e) -> {
            if(aniFotonOn){
                if(jpFotonN == 1){
                    animacaoFoton1();
                }else if(jpFotonN == 2){
                    animacaoFoton2();
                }
                pFotonAtual += 1;
                if(pFotonAtual == PontosFotonAni.getNumeroDePontos()){
                    aniFotonOn = false;
                    if(jpFotonN == 1){
                        JPanel panel = getPanel(ondaAtual);   
                        ((OndaPanel) panel).limpar();
                        ondaAtual = novaOnda;
                    }
                }
            }else{
                timerFoton.stop();
            }
        });
        timerFoton.start();
    }
    
    public void setImageFoton(int jpFotonN){
        Image imagem = null;
        String localImage = null;
        if((ondaAtual == 4 || novaOnda == 4) && (ondaAtual == 2|| novaOnda == 2)){
            localImage = "/view/images/azul-verde.png";
        }else if(
                ((ondaAtual == 5 || novaOnda == 5) && ((ondaAtual == 3|| novaOnda == 3) ||
                (ondaAtual == 4|| novaOnda == 4))) ||
                ((ondaAtual == 4 || novaOnda == 4) && (ondaAtual == 3|| novaOnda == 3))
                ){
            localImage = "/view/images/infravermelho.png";
        }else if(
                (ondaAtual == 1 || novaOnda == 1) && 
                ((ondaAtual == 3|| novaOnda == 3) ||
                (ondaAtual == 2|| novaOnda == 2) ||
                (ondaAtual == 4|| novaOnda == 4) ||
                (ondaAtual == 5|| novaOnda == 5))){
            localImage = "/view/images/ultravioleta.png";
        }else if((ondaAtual == 3 || novaOnda == 3) && (ondaAtual == 2|| novaOnda == 2)){
            localImage = "/view/images/vermelho.png";
        }else if((ondaAtual == 5 || novaOnda == 5) && (ondaAtual == 2|| novaOnda == 2)){
            localImage = "/view/images/violeta.png";
        }
        try{
            Image original = ImageIO.read(getClass().getResourceAsStream(localImage));
            imagem = original.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        }catch(IOException e) {
            e.printStackTrace();
        }
        JPanel panel;
        if(jpFotonN == 1){
            panel = view.getJpAni1();
        }else{
            panel = view.getJpAni2();
        }
        ((FotonPanel) panel).setImagem(imagem);
    }
    
    public void getPontosAniFoton1(){
        JPanel panel = getPanel(ondaAnterior);
        
        Point posicaoPanel = SwingUtilities.convertPoint(panel, new Point(0, 0), view);
        posicaoPanel.y += 20;
        
        Point pontoAniPanel = new Point(0, (view.getJpAni1().getHeight() / 2));
        
        
         pontosAniFoton1 = PontosFotonAni.obterPontosDaLinha(pontoAniPanel, posicaoPanel);
    }
    
    public void animacaoFoton1(){
       JPanel panel = view.getJpAni1();
        ((FotonPanel) panel).setImageX(pontosAniFoton1.get(pFotonAtual).x);
        ((FotonPanel) panel).setImageY(pontosAniFoton1.get(pFotonAtual).y);
    }
        
    public void getPontosAniFoton2(){
        JPanel panel = getPanel(ondaAnterior);
        
        Point posicaoPanel = SwingUtilities.convertPoint(panel, new Point(0, 0), view);
        posicaoPanel.y += 20;
        posicaoPanel.x = 0;
        
        Point pontoAniPanel = new Point(view.getJpAni2().getWidth() + 10, (view.getJpAni2().getHeight() / 2));
        
        
         pontosAniFoton2 = PontosFotonAni.obterPontosDaLinha(posicaoPanel, pontoAniPanel);
    }
    
    public void animacaoFoton2(){
        JPanel panel = view.getJpAni2();
        ((FotonPanel) panel).setImageX(pontosAniFoton2.get(pFotonAtual).x);
        ((FotonPanel) panel).setImageY(pontosAniFoton2.get(pFotonAtual).y);
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

    private JPanel getPanel(int n){
        JPanel panel = null;
        switch (n) {
            case 1 -> panel = view.getJpOnda5();
            case 2 -> panel = view.getJpOnda4();
            case 3 -> panel = view.getJpOnda3();
            case 4 -> panel = view.getJpOnda2();
            case 5 -> panel = view.getJpOnda1();
        }
        return panel;
    }
    
    public void trocarN() {        
        Random random = new Random();
        do{
            novaOnda = random.nextInt(5) + 1;
        }while(novaOnda == ondaAtual);
        ondaAnterior = ondaAtual;
        
        if (novaOnda > ondaAnterior){
            iniciarFoton(1);
        }else if(novaOnda < ondaAnterior){
            iniciarFoton(2);
        }
    }
}
