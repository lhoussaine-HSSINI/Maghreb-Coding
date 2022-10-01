import javax.mail.MessagingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Formateur {
    public static ArrayList<SessionFormateur> info = new ArrayList<>();
    public static ArrayList<String> info_brief = new ArrayList<>();
    public static HashMap<String, String> formateur_info_inside = new HashMap<>();
    public static Apprenant apprenant = new Apprenant();
    public static  String nom, prenom, cin , username, password,  contry, promo_formateur, Titre, Contexte_du_projet, Modalités_pédagogiques,Livrables;
    public static Scanner sc = new Scanner(System.in);
    public static int id, id_apprenant;
    public void add_info(){
        info.add(new SessionFormateur(this.nom,this.prenom,this.contry, this.cin, this.username, this.password));
    }
    public void add_info(SessionFormateur formateur){
        info.add(new SessionFormateur(this.nom,this.prenom,this.contry, this.cin, this.username, this.password));
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
    public void Dashboard_Formateur(HashMap<String, String> formateur_info) throws MessagingException {
        formateur_info_inside= formateur_info;
        int str;
        id = Integer.valueOf(formateur_info.get("id"));
        promo_formateur= getPromo_formateur(id);

        do {
            System.out.println("--------------------------------  plateforme  FAHOWORLD  -------------------------------");
            System.out.println("--------------------------  Bienvenue Formateur "+ formateur_info.get("nom")+"  "+formateur_info.get("prenom")+" --------------------------");
            System.out.println("------------------------------- Promo : "+promo_formateur +" -------------------------------");
            System.out.println("----------------------------- les apprenant : "+Promo.get_number_of_apprenant_in_promo(promo_formateur) +"         les brief : "+Brief.get_number_of_brief_promo(promo_formateur)+" ----------------------------- ");
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("Saisir votre choix : 1)les Apprenant      2)les brief  3)Déconnexion");
            str = sc.nextInt();
            int choix = str;
            Login login = new Login();
            switch (choix){
                case 1:
                    int f;
                    boolean by,dazt;
                    do {
                        dazt= true;
                        by = true;
                        System.out.println("---------------------------------------- les Apprenant ----------------------------------------");
                        System.out.println("Saisir votre choix : 1)Ajouter  Apprenant     2)Afficher les Apprenant   3)Dashboard   4)Déconnexion");
                        f = sc.nextInt();
                        int some_apprenat;
                        switch (f) {
                            case 1:
                                Scanner fr = new Scanner(System.in);
                                do{
                                    int test_id_apprenant;
                                    System.out.println("les  apprenant ");
                                    some_apprenat = apprenant.all_apprenant_pour_ajouter_promo_size();
                                    ArrayList<Integer> list_id_apprenant = apprenant.print_all_apprenant_pour_ajouter_promo();
                                    test_id_apprenant = Integer.parseInt(fr.nextLine());
                                    if (test_id_apprenant > 0 || test_id_apprenant <some_apprenat+1){
                                        id_apprenant = list_id_apprenant.get(test_id_apprenant-1);
                                        Promo.ajouter_apprenant_to_promo(promo_formateur, id_apprenant);
                                        dazt = false;
                                    }
                                }while(dazt);

                                break;
                            case 2:
                                System.out.println("apprenants en promotion : "+promo_formateur);
                                apprenant.print_all_apprenant_pour_ma_promo(promo_formateur);
                                break;
                            default:
                                System.out.println("Choix incorrect");
                                break;
                        }
                        if (f == 3 || f == 4)
                            by = false;
                    } while (by);
                    if (f == 4)
                        str = 4;
                    break;
                case 2:
                    int i;
                    boolean  by_brief;

                    do {
                        dazt= true;
                        by_brief = true;
                        System.out.println("---------------------------------------- les briefs ----------------------------------------");
                        System.out.println("Saisir votre choix : 1)Ajouter  Brief     2)Afficher les Brief   3)Dashboard   4)Déconnexion");
                        i = sc.nextInt();
                        switch (i) {
                            case 1:
                                Scanner br = new Scanner(System.in);
                                do{
                                    System.out.println("Titre :");
                                    Titre = String.valueOf(br.nextLine());
                                    System.out.println("Contexte du projet :");
                                    Contexte_du_projet = br.nextLine();
                                    System.out.println("Modalités pédagogiques :");
                                    Modalités_pédagogiques = br.nextLine();
                                    System.out.println("Livrables :");
                                    Livrables = br.nextLine();
                                    if (Titre.isEmpty() || Contexte_du_projet.isEmpty()|| Modalités_pédagogiques.isEmpty() || Livrables.isEmpty()){
                                        System.out.println(" xihaja na9sa khawya ");
                                    }else {
                                        dazt = false;
                                        info_brief.add(promo_formateur);
                                        info_brief.add(formateur_info.get("prenom")+" "+ formateur_info.get("nom"));
                                        info_brief.add(Titre);
                                        info_brief.add(Contexte_du_projet);
                                        info_brief.add(Modalités_pédagogiques);
                                        info_brief.add(Livrables);
                                        Brief.ajouter_brief(promo_formateur,info_brief);
                                        MessageToApprenant.go();
                                    }

                                }while(dazt);

                                break;
                            case 2:
                                System.out.println("---------------------------------------- les briefs ----------------------------------------");
                                Brief.print_ma_les_brief(promo_formateur);
                                break;
                            default:
                                System.out.println("Choix incorrect");
                                break;
                        }
                        if (i == 3 || i == 4)
                            by_brief = false;
                    }while(by_brief);
                    if (i == 4)
                        str = 3;
                    break;
                default:
                    if (choix  == 3)
                        str  = 4;
                    else
                        System.out.println("Choix incorrect");
                    break;
            }
        }while(str!=3);
//        this.Dashboard_Formateur(formateur_info_inside);
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
