import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Apprenant {
    public static ArrayList<SessionApprenant> info = new ArrayList<>();
    public static HashMap<String, String> apprenant_info_inside = new HashMap<>();
    public static  String nom, prenom, cin , email, username, password, promo_apprenant;
    public static int id;
    public static Scanner sc = new Scanner(System.in);
    public void add_info(){
        info.add(new SessionApprenant(nom, prenom, cin, email, username, password));
    }
    public void print_all_formateur() {
        int i = 1;
        for(SessionApprenant car: info) {
            System.out.println(" ==================  "+i+" =====================");
            car.printlist();
            i++;
        }
    }
    public ArrayList<Integer> print_all_apprenant_pour_ajouter_promo() {
        int i = 1, j=1;
        ArrayList<Integer> list_id_apprenant= new ArrayList<>();
        for(SessionApprenant apprenant: info) {
            if (!this.test_apprinant_in_promo(i)){
                System.out.print(j);
                list_id_apprenant.add(i);
                apprenant.printapprenant();
                j++;
            }
            i++;
        }
        System.out.print("choix  aprenant : ");
        return list_id_apprenant;
    }
    public int all_apprenant_pour_ajouter_promo_size() {
        int i = 1;
        ArrayList<Integer> list_id_apprenant= new ArrayList<>();
        for(SessionApprenant apprenant: info) {
            if (!this.test_apprinant_in_promo(i)){
                list_id_apprenant.add(i);
            }
            i++;
        }
        return list_id_apprenant.size();
    }
    public boolean test_apprinant_in_promo(int j){
        boolean kayn = false;
        for (int i = 0; i <Promo.list_promo.size() ; i++) {
            if (Promo.list_promo_apprenant.get(Promo.list_promo.get(i)).contains(j)){
                    kayn = true;
                    return kayn;
            }
        }
        return kayn;
    }

    public void print_all_apprenant_pour_ma_promo(String promo_formateur){
        ArrayList<Integer> list_apprenant_in_promo = Promo.get_array_list_of_apprenant_in_promo(promo_formateur);
        int i =1, j= 1;
        for(SessionApprenant apprenant: info) {
            if (list_apprenant_in_promo.contains(i)){
                System.out.print(j);
                apprenant.printapprenant();
                j++;
            }
            i++;
        }
    }
    public void array_list_email_all_apprenant_pour_ma_promo(String promo_formateur){
        ArrayList<Integer> list_apprenant_in_promo = Promo.get_array_list_of_apprenant_in_promo(promo_formateur);
        int i =1, j= 1;
        for(SessionApprenant apprenant: info) {
            if (list_apprenant_in_promo.contains(i)){
                apprenant.email_ma_apprenant();
            }
            i++;
        }
    }

    public HashMap<String,String> test_apprenant(String username, String password){
        int i = 1;
        HashMap<String, String> information_apprenant = new HashMap<>();
        for(SessionApprenant apprenant: info) {
            information_apprenant = apprenant.test_apprenant();
            if (information_apprenant.get("username").equals(username) && information_apprenant.get("password").equals(password)){
                information_apprenant.put("id",String.valueOf(i));
                information_apprenant.put("login","true");
                break;
            }else {
                information_apprenant.put("login","false");
            }
            i++;
        }
        return information_apprenant;
    }
    public  void Dashboard_Apprenant(HashMap<String, String> apprenant_info) throws MessagingException, IOException {
        apprenant_info_inside= apprenant_info;
        int str;
        id = Integer.parseInt(apprenant_info.get("id"));
        promo_apprenant= getPromo_apprenant(id);

        do {
            System.out.println("--------------------------------  plateforme  FAHOWORLD  -------------------------------");
            System.out.println("--------------------------  Bienvenue Apprenant : "+ apprenant_info.get("nom")+"  "+apprenant_info.get("prenom")+" --------------------------");
            System.out.println("------------------------------- Promo : "+promo_apprenant +" -------------------------------");
            System.out.println("----------------------------- les apprenant : "+Promo.get_number_of_apprenant_in_promo(promo_apprenant) +"         les brief : "+Brief.get_number_of_brief_promo(promo_apprenant)+" ----------------------------- ");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-------------- Saisir votre choix : 1)les brief  2)Déconnexion --------------");
            str = sc.nextInt();
            int choix = str;
            Login login = new Login();
            switch (choix){
                case 1:
                    System.out.println("---------------------------------------- les briefs ----------------------------------------");
                    Brief.print_ma_les_brief(promo_apprenant);
                    break;
                default:
                    try {
                        if (choix<1 || choix>1|| choix!=3)
                            System.out.println("Choix incorrect");
                        else if(choix==4){
                            str = 3;
                            School.Afficher();
                        }
                    }catch (Exception e) {
                        System.out.println("Choix incorrect");
                    }
                    break;
            }
        }while(str!=3);
        School.Afficher();
    }
    public static String getPromo_apprenant(int id_a){
        String promonom = null;
        for (Map.Entry<String, ArrayList<Integer>> set :
                Promo.list_promo_apprenant.entrySet()) {
            if (set.getValue().contains(id_a)){
                promonom = set.getKey();
            }
        }
        return promonom;
    }
}
