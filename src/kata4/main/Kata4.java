package kata4.main;

import java.util.stream.Stream;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {


    public static void main(String[] args) {
        String FILENAME = "email.txt";
        Histogram<String> histogram = new Histogram<>();
        Stream<Mail> streamedRead = MailListReader.streamedRead(FILENAME);
        Histogram<String> mailHistogram = MailHistogramBuilder.build(streamedRead);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay<>("String Histogram",mailHistogram);
        histogramDisplay.execute();
        
    }
    
}
