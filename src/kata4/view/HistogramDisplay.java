package kata4.view;

import java.awt.Container;
import java.util.Comparator;
import javax.swing.JPanel;
import kata4.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay<T> extends ApplicationFrame{

    private final Histogram<T> histogram;
    
    public HistogramDisplay(String title, Histogram<T> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }
    private JFreeChart createChart (DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("JFreeChartHistogram", 
                "email domains", 
                "nº emails", 
                dataSet, 
                PlotOrientation.VERTICAL,
                false,
                false,
                rootPaneCheckingEnabled);
        return chart;
    }
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        histogram.keySet()
                .stream()
                .map( key-> new Pair(key, histogram.get(key)))
                .sorted(Comparator.comparing(Pair::getValue).reversed())
                .forEach((pair)->dataSet.addValue(pair.getValue(), "",pair.getKey().toString()));
        return dataSet;
    }
    private class Pair{

        private final T key;
        private final int value;

        public Pair(T key, int value) {
            this.key = key;
            this.value = value;
        }
        public T getKey() {
            return key;
        }
        public int getValue() {
            return value;
        }

        
    
    }
    public void execute(){
            this.setVisible(true);
    }
    
    @Override
    public final void setContentPane(Container contentPane) {
        super.setContentPane(contentPane);
    }

    @Override
    public final void pack() {
        super.pack();
    }
    
}
