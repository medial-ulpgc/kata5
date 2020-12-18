package kata5.model;
public class Person {
    private final String name;
    private final String address;
    private final String email;
    private final String state;

    public Person(String name, String address, String email, String state) {
        this.name = name;
        this.address = address;
        
        this.email = email;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "{name:\""+name+"\", adress:\""+address+"\", email:\""+email+"\",state:\""+state+"\"  }";
    }
    
    
    
    
}
