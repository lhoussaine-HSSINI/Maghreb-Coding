import java.util.ArrayList;

public class Apprenant {
    public static ArrayList<SessionApprenant> info = new ArrayList<>();
    public static  String nom, prenom, cin , module, username, password,  contry;
    public void add_info(){
        info.add(new SessionApprenant(nom, prenom, contry, cin, module, username, password));
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

}
