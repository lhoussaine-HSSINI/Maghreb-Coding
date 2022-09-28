import java.util.Scanner;

public class School {
    public void Afficher() {
        System.out.println("--------------------Bienvenue dans le plateforme  FAHOWORLD---------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir votre choix : 1)Administrateur     2)Formateur   3)Apprenant   4)Quitter");
        int str = sc.nextInt();
        int choix = str;
        Login login = new Login();
        switch (choix) {

            case 1:
                System.out.println("-------------------- Login Administrateur ---------------1------------------");
                Login.administrateur_login();
                break;

            case 2:
                System.out.println("-------------------- Login Formateur ---------------2------------------");
                Login.formateur_login();
                break;
            case 3:
                System.out.println("-------------------- Login Apprenant ---------------3------------------");
                Login.apprenant_login();
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
