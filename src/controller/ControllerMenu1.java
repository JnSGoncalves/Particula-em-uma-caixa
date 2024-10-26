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

    public ControllerMenu1(Menu1 menu1){
        this.menu1 = menu1;
        this.dadosParticula = new DadosParticula();
    }
    
    
    
    public void dadosProton(){
        String nInicialStr = menu1.getTextNInicial().getText();
        double nInicial = Double.parseDouble(nInicialStr);
        String nFinalStr = menu1.getTextNFinal().getText();
        double nFinal = Double.parseDouble(nFinalStr);
        String larguraStr = menu1.getTextLargura().getText();
        double largura = Double.parseDouble(larguraStr);
        String proInicialStr = menu1.getTextProbabiliadeA().getText();
        double ProInicial = Double.parseDouble(proInicialStr);
        String proFinalStr= menu1.getTextProbabilidadeB().getText();
        double proFinal = Double.parseDouble(proFinalStr);
        double mProton = 1.67e-27;
        
        ConfinarParticula particula = new ConfinarParticula(nInicial, largura,
                                           mProton, nFinal);
        
        // Definindo a funç
        String funcaoOndaNi = particula.funcaoOnda(largura, nInicial);
        String funcaoOndaNf = particula.funcaoOnda(largura, nFinal);
        dadosParticula.getJlFuncaoOndaNi().setText(funcaoOndaNi);
        dadosParticula.getJlFuncaoOndaNf().setText(funcaoOndaNf);
        
        //Definindo as energias em j e em Ev de cada nível.
        String energiaNiJStr = particula.energiaJ(nInicial, mProton,largura);
        String energiaNfJStr = particula.energiaJ(nFinal, mProton, largura);
        String energiaNiEvStr = particula.energiaEv(nInicial, mProton, largura);
        String energiaNfEvStr = particula.energiaEv(nFinal, mProton, largura);
        //Separando valores de nergia em J para usar em outras contas.
        double enegiaNiJ = Double.parseDouble(energiaNiJStr);
        double energiaNfJ = Double.parseDouble(energiaNfJStr);
        dadosParticula.getJlEnergiaNiJ().setText(energiaNiJStr );
        dadosParticula.getJlEnergiaNfJ().setText(energiaNfJStr);
        dadosParticula.getJlEnergiaNiEv().setText(energiaNiEvStr);
        dadosParticula.getJlEnergiaNfEv().setText(energiaNfEvStr);
        
        //Definindo a velocidade da partícula em cada nível
        String velocidadeNiStr = particula.velocidadeProton(enegiaNiJ, mProton);
        String velocidadeNfStr = particula.velocidadeProton(energiaNfJ, mProton);
        double velocidadeNi = Double.parseDouble(velocidadeNiStr);
        double velocidadeNf = Double.parseDouble(velocidadeNfStr);
        dadosParticula.getJlVeloNi().setText(velocidadeNiStr);
        dadosParticula.getJlVeloNf().setText(velocidadeNfStr);
        
        //Definindo o comprimento de onda de Broglie de cada nível
        String compriBroNiStr = particula.comprimentoDeBroglie
                                        (mProton, velocidadeNi);
        String compriBroNfStr = particula.comprimentoDeBroglie
                                        (mProton, velocidadeNi);
        dadosParticula.getJlCompriBroNi().setText(compriBroNiStr);
        dadosParticula.getJlCompriBroNf().setText(compriBroNfStr);
        
        
        menu1.setVisible(false);
        dadosParticula.setVisible(true);  
        
    }
    
    
}
