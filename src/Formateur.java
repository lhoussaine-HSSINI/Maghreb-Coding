import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Formateur {
    public static ArrayList<SessionFormateur> info = new ArrayList<>();
    public static  String nom, prenom, cin , module, username, password,  contry, promo_formateur;
    public static int id;
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
    public HashMap<String,String> test_formateur(String username, String password){
        int i = 1;
        HashMap<String, String> information_formateur = new HashMap<>();
        for(SessionFormateur formateur: info) {
                information_formateur = formateur.test_formateur();
                if (information_formateur.get("username").equals(username) && information_formateur.get("password").equals(password)){
                    information_formateur.put("id",String.valueOf(i));
                    information_formateur.put("login","true");
                    break;
                }else {
                    information_formateur.put("login","false");
                }
            i++;
        }
        return information_formateur;
    }
    public void Dashboard_Formateur(HashMap<String, String> formateur_info) {
        int str;
        id = Integer.valueOf(formateur_info.get("id"));
        promo_formateur= getPromo_formateur(id);
        System.out.println("--------------------------------  plateforme  FAHOWORLD  -------------------------------");
        System.out.println("--------------------------  Bienvenue Formateur "+ formateur_info.get("nom")+"  "+formateur_info.get("prenom")+" --------------------------");
        System.out.println("------------------------------- Promo : "+promo_formateur +" -------------------------------");
        System.out.println("----------------------------- les apprenant : "+Promo.get_number_of_apprenant_in_promo(promo_formateur) +"         les brief : 0"+" ----------------------------- ");
        System.out.println("Saisir votre choix : 1)les Apprenant      2)les brief  3)Déconnexion");
    }
    public String getPromo_formateur(int id_f){
        String promonom = null;
        for(Map.Entry<String, Integer> entry: Promo.list_promo_fomateur.entrySet()) {
            // if give value is equal to value from entry
            // print the corresponding key
            if(entry.getValue() == id_f) {
                promonom =  entry.getKey();
                break;
            }
        }
        return  promonom;
    }
    }
