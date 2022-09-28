import java.util.ArrayList;
import java.util.HashMap;

public class Promo {
    public static ArrayList<String> list_promo = new ArrayList<>();
    public static HashMap<String, Integer> list_promo_fomateur = new HashMap<>();
    public static HashMap<String, ArrayList<Integer>> list_promo_apprenant = new HashMap<>();

    public static  void ajouter_promo(String name_promo, int index_of_formateur){
        list_promo.add(name_promo);
        list_promo_apprenant.put(name_promo,new ArrayList<Integer>());
        list_promo_fomateur.put(name_promo,index_of_formateur);
    }
    public static  void ajouter_apprenant_to_promo(String name_promo, int index_of_apprenant){
        list_promo_apprenant.get(name_promo).add(index_of_apprenant);
    }
    public static HashMap<String, Integer> get_promo(){
        return list_promo_fomateur;
    }
    public static int get_number_of_apprenant_in_promo(String nompromo){
        return list_promo_apprenant.get(nompromo).size();
    }
}