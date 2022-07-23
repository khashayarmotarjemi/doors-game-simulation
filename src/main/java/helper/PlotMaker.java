package helper;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.util.Rotation;
import org.jfree.data.statistics.HistogramDataset;


public class PlotMaker extends JFrame {

    private static final long serialVersionUID = 1L;

    public PlotMaker(int[] values) {
        super("run");
        // This will create the dataset
        HistogramDataset dataset = createDataset(values);
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);

    }

    public HistogramDataset createDataset(int[] values) {
        HistogramDataset dataset = new HistogramDataset();

        double[] doubles = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            doubles[i] = values[i];
        }

        dataset.addSeries("key", doubles, 1);
        return dataset;
    }

    /**
     * Creates a sample dataset
     */
//    private HistogramDataset createDataset() {
//        DefaultPieDataset result = new DefaultPieDataset();
//        result.setValue("Linux", 29);
//        result.setValue("Mac", 20);
//        result.setValue("Windows", 51);
//        return result;
//
//    }

    /**
     * Creates a chart
     */
    private JFreeChart createChart(HistogramDataset dataset) {

        JFreeChart chart = ChartFactory.createHistogram(
                "histogram",                  // chart title
                "tries",
                "clicks",
                dataset
        );

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }
}