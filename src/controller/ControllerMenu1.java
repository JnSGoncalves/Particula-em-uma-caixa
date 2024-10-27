package controller;
import model.ConfinarParticula;
import view.DadosParticula;
import view.Menu1;


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
        double proInicial = Double.parseDouble(proInicialStr);
        String proFinalStr= menu1.getTextProbabilidadeB().getText();
        double proFinal = Double.parseDouble(proFinalStr);
        double mProton = 1.67e-27;
        
        ConfinarParticula particula = new ConfinarParticula(nInicial, largura,
                                           mProton, nFinal);
        
        // Definindo a função de onda de cada nível
        String funcaoOndaNi = particula.funcaoOnda(largura, nInicial);
        String funcaoOndaNf = particula.funcaoOnda(largura, nFinal);
        dadosParticula.getJlFuncaoOndaNi().setText(funcaoOndaNi);
        dadosParticula.getJlFuncaoOndaNf().setText(funcaoOndaNf);
        
        //Definindo as energias em j e em Ev de cada nível.
        String energiaNiJStr = particula.energiaJ(nInicial, mProton,largura);
        String energiaNfJStr = particula.energiaJ(nFinal, mProton, largura);
        String energiaNiEvStr = particula.energiaEv(nInicial, mProton, largura);
        String energiaNfEvStr = particula.energiaEv(nFinal, mProton, largura);
        //Separando valores de nergia em J e Ev para usar em outras contas.
        double enegiaNiJ = Double.parseDouble(energiaNiJStr);
        double energiaNfJ = Double.parseDouble(energiaNfJStr);
        double enegiaNiEv = Double.parseDouble(energiaNiEvStr);
        double energiaNfEv = Double.parseDouble(energiaNfEvStr);
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
                                        (mProton, velocidadeNf);
        dadosParticula.getJlCompriBroNi().setText(compriBroNiStr);
        dadosParticula.getJlCompriBroNf().setText(compriBroNfStr);
        
        //Definindo comprimento de onda, frequencia  e energia do foton emitido.
        String energiaFotonEvStr = particula.energiaFotonAbsorvido(energiaNfEv,
                                                                enegiaNiEv);
        String energiaFotonJStr = particula.energiaFotonAbsorvido(energiaNfJ,
                                                                enegiaNiJ);
        // passando para double valores que vou utilizar.
        double energiaFotonEv = Double.parseDouble(energiaFotonEvStr);
        double energiaFotonJ = Double.parseDouble(energiaFotonJStr);
        String frequenciaStr = particula.frequenciaFoton(energiaFotonJ);
        String comprimento = particula.comprimentoDeOndaFoton(energiaFotonEv);
        dadosParticula.getJlFrequenciaOnda().setText(frequenciaStr);
        dadosParticula.getJlEnergiaFoton().setText(energiaFotonEvStr);
        dadosParticula.getJlCompriFoton().setText(comprimento);
        
        //Calculando a probabilidade em cada nível
        Double ProbaNin = particula.calcularProbabilidade(proInicial, proFinal,
                                                          nInicial);
        String ProbaNinStr = String.valueOf(ProbaNin);
        Double ProbaNfi = particula.calcularProbabilidade(proInicial, proFinal,
                                                          nFinal);
        String ProbaNfiStr = String.valueOf(ProbaNfi);
        dadosParticula.getJlProNi().setText(ProbaNinStr);
        dadosParticula.getJlProNf().setText(ProbaNfiStr);
        
    
        
        menu1.setVisible(false);
        dadosParticula.setVisible(true);  
        
    }
    
    public void dadosEletron(){
        String nInicialStr = menu1.getTextNInicial().getText();
        double nInicial = Double.parseDouble(nInicialStr);
        String nFinalStr = menu1.getTextNFinal().getText();
        double nFinal = Double.parseDouble(nFinalStr);
        String larguraStr = menu1.getTextLargura().getText();
        double largura = Double.parseDouble(larguraStr);
        String proInicialStr = menu1.getTextProbabiliadeA().getText();
        double proInicial = Double.parseDouble(proInicialStr);
        String proFinalStr= menu1.getTextProbabilidadeB().getText();
        double proFinal = Double.parseDouble(proFinalStr);
        double mEletron = 9.10938356e-31; 
        
        ConfinarParticula particula = new ConfinarParticula(nInicial, largura,
                                           mEletron, nFinal);
        
        // Definindo a função de onda de cada nível
        String funcaoOndaNi = particula.funcaoOnda(largura, nInicial);
        String funcaoOndaNf = particula.funcaoOnda(largura, nFinal);
        dadosParticula.getJlFuncaoOndaNi().setText(funcaoOndaNi);
        dadosParticula.getJlFuncaoOndaNf().setText(funcaoOndaNf);
        
        //Definindo as energias em j e em Ev de cada nível.
        String energiaNiJStr = particula.energiaJ(nInicial, mEletron,largura);
        String energiaNfJStr = particula.energiaJ(nFinal, mEletron, largura);
        String energiaNiEvStr = particula.energiaEv(nInicial, mEletron, largura);
        String energiaNfEvStr = particula.energiaEv(nFinal, mEletron, largura);
        //Separando valores de nergia em J e Ev para usar em outras contas.
        double enegiaNiJ = Double.parseDouble(energiaNiJStr);
        double energiaNfJ = Double.parseDouble(energiaNfJStr);
        double enegiaNiEv = Double.parseDouble(energiaNiEvStr);
        double energiaNfEv = Double.parseDouble(energiaNfEvStr);
        dadosParticula.getJlEnergiaNiJ().setText(energiaNiJStr );
        dadosParticula.getJlEnergiaNfJ().setText(energiaNfJStr);
        dadosParticula.getJlEnergiaNiEv().setText(energiaNiEvStr);
        dadosParticula.getJlEnergiaNfEv().setText(energiaNfEvStr);
        
        
        //Definindo a velocidade da partícula em cada nível
        String velocidadeNiStr = particula.velocidadeProton(enegiaNiJ, mEletron);
        String velocidadeNfStr = particula.velocidadeProton(energiaNfJ, mEletron);
        double velocidadeNi = Double.parseDouble(velocidadeNiStr);
        double velocidadeNf = Double.parseDouble(velocidadeNfStr);
        dadosParticula.getJlVeloNi().setText(velocidadeNiStr);
        dadosParticula.getJlVeloNf().setText(velocidadeNfStr);
        
        //Definindo o comprimento de onda de Broglie de cada nível
        String compriBroNiStr = particula.comprimentoDeBroglie
                                        (mEletron, velocidadeNi);
        String compriBroNfStr = particula.comprimentoDeBroglie
                                        (mEletron, velocidadeNf);
        dadosParticula.getJlCompriBroNi().setText(compriBroNiStr);
        dadosParticula.getJlCompriBroNf().setText(compriBroNfStr);
        
        //Definindo comprimento de onda, frequencia  e energia do foton emitido.
        String energiaFotonEvStr = particula.energiaFotonAbsorvido(energiaNfEv,
                                                                enegiaNiEv);
        String energiaFotonJStr = particula.energiaFotonAbsorvido(energiaNfJ,
                                                                enegiaNiJ);
        // passando para double valores que vou utilizar.
        double energiaFotonEv = Double.parseDouble(energiaFotonEvStr);
        double energiaFotonJ = Double.parseDouble(energiaFotonJStr);
        String frequenciaStr = particula.frequenciaFoton(energiaFotonJ);
        String comprimento = particula.comprimentoDeOndaFoton(energiaFotonEv);
        dadosParticula.getJlFrequenciaOnda().setText(frequenciaStr);
        dadosParticula.getJlEnergiaFoton().setText(energiaFotonEvStr);
        dadosParticula.getJlCompriFoton().setText(comprimento);
        
        //Calculando a probabilidade em cada nível
        Double ProbaNin = particula.calcularProbabilidade(proInicial, proFinal,
                                                          nInicial);
        String ProbaNinStr = String.valueOf(ProbaNin);
        Double ProbaNfi = particula.calcularProbabilidade(proInicial, proFinal,
                                                          nFinal);
        String ProbaNfiStr = String.valueOf(ProbaNfi);
        dadosParticula.getJlProNi().setText(ProbaNinStr);
        dadosParticula.getJlProNf().setText(ProbaNfiStr);
        
    
        
        menu1.setVisible(false);
        dadosParticula.setVisible(true);  
        
    }
    
    
    
}
