package model;

public class FuncaoOnda {
    private final double L = 1e-9;
    private final int maxPontos = 80;

    // Constante de Planck reduzida (HBAR) em J.s
    public static final double HBAR = 1.054571817e-34;
    public static final double MASS = 9.10938356e-31; // Massa do elétron

    // Construtor da classe
    public FuncaoOnda() {}

    // Função para calcular a função de onda dependente do tempo
    public Pontos calcularFuncaoOnda(int n, double tempo) {
        double[] x = new double[maxPontos];
        double[] y = new double[maxPontos];
        
        double dx = L / (maxPontos - 1);
        
        // Calcula a função de onda para cada ponto x e no tempo t
        for (int i = 0; i < maxPontos; i++) {
            x[i] = i * dx;
            // Parte espacial da função de onda
            double parteEspacial = Math.sqrt(2.0 / L) * Math.sin((n * Math.PI * x[i]) / L);
            // Parte temporal da função de onda
            double parteTemporal = Math.cos((n * n * Math.PI * HBAR * tempo) / (2 * MASS * L * L));
            // Função de onda total em x e t
            y[i] = parteEspacial * parteTemporal;
        }
        
        return new Pontos(x, y);
    }

    public double getL() {
        return L;
    }

    public int getMaxPontos() {
        return maxPontos;
    }
}

