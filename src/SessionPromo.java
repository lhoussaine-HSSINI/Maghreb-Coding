import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SessionPromo {
    public static Scanner fr = new Scanner(System.in);
    public static int fa , id_formateur;
    public static String nom_promo;
    public static boolean byy = true, dazt= true;
    public static void dashboard_promo(){
        do {
            System.out.println("Saisir votre choix : 1)Ajouter Promo   2)Afficher les Promos  3)Dashboard   4)Déconnexion");
            fa = fr.nextInt();
            Scanner frr = new Scanner(System.in);
            switch (fa) {
                case 1:
                    System.out.println("-------------------- Ajouter  Promo --------------------");
                    do{
                        System.out.println("Saisir nom pour promo :");
                        nom_promo = frr.nextLine();
                    }while(nom_promo.isEmpty());
                    int a;
                    do{
                        System.out.println("les  formateurs :");
                        a = Formateur.print_all_formateur_pour_ajouter_promo();
                        id_formateur = Integer.parseInt(frr.nextLine());
                        if (id_formateur != 0 && id_formateur<a)
                            dazt = false;
                    }while(dazt);

                    Promo.ajouter_promo(nom_promo,id_formateur);
                    break;
                case 2:
                    System.out.println("-------------------- Afficher  Promo --------------------");
                    HashMap<String, Integer>  list_promo_have_index = Promo.get_promo();
                    for (int i=0, j=1; i<list_promo_have_index.size(); i++, j++){
                        System.out.println(j+" ==> promo : "+Promo.list_promo.get(i)+" ==> formateur : "
                                +Formateur.get_formateur_index(list_promo_have_index.get(Promo.list_promo.get(i))));
                    }
//                    System.out.println(list_promo_have_index);
                    break;
                case 4:
//                                System.out.println("Quitter");
//                                System.exit(0);
                    break;
                default:
                    System.out.println("Choix incorrect");
                    break;
            }
            if (fa == 3 || fa == 4)
                byy = false;
        } while (byy);
    }
}
