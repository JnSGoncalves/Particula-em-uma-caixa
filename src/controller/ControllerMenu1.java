package controller;
import model.ConfinarParticula;
import view.DadosParticula;
import view.Menu1;
/**
 *
 * @author wallace
 */
public class ControllerMenu1 {
    private ConfinarParticula particula;
    private DadosParticula dadosParticula;
    private Menu1 menu1;

    public ControllerMenu1(ConfinarParticula particula, 
                           DadosParticula dadosParticula, Menu1 menu1){
        this.particula = particula;
        this.dadosParticula = dadosParticula;
        this.menu1 = menu1;
    }
    
    public void ColetarDados(){
        
    }
    
    
}
