package model;

// Importa as classes necessárias do JFreeChart para criar gráficos
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

    // Método para criar o gráfico da função de onda
    public JPanel graficoFuncaoOnda(double largura, double n){
        // Cria uma nova série de dados para a função de onda
        XYSeries series = new XYSeries("Função de Onda para N = " + n);

        // Calcula a função de onda para diferentes valores de x dentro da largura da caixa
        for (double x = 0; x <= largura; x += largura / 100) {
            // Aplica a fórmula da função de onda
            double valorFuncao = Math.sqrt(2 / largura) * Math.sin((n * Math.PI * x) / largura);
            series.add(x, valorFuncao); // Adiciona o valor de x e da função à série de dados
        }

        // Cria um conjunto de dados e adiciona a série calculada
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Cria o gráfico da função de onda com título e rótulos dos eixos
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Função de Onda para N = " + (int) Math.floor(n), // título do gráfico
                "X(Ȧ)[m]", // rótulo do eixo X
                "Ψ", // rótulo do eixo Y
                dataset, // dados do gráfico
                PlotOrientation.VERTICAL, // orientação do gráfico (vertical)
                true, // exibe legenda
                true, // exibe tooltips
                false // desabilita URLs
        );

        // Personaliza o gráfico
        XYPlot plot = chart.getXYPlot();
        plot.setDomainCrosshairVisible(true); // ativa a linha-guia horizontal
        plot.setRangeCrosshairVisible(true); // ativa a linha-guia vertical

        // Configura o intervalo do eixo X para coincidir com a largura da caixa
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setRange(0.0, largura);

        // Cria e retorna um painel contendo o gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        // Definindo o tamnho do painel
        chartPanel.setPreferredSize(new Dimension(600, 400));
        return chartPanel;
    }

    // Método para criar o gráfico da densidade de probabilidade
    public JPanel graficoProbabilidade(double largura, double n) {
        // Cria uma nova série de dados para a densidade de probabilidade
        XYSeries series = new XYSeries("Densidade de Probabilidade para N = " 
                                                                        + n);

        // Calcula a densidade de probabilidade ao longo da caixa
        for (double x = 0; x <= largura; x += largura / 100) {
            // Calcula a função de onda
            double funcaoOnda = Math.sqrt(2 / largura) * Math.sin((n * Math.PI * x) / largura);
            // Calcula a densidade de probabilidade como o quadrado da função de onda
            double densidadeProbabilidade = Math.pow(funcaoOnda, 2); // |Ψ(x)|^2
            series.add(x, densidadeProbabilidade); // adiciona x e densidade à série de dados
        }

        // Cria um conjunto de dados e adiciona a série calculada
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // Cria o gráfico da densidade de probabilidade com título e rótulos dos eixos
        JFreeChart chart = ChartFactory.createXYLineChart(
                // título do gráfico
                "Densidade de Probabilidade para nInicial = " + 
                                                            (int) Math.floor(n), 
                "X(Ȧ)[m]", // rótulo do eixo X
                "|Ψ|²", // rótulo do eixo Y
                dataset, // dados do gráfico
                PlotOrientation.VERTICAL, // orientação do gráfico
                true, // exibe legenda
                true, // exibe tooltips
                false // desabilita URLs
        );

        // Personaliza o gráfico
        XYPlot plot = chart.getXYPlot();
        plot.setDomainCrosshairVisible(true); // ativa a linha-guia horizontal
        plot.setRangeCrosshairVisible(true); // ativa a linha-guia vertical

        // Configura o intervalo do eixo X para coincidir com a largura da caixa
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setRange(0.0, largura);

        // Cria e retorna um painel contendo o gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400)); // define o tamanho do painel
        return chartPanel;
    }

    public static void main(String[] args) {
        // Configura o scanner para entrada de dados pelo usuário
        Scanner scanner = new Scanner(System.in);

        // Recebe a largura da caixa e o valor de nInicial do usuário
        System.out.print("Digite o valor de largura da caixa (M): ");
        double largura = scanner.nextDouble();
        System.out.print("Digite o valor de n: ");
        double nInicial = scanner.nextDouble();

        // Configura a janela principal que exibirá os gráficos
        JFrame frame = new JFrame("Gráficos de Função de Onda e Probabilidade");
        Graficos grafico = new Graficos();
        frame.setLayout(new BorderLayout());

        // Cria um painel para os gráficos e os adiciona 
        //em um layout de 2 linhas e 1 coluna
        JPanel panelGraficos = new JPanel(new GridLayout(2, 1));
        panelGraficos.add(grafico.graficoFuncaoOnda(largura, nInicial));
        panelGraficos.add(grafico.graficoProbabilidade(largura, nInicial));
        frame.add(panelGraficos, BorderLayout.CENTER);

        // Adiciona um botão "Sair" que encerra a aplicação
        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // encerra a aplicação ao clicar
            }
        });
        frame.add(sairButton, BorderLayout.SOUTH);

        // Configura a janela de exibição
        frame.pack(); // ajusta o tamanho da janela
        // fecha a janela ao sair
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // torna a janela visível
    }
}
