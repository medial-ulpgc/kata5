package kata4.view;

import java.util.List;
import java.util.stream.Stream;
import kata4.model.Histogram;
import kata4.model.Mail;


public class MailHistogramBuilder  {

    public static Histogram<String> build(Stream<Mail> mailStream){
        Histogram<String> histogram = new Histogram<>();
        mailStream
                .map(Mail::getDomain)
                .forEach(histogram::increment);
        return histogram;
        
        
    }
    public static Histogram<String> build(List<Mail>mailList){
        
        return build(mailList.stream());
    }
    
}
