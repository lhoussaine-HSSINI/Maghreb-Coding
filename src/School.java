import java.util.Scanner;

public class School {
    public void Afficher() {
        System.out.println("--------------------Bienvenue dans le plateforme  FAHOWORLD---------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir votre choix : 1)Administrateur     2)Formateur   3)Apprenant   4)Quitter");
        int str = sc.nextInt();
        int choix = str;
        switch (choix) {

            case 1:
                System.out.println("-------------------- Login Administrateur ---------------1------------------");
                Administrateur admin = new Administrateur();
//                admin.saisir();
                break;

            case 2:
                System.out.println("-------------------- Login Formateur ---------------2------------------");
                Formateur formateur = new Formateur();
//                formateur.get_beefices_today();
//                formateur.get_beefices_month();
//                formateur.get_beefices_year();
                break;
            case 3:
                System.out.println("-------------------- Login Apprenant ---------------3------------------");
                Apprenant apprenant =new Apprenant();
//                apprenant.print_all_users();
                break;
            case 4:
                System.out.println("Quitter");
                System.exit(0);
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        }
    }
}
