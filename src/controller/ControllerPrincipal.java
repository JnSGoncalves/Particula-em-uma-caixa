package controller;

import view.Entrada;
import view.Informacoes;
import view.JPrincipal;
import view.JanelaSimulacao;
import view.Menu1;

public class ControllerPrincipal {
    JPrincipal view;
    JanelaSimulacao simulacao;
    Menu1 probabilidade;
    Entrada parametros;    
    Informacoes informacoes;

    public ControllerPrincipal() {
        view = new JPrincipal(this);
        view.setVisible(true);
        
        simulacao = new JanelaSimulacao();
        probabilidade = new Menu1();
        parametros = new Entrada();
        informacoes = new Informacoes();
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
    
    public void openInformacoes(){
        informacoes.setVisible(true);
    }
}
