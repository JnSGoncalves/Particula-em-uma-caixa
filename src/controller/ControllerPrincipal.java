package controller;

import view.Entrada;
import view.JPrincipal;
import view.JanelaSimulacao;
import view.Menu1;

public class ControllerPrincipal {
    JPrincipal view;
    JanelaSimulacao simulacao;
    Menu1 probabilidade;
    Entrada parametros;    

    public ControllerPrincipal() {
        view = new JPrincipal(this);
        view.setVisible(true);
        
        simulacao = new JanelaSimulacao();
        probabilidade = new Menu1();
        parametros = new Entrada();
//        parametros.setVisible(false);
    }
    
    public void openSimulacao(){
        simulacao.setVisible(true);
    }
    
    public void openProbabilidade(){
        probabilidade.setVisible(true);
    }
    
    public void openParametros(){
        parametros.setVisible(true);
    }
}
