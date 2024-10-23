package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class OptimizedWaveFunction extends JFrame {

    private static final double HBAR = 1.055e-34; // Constante de Planck reduzida
    private static final double MASS = 9.11e-31;  // Massa do elétron
    private static final double L = 1e-9;         // Comprimento da caixa (1 nm)
    private static final int N = 3;               // Número quântico
    private static final int FRAME_RATE = 10;     // Taxa de quadros (FPS)
    private static final int POINTS = 80;        // Número de pontos no gráfico
    private static final double MAX_X = L;        // Limite da posição x

    private double time = 0.0;    // Tempo inicial
    private XYSeries series;      // Série de dados para o gráfico

    public OptimizedWaveFunction() {
        series = new XYSeries("Função de Onda", false);
        JFreeChart chart = createChart();
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        chartPanel.setMaximumSize(new Dimension(800, 600)); // Tamanho máximo fixo
        chartPanel.setMinimumSize(new Dimension(800, 600)); // Tamanho mínimo fixo
        setContentPane(chartPanel);

        // Desabilitar zoom
        chartPanel.setDomainZoomable(false);
        chartPanel.setRangeZoomable(false);
        setContentPane(chartPanel);

        setTitle("Animação da Função de Onda");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Impede o redimensionamento da janela
        setVisible(true); // Torna a janela visível
        
        // Timer para atualizar a animação
        Timer timer = new Timer(1000 / FRAME_RATE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWaveFunction();
                chart.fireChartChanged();
            }
        });
        timer.start();
    }

    private JFreeChart createChart() {
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                null, // Remove título do gráfico
                null, // Remove título do eixo X
                null, // Remove título do eixo Y
                dataset,
                PlotOrientation.VERTICAL,
                false, // Sem legenda
                false, // Sem dicas
                false  // Sem URLs
        );

        XYPlot plot = chart.getXYPlot();
        NumberAxis xAxis = (NumberAxis) chart.getXYPlot().getDomainAxis();
        xAxis.setTickLabelsVisible(false); // Remove os números da escala do eixo X

        NumberAxis yAxis = (NumberAxis) chart.getXYPlot().getRangeAxis();
        yAxis.setTickLabelsVisible(false);

        plot.setBackgroundPaint(null);
        
        // Definindo limites fixos para o eixo X
        xAxis.setRange(0, MAX_X); // Limite do eixo X de 0 a L
        
        // Definindo limites fixos para o eixo Y
        yAxis.setRange(-Math.sqrt(2 / L), Math.sqrt(2 / L)); // Limite do eixo Y entre -sqrt(2/L) e +sqrt(2/L)

        // Remove plano de fundo
        plot.setBackgroundPaint(Color.WHITE);
        chart.setBackgroundPaint(Color.WHITE);

        return chart;
    }

    private void updateWaveFunction() {
        series.setNotify(false); // Desabilita as notificações enquanto os dados são atualizados
        series.clear();          // Limpa os dados anteriores

        for (int i = 0; i <= POINTS; i++) {
            double x = (i / (double) POINTS) * MAX_X; // Posição normalizada
            double waveFunction = Math.sqrt(2.0 / L) * Math.sin((N * Math.PI * x) / L)
                    * Math.cos((N * N * Math.PI * HBAR * time) / (2 * MASS * L * L));
            series.add(x, waveFunction); // Adiciona o ponto ao gráfico
        }

        series.setNotify(true);  // Habilita novamente as notificações
        time += 0.005;            // Incrementa o tempo
    }
}

