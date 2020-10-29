package kata3;

import java.util.Arrays;

public class Kata3 {


    public static void main(String[] args) {
        
        Histogram<String> histogram = new Histogram<String>();
        String[] entries = new String[]{"amazon.co.uk","ulpgc.es","hotmail.com", "gobcan.es", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", "gobcan.es", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", "gobcan.es", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", "gobcan.es", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", "gobcan.es", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", "gobcan.es", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", "gobcan.es", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", "gobcan.es", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", 
                                        "amazon.co.uk","ulpgc.es", 
                                        "amazon.co.uk","ulpgc.es", 
                                        "amazon.co.uk", 
                                        "amazon.co.uk","ulpgc.es","hotmail.com", "gobcan.es" };
        
        Arrays.stream(entries).forEach(key-> histogram.increment(key));
        HistogramDisplay histogramDisplay = new HistogramDisplay("tururu",histogram);
        
        histogramDisplay.execute();
    }
    
}
