package model;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;



public class Graficos {

    public JPanel graficoFuncaoOnda(double largura, double nInicial) {
        XYSeries series = new XYSeries("Função de Onda para nInicial");

        // Cálculo da função de onda para valores de x ao longo da caixa
        for (double x = 0; x <= largura; x += largura / 100) {
            double valorFuncao = Math.sqrt(2 / largura) * 
                                 Math.sin((nInicial * Math.PI * x) / largura);
            series.add(x, valorFuncao);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Função de Onda para nInicial = " + nInicial,
                "Posição (x)",
                "Amplitude",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setRange(0.0, largura);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        return chartPanel;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor de largura da caixa (em metros): ");
        double largura = scanner.nextDouble();
        System.out.print("Digite o valor de nInicial: ");
        double nInicial = scanner.nextDouble();

        // Configuração da janela de exibição do gráfico
        JFrame frame = new JFrame("Gráfico da Função de Onda");
        Graficos grafico = new Graficos();
        frame.setLayout(new BorderLayout());
        
        // Adiciona o gráfico ao centro do JFrame
        frame.add(grafico.graficoFuncaoOnda(largura, nInicial), BorderLayout.CENTER);

        // Cria e adiciona o botão "Sair" à parte inferior do JFrame
        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Sai da aplicação ao clicar no botão
            }
        });
        
        frame.add(sairButton, BorderLayout.SOUTH); // Adiciona o botão na parte inferior

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
