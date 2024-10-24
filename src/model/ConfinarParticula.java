package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;


public class ConfinarParticula {
    private double hJaule = 6.62607015 * Math.pow(10, -34); // J.s
    private double hEv = 4.1356677 * Math.pow(10, -15);   // eV.s
    private double c = 3.0 * Math.pow(10, 8);        // Velocidade da luz (m/s)
    private double veloEletron =  2.187 * Math.pow(10, 6);
    private double veloProton = 9.57 * Math.pow(10, 3);
    private DecimalFormat df;
    private double nInicial, l, m, nFinal;

    // Construtor Parametrizado
    public ConfinarParticula(double nInicial, double l, double m, double nFinal)
    {
        this.nInicial = nInicial;
        this.l = l;
        this.m = m;
        this.nFinal = nFinal;
        df = new DecimalFormat("0.###E0", 
                               DecimalFormatSymbols.getInstance(Locale.US));
    }

    public double getM() {
        return m;
    }

    public double getL() {
        return l;
    }

    public double getnInicial() {
        return nInicial;
    }

    public double getnFinal() {
        return nFinal;
    }

    public void setnInicial(double nInicial) {
        this.nInicial = nInicial;
    }

    public void setnFinal(double nFinal) {
        this.nFinal = nFinal;
    }
    
    public void setL(double l) {
        this.l = l;
    }

    public void setM(double m) {
        this.m = m;
    }

    // Método que calcula a função de onda
    public String funcaoOnda(double l, double n) {
        double raiz = Math.sqrt(2 / l);
        double sen = (n * Math.PI) / l;

        String raizFormatada = df.format(raiz);
        String senFormatado = df.format(sen);

        return raizFormatada + " sin(" + senFormatado + " x)";
    }

    public String energiaJ(double n, double m, double l) {
        double enJ = (Math.pow(n, 2) * Math.pow(hJaule, 2)) / 
                     (8 * m * Math.pow(l, 2));
        return df.format(enJ);
    }

    public String energiaEv(double n, double m, double l) {
        double enJ = (Math.pow(n, 2) * Math.pow(hJaule, 2)) / 
                     (8 * m * Math.pow(l, 2)); // Energia em joules
        double enEv = enJ / 1.60218e-19;  // Conversão de joules para eV
        return df.format(enEv);
    }

    // Método que calcula a velocidade da partícula no nível quântico
    public String velocidadeProton(double e, double m) {
        double v = Math.sqrt((2 * e)/m);
        return df.format(v);
    }
    

    // Método que calcula o comprimento de onda de De Broglie
    public String comprimentoDeBroglie(double m, double velocidade) {
        double lambda = hJaule / (m * velocidade);
        // Comprimento de onda de De Broglie λ_n = h / p_n
        return df.format(lambda);
    }

    // Método que calcula a energia do fóton na transição entre dois níveis
    public String energiaFotonAbsorvido(double ef, double ei) {
        double eFoton = Math.abs(ef - ei); // Energia do fóton emitido/absorvido
        double lambdaFoton = hJaule * c / eFoton;
        return df.format(eFoton);
    }
    


    // Método que calcula a frequência do fóton
    public String frequenciaFoton(double efoton) {
        double frequencia = efoton / hJaule; // f = E / h
        return df.format(frequencia);
    }

    // Método que calcula o comprimento de onda do fóton
    public String comprimentoDeOndaFoton(double efoton) {
        double lambdaFoton = (hEv * c) / efoton ; // λ = c / f
        return df.format(lambdaFoton);
    }

