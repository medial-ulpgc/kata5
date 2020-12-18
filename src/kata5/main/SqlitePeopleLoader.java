
package kata5.main;

import kata5.model.PeopleLoader;
import kata5.model.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlitePeopleLoader implements PeopleLoader{
    private final Connection connection;
    private final boolean valid;
    public SqlitePeopleLoader(String file) {
        boolean localValid = false;
        Connection localConnection = null;
        try{
            Class.forName("org.sqlite.JDBC"); 
            localConnection = DriverManager.getConnection("jdbc:sqlite:"+ file);
            localValid = true;
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(SqlitePeopleLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection =localConnection;
        valid = localValid;
            
        }
    

    
    @Override
    public List<Person> load() {
        final ArrayList<Person> arrayList = new ArrayList<>();
        
        try(Statement statement = connection.createStatement()) {
            ResultSet resultset = statement.executeQuery("select * from people where state = \"CA\" ");
            
            while(resultset.next()){
                final String name = resultset.getString("first_name");
                final String address = resultset.getString("address");
                final String email = resultset.getString("email");
                final String state = resultset.getString("state");
                arrayList.add(new Person(name, address, email, state));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(SqlitePeopleLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }
    public boolean getValid(){
        return valid;
    }
}
