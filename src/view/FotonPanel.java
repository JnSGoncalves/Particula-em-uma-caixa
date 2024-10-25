package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FotonPanel extends JPanel{
    private Image imagem;
    private int xImagem = -30;
    private int yImagem = -30;
    
    public FotonPanel(){
        try{
            Image original = ImageIO.read(getClass().getResourceAsStream("/view/images/azul-verde.png"));
            imagem = original.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(imagem, xImagem, yImagem, this);
    }

    public Image getImagem() {
        return imagem;
    }
    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getImageX() {
        return xImagem;
    }
    public void setImageX(int x) {
        this.xImagem = x;
        repaint();
    }

    public int getImageY() {
        return yImagem;
    }
    public void setImageY(int y) {
        this.yImagem = y;
        repaint();
    }
}
