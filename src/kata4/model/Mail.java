package kata4.model;
public class Mail {

    private final String mail ;

    public String getMail() {
        return mail;
    }

    public Mail(String mail) {
        this.mail = mail;
    }

    public static boolean isMail(String mail){
    return mail.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$");
    }
    
    public String getDomain(){
        return mail.substring(mail.indexOf('@')+1);
    }
}
