import java.util.ArrayList;
import java.util.HashMap;

public class SessionFormateur {
    public  String module ;
    public String password;
    public String username;
    public  String cin;
    public String prenom;
    public String nom, contry;
    public static HashMap<String, String> information = new HashMap<>();
    public SessionFormateur(String nom,String prenom,String contry, String cin,String module, String username, String password) {
        this.nom = nom;
        this.prenom= prenom;
        this.contry= contry;
        this.cin= cin;
        this.module = module;
        this.username= username;
        this.password= password;
    }


    public void printlist() {
        System.out.println("nom : "+this.nom + "\nprenom : " + this.prenom  + "\nmodule : " + this.module + "\ncin : " +
                this.cin+ "\nusername : " +this.username);
    }
    public void printformateur() {
        System.out.println(" ===> " +this.nom + " " + this.prenom);
    }
    public String printoneformateur() {
        return this.nom + " " + this.prenom;
    }
    public HashMap<String,String> test_formateur(){
        information.put("nom",this.nom);
        information.put("prenom",this.prenom);
        information.put("module",this.module);
        information.put("cin",this.cin);
        information.put("username",this.username);
        information.put("password",this.password);
        return information;
    }

}
