import java.util.ArrayList;
import java.util.HashMap;

public class Promo {
    public static ArrayList<String> list_promo = new ArrayList<>();
    public static HashMap<String, Integer> list_promo_fomateur = new HashMap<>();
    public static HashMap<String, ArrayList<Integer>> list_promo_apprenant = new HashMap<>();

    public void ajouter_promo(String name_promo, int index_of_formateur){
        list_promo.add(name_promo);
        list_promo_apprenant.put(name_promo,new ArrayList<Integer>());
        list_promo_fomateur.put(name_promo,index_of_formateur);
    }
    public void ajouter_apprenant_to_promo(String name_promo, int index_of_apprenant){
        list_promo_apprenant.get(name_promo).add(index_of_apprenant);
    }
}
