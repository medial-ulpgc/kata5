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
        HistogramDisplay histogramDisplay = new HistogramDisplay("String Histogram",histogram);
        histogramDisplay.execute();
        
        
        Histogram<Boolean> booleanHistogram = new Histogram();
        Boolean[] booleanEntries = new Boolean[]{ true, false,
                                                true, false,
                                                true, false,
                                                true};
        Arrays.stream(booleanEntries).forEach(key-> booleanHistogram.increment(key));
        
        HistogramDisplay booleanHistogramDisplay = new HistogramDisplay("Boolean Histogram",booleanHistogram);
       
        booleanHistogramDisplay.execute();
        
    }
    
}
