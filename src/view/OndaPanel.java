package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class OndaPanel extends JPanel{
    private final List<Point[]> linhas = new ArrayList<>();
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.RED);
        for(Point[] linha : linhas){
            for (int i = 0; i < linha.length - 1; i ++){
                g.drawLine(linha[i].x, linha[i].y, linha[i + 1].x, linha[i + 1].y);
            }
        }
    }
    
    public void adicionarLinha(Point[] pontos){
        linhas.add(pontos);
        repaint();
    }
    
    public void limpar(){
        linhas.clear();
        repaint();
    }
}
