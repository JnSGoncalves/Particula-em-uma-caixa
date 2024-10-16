package simulation.main.teste;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.axis.NumberAxis;

import javax.swing.*;
import java.awt.*;

public class AnimatedWaveFunction extends JFrame {

    private static final double HBAR = 1.055e-34; // Constante de Planck reduzida
    private static final double MASS = 9.11e-31;  // Massa do elétron
    private static final double L = 1e-9;          // Comprimento da caixa (1 nm)
    private static final int N = 3;                // Número quântico
    private static final int FRAME_RATE = 60;      // Taxa de quadros (FPS)
    private static final int POINTS = 100;         // Número de pontos no gráfico
    private static final double MAX_X = L;         // Limite da posição x

    private double time = 0.0; // Tempo inicial
    private XYSeries series;   // Série de dados para o gráfico
    private double[] previousValues; // Armazena os valores anteriores da função de onda

    public AnimatedWaveFunction() {
        series = new XYSeries("Função de Onda");
        previousValues = new double[POINTS + 1]; // Inicializa o array para armazenar os valores anteriores
        JFreeChart chart = createChart();
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        chartPanel.setMaximumSize(new Dimension(800, 600)); // Tamanho máximo fixo
        chartPanel.setMinimumSize(new Dimension(800, 600)); // Tamanho mínimo fixo
        setContentPane(chartPanel);
        
        // Timer para atualizar a animação
        Timer timer = new Timer(1000 / FRAME_RATE, e -> {
            updateWaveFunction();
            chart.fireChartChanged();
        });
        timer.start();
        
        // Configurações da janela
        setTitle("Animação da Função de Onda");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Impede o redimensionamento da janela
        setVisible(true); // Torna a janela visível
    }

    private JFreeChart createChart() {
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Animação da Função de Onda",
                "Posição (x)",
                "Amplitude",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Configurando a escala fixa dos eixos
        XYPlot plot = chart.getXYPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        
        // Definindo limites fixos para o eixo X
        xAxis.setRange(0, MAX_X); // Limite do eixo X de 0 a L
        
        // Definindo limites fixos para o eixo Y
        yAxis.setRange(-Math.sqrt(2 / L), Math.sqrt(2 / L)); // Limite do eixo Y entre -sqrt(2/L) e +sqrt(2/L)

        return chart;
    }

    private void updateWaveFunction() {
        double[] newValues = new double[POINTS + 1]; // Armazena os novos valores da função de onda

        // Calcula os novos valores
        for (int i = 0; i <= POINTS; i++) {
            double x = (i / (double) POINTS) * MAX_X; // Posição normalizada
            newValues[i] = Math.sqrt(2.0 / L) * Math.sin((N * Math.PI * x) / L)
                    * Math.cos((N * N * Math.PI * HBAR * time) / (2 * MASS * L * L));
        }

        // Suaviza a transição usando interpolação
        series.clear(); // Limpa os dados anteriores
        for (int i = 0; i <= POINTS; i++) {
            // Interpolação linear entre o valor anterior e o novo valor
            double smoothedValue = previousValues[i] + (newValues[i] - previousValues[i]) * 0.1; // 0.1 é o fator de suavização
            series.add(i * (MAX_X / POINTS), smoothedValue); // Adiciona o ponto ao gráfico
            previousValues[i] = smoothedValue; // Atualiza o valor anterior
        }

        time += 0.001; // Incrementa o tempo
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(AnimatedWaveFunction::new);
//    }
}
