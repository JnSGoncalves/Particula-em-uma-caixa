package model;

import java.text.DecimalFormat;

public class ConfinarParticula {
    private double hJaule = 6.62607015 * Math.pow(10, -34); // J.s
    private double hEv = 4.135667696 * Math.pow(10, -15);   // eV.s
    private double c = 3.0 * Math.pow(10, 8);               // Velocidade da luz (m/s)
    private DecimalFormat df = new DecimalFormat("0.###E0");
    private double nInicial, l, m, nFinal;

    // Construtor Parametrizado

    public ConfinarParticula(double nInicial, double l, double m, double nFinal) {
        this.nInicial = nInicial;
        this.l = l;
        this.m = m;
        this.nFinal = nFinal;
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
    
    
    

    // Construtor vazio
    public ConfinarParticula() {}

    // Getters e Setters
    

    public double getL() {
        return l;
    }

    

    public void setL(double l) {
        this.l = l;
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
        double enJ = (Math.pow(n, 2) * hJaule) / (8 * m * Math.pow(l, 2));
        return df.format(enJ);
    }

    public String energiaEv(double n, double m, double l) {
        double enEv = (Math.pow(n, 2) * hEv) / (8 * m * Math.pow(l, 2));
        return df.format(enEv);
    }

    // Método que calcula a velocidade da partícula no nível quântico
    public String velocidade(double n, double l, double m) {
        double p = (n * hJaule) / (2 * l); // Momento p_n = n h / 2L
        double v = p / m;                  // v_n = p_n / m
        return df.format(v);
    }

    // Método que calcula o comprimento de onda de De Broglie
    public String comprimentoDeBroglie(double n, double l) {
        double p = (n * hJaule) / (2 * l); // Momento p_n
        double lambda = hJaule / p;        // Comprimento de onda de De Broglie λ_n = h / p_n
        return df.format(lambda);
    }

    // Método que calcula a energia do fóton na transição entre dois níveis
    public String energiaFoton(double ni, double nf, double m, double l) {
        double ei = (Math.pow(ni, 2) * hJaule) / (8 * m * Math.pow(l, 2)); // Energia inicial
        double ef = (Math.pow(nf, 2) * hJaule) / (8 * m * Math.pow(l, 2)); // Energia final
        double efoton = Math.abs(ef - ei);                                 // Energia do fóton emitido/absorvido
        return df.format(efoton);
    }

    // Método que calcula a frequência do fóton
    public String frequenciaFoton(double efoton) {
        double frequencia = efoton / hJaule; // f = E / h
        return df.format(frequencia);
    }

    // Método que calcula o comprimento de onda do fóton
    public String comprimentoDeOndaFoton(double frequencia) {
        double lambdaFoton = c / frequencia; // λ = c / f
        return df.format(lambdaFoton);
    }

    // Teste
//    public static void main(String[] args) {
//        // Exemplo de uso
//        ConfinarParticula p = new ConfinarParticula();
//        
//        // Função de onda
//        String funcaoOnda = p.funcaoOnda(4, 7);
//        System.out.println("Função de onda: " + funcaoOnda);
//        
//        // Energia em joules e eV
//        String energiaJ = p.energiaJ(2, 9.11e-31, 1.0); // Exemplo com elétron
//        System.out.println("Energia em Joules: " + energiaJ);
//
//        String energiaEv = p.energiaEv(2, 9.11e-31, 1.0); // Exemplo com elétron
//        System.out.println("Energia em eV: " + energiaEv);
//
//        // Velocidade
//        String velocidade = p.velocidade(2, 1.0, 9.11e-31);
//        System.out.println("Velocidade: " + velocidade);
//
//        // Comprimento de onda de De Broglie
//        String deBroglie = p.comprimentoDeBroglie(2, 1.0);
//        System.out.println("Comprimento de Onda de De Broglie: " + deBroglie);
//
//        // Energia do fóton
//        String energiaFoton = p.energiaFoton(2, 3, 9.11e-31, 1.0);
//        System.out.println("Energia do Fóton: " + energiaFoton);
//
//        // Frequência do fóton
//        double energiaF = Double.parseDouble(p.energiaFoton(2, 3, 9.11e-31, 1.0).replace("E", "E"));
//        String frequencia = p.frequenciaFoton(energiaF);
//        System.out.println("Frequência do Fóton: " + frequencia);
//
//        // Comprimento de onda do fóton
//        double freq = Double.parseDouble(frequencia.replace("E", "E"));
//        String lambdaFoton = p.comprimentoDeOndaFoton(freq);
//        System.out.println("Comprimento de Onda do Fóton: " + lambdaFoton);
//    }
}
