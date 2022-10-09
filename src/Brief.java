import java.util.ArrayList;
import java.util.HashMap;

public class Brief {
    public static HashMap<String, HashMap<Integer, ArrayList<String>>> brief = new HashMap<>();


    public static void ajouter_brief(String promo,ArrayList<String> info_brief){
        brief.get(promo).put(brief.get(promo).size()+1,info_brief);
    }
    public static void ajouter_promo_a_brief(String promo){
        brief.put(promo, new HashMap<>());
    }
    public static int get_number_of_brief_promo(String promo){
        return brief.get(promo).size();
    }

    public static void print_ma_les_brief(String promo_formateur){
        for(int i = 1 ;i<=brief.get(promo_formateur).size();i++){
            try {
                System.out.println(i+" ==> "+brief.get(promo_formateur).get(i).get(2));
            }catch (Exception e){

            }

        }
    }

}