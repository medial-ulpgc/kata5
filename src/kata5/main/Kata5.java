package kata5.main;
import kata5.model.Person;
import java.sql.*;
import java.util.List;
import java.util.stream.Stream;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
public class Kata5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        SqlitePeopleLoader sqlitePeopleLoader = new SqlitePeopleLoader("data\\20201125.db");
        if(sqlitePeopleLoader.getValid()){
            List<Person> people = sqlitePeopleLoader.load();
            
            Stream<Mail> emailsStream = people.stream()
                    .map(Person::getEmail)
                    .filter(Mail::isMail)
                    .map(Mail::new);
                
        Histogram<String> mailHistogram = MailHistogramBuilder.build(emailsStream);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay<>("String Histogram",mailHistogram);
        histogramDisplay.execute();
        }
    }
}
