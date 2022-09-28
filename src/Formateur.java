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
    public static int print_all_formateur_pour_ajouter_promo() {
        int i = 1;
        for(SessionFormateur formateur: info) {
            if (!Promo.list_promo_fomateur.containsValue(i)){
                System.out.print(i);
                formateur.printformateur();
            }
            i++;
        }
        System.out.print("choix  formateur : ");
        return i;
    }
    public static void get_formateur(int index) {
        int i = 1;
        for(SessionFormateur formateur: info) {
            if (i==index){
                formateur.printoneformateur();
            }
            i++;
        }
    }
    public static String get_formateur_index(int index) {
        int i = 1;
        String nom_prenom = "";
        for(SessionFormateur formateur: info) {
            if (i==index){
                nom_prenom = formateur.printoneformateur();
            }
            i++;
        }
        return nom_prenom;
    }
}
