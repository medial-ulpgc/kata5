
package kata4.view;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kata4.model.Mail;

public class MailListReader {
    public static List<Mail> read(String filename) 
    {
        return streamedRead(filename).collect(Collectors.toList());
    }
    
    public static Stream<Mail> streamedRead(String filename) 
    {
        try {
        
            BufferedReader br = new BufferedReader( new FileReader(new File(filename)));
            return br.lines()
                    .filter(Mail::isMail)
                    .map(Mail::new);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MailListReader.class.getName()).log(Level.SEVERE, "file not found!", ex);
        }
        return Stream.empty();
        
    }
    
}
