import java.text.ParseException;
import java.util.ArrayList;

public class Formateur {
    public static ArrayList<SessionFormateur> info = new ArrayList<>();
    public static  String nom, prenom, cin , module, username, password,  contry;
    public void add_info(){
        info.add(new SessionFormateur(this.nom,this.prenom,this.contry, this.cin,this.module, this.username, this.password));
    }
    public void add_info(SessionFormateur formateur){
        info.add(new SessionFormateur(this.nom,this.prenom,this.contry, this.cin,this.module, this.username, this.password));
    }
    public void print_all_formateur() {
        int i = 1;
        for(SessionFormateur car: info) {
            System.out.println(" ==================  "+i+" =====================");
            car.printlist();
            i++;
        }
    }
}