    // Método que calcula a probabilidade de encontrar a partícula entre a e b
    public double calcularProbabilidade(double a, double b, double n) {
        double probabilidade = (1.0 / l) * ((b - a) 
                            - (l / (2 * n * Math.PI)) * 
                            (Math.sin((2 * n * Math.PI * b) / l) 
                            - Math.sin((2 * n * Math.PI * a) / l)));
        return probabilidade * 100; // Multiplica por 100 para porcentagem
    }
    
    
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//
//        // Entrada de dados
//        System.out.print("Digite a largura da caixa (L) em metros: ");
//        double L = scanner.nextDouble(); // Exemplo: 0.27e-9 para 0.27 nm
//        
//        System.out.print("Digite o nível inicial da partícula (ni): ");
//        double nInicial = scanner.nextDouble();
//        
//        System.out.print("Digite o nível final da partícula (nf): ");
//        double nFinal = scanner.nextDouble();
//        
//        System.out.print("Digite o valor de a em metros: ");
//        double a = scanner.nextDouble();
//        
//        System.out.print("Digite o valor de b em metros: ");
//        double b = scanner.nextDouble();
//
//        // Massa do próton
//        double massaProton = 1.67e-27;
//
//        // Criando um objeto da classe ConfinarParticula
//        ConfinarParticula particula = new ConfinarParticula
//                                     (nInicial, L, massaProton, nFinal);
//
//        // Cálculos e saídas
//        System.out.println("\nFunção de Onda (nível 1):");
//        System.out.println(particula.funcaoOnda(L, nInicial));
//
//        System.out.println("\nFunção de Onda (nível 5):");
//        System.out.println(particula.funcaoOnda(L, nFinal));
//
//        System.out.println("\nEnergia em Joules (nível inicial):");
//        System.out.println(particula.energiaJ(nInicial, massaProton, L));
//
//        System.out.println("\nEnergia em eV (nível inicial):");
//        System.out.println(particula.energiaEv(nInicial, massaProton, L));
//        double energiaInicial = Double.parseDouble
//                            (particula.energiaJ(nInicial, massaProton, L));
//        double energiaInicialEv = Double.parseDouble
//                            (particula.energiaEv(nInicial, massaProton, L));
//
//        System.out.println("\nEnergia em Joules (nível final):");
//        System.out.println(particula.energiaJ(nFinal, massaProton, L));
//
//        System.out.println("\nEnergia em eV (nível final):");
//        System.out.println(particula.energiaEv(nFinal, massaProton, L));
//        double energiaFinal = Double.parseDouble
//                            (particula.energiaJ(nFinal, massaProton, L));
//        double energiaFinalEv = Double.parseDouble
//                            (particula.energiaEv(nFinal, massaProton, L));
//
//        System.out.println("\nEnergia do Fóton (de ni para nf):");
//        String energiaFotonStr = particula.energiaFotonAbsorvido
//                                (energiaFinalEv, energiaInicialEv);
//        System.out.println(energiaFotonStr);
//        double efoton = Double.parseDouble(particula.energiaFotonAbsorvido
//                                (energiaFinalEv, energiaInicialEv));
//        
//
//        // Convertendo energia do fóton para double
//        double energiaFoton = Double.parseDouble
//                              (energiaFotonStr.replace(",", ""));
//
//        System.out.println("\nFrequência do Fóton:");
//        String frequenciaFotonStr = particula.frequenciaFoton(energiaFoton);
//        System.out.println(frequenciaFotonStr);
//        double frequencia = Double.parseDouble(
//                            particula.frequenciaFoton(energiaFoton));
//        
//        System.out.println("Velocidade do próton " + "n1: ") ;
//        String veloN1 = particula.velocidadeProton(energiaInicial, massaProton);
//        System.out.println(veloN1 + " [m]");
//        
//        System.out.println("Velocidade do próton " + "n2: ") ;
//        String veloN2 = particula.velocidadeProton(energiaFinal, massaProton);
//        System.out.println(veloN2 + " [m]");
//
//        double veloInicial = Double.parseDouble(veloN1);
//        double veloFinal = Double.parseDouble(veloN2);
//
//        System.out.println("\nComprimento de Onda " + "n Inicial:");
//        System.out.println(particula.comprimentoDeBroglie
//                           (massaProton,veloInicial));
//        
//        System.out.println("\nComprimento de Onda " + "N final:");
//        System.out.println(particula.comprimentoDeBroglie
//                          (massaProton, veloFinal));
//        
//        System.out.println("\nComprimento de Onda do Fóton: ");
//        System.out.println(particula.comprimentoDeOndaFoton(efoton));
//        
//        
//                          
//
//        // Cálculo da probabilidade
//        double probabilidadeNInicial = particula.calcularProbabilidade(a, b, nInicial);
//        System.out.println("\nProbabilidade de encontrar a partícula entre "
//                          + "" + a + " e " + b + " metros:");
//        System.out.println(probabilidadeNInicial + " %");
//        double probabilidadeNFinal = particula.calcularProbabilidade(a, b, nFinal);
//        System.out.println("\nProbabilidade de encontrar a partícula entre " + a + " e " + b + " metros:");
//        System.out.println(probabilidadeNFinal + " %");
//        // Fechando o scanner
//        scanner.close();
//    }
}
