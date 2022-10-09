import java.util.HashMap;

public class SessionApprenant {
    public  String email ;
    public String password;
    public String username;
    public  String cin;
    public String prenom;
    public String nom;
    public static HashMap<String, String> information = new HashMap<>();
    public SessionApprenant(String nom,String prenom, String cin,String email, String username, String password){
        this.nom = nom;
        this.prenom= prenom;
        this.cin= cin;
        this.email = email;
        this.username= username;
        this.password= password;
    }


    public void printlist() {
        System.out.println("nom : "+this.nom + "\nprenom : " + this.prenom  + "\nemail : " + this.email + "\ncin : " +
                this.cin+ "\nusername : " +this.username);
    }

    public void printapprenant() {
        System.out.println(" ===> " +this.nom + " " + this.prenom);
    }
    public void email_ma_apprenant() {
        Formateur.brief_email.add(this.email);
    }
    public HashMap<String,String> test_apprenant(){
        information.put("nom",this.nom);
        information.put("prenom",this.prenom);
        information.put("cin",this.cin);
        information.put("username",this.username);
        information.put("password",this.password);
        return information;
    }
}
