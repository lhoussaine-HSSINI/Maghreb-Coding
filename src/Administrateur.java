import java.util.Scanner;

public class Administrateur {
    public static Formateur formateur = new Formateur();
    public static Apprenant apprenant = new Apprenant();
    public static Scanner sc = new Scanner(System.in);
    private String[] admin = {"faho", "53e427eba95bd08113687eb29fd86c3f"};
    public boolean test_admin(String username, String password){
                     return this.admin[0].equals(username) && this.admin[1].equals(password);
    }
    public void Dashboard_admin() {
        int str;
        System.out.println("-------------------------------  plateforme  FAHOWORLD  -------------------------------");
        System.out.println("--------------------------  Bienvenue l'administrateur Elias --------------------------");


        do {
            System.out.println("Saisir votre choix : 1)Formateurs     2)Apprenants   3)Promos   4)Déconnexion");
            str = sc.nextInt();
            int choix = str;
            Login login = new Login();
            switch (choix) {
                case 1:
                    System.out.println("-------------------- les Formateurs --------------------");
                    int f;
                    boolean by;
                    do {
                        by = true;
                        System.out.println("Saisir votre choix : 1)Ajouter  Formateur     2)Afficher les Formateurs   3)Dashboard   4)Déconnexion");
                        f = sc.nextInt();
                        switch (f) {
                            case 1:
                                Scanner fr = new Scanner(System.in);
                                System.out.println("-------------------- Ajouter  Formateur --------------------");
                                System.out.println("Saisir Prenom :");
                                String prenom = fr.nextLine();
                                Formateur.prenom = prenom;
                                System.out.println("Saisir le Nom :");
                                String nom = fr.nextLine();
                                Formateur.nom = nom;
                                System.out.println("Saisir cin :");
                                Formateur.cin = fr.nextLine();
                                System.out.println("Saisir module :");
                                Formateur.module = fr.nextLine();
                                System.out.println("Saisir contry :");
                                Formateur.contry = fr.nextLine();
                                Formateur.username = Formateur.nom+"."+Formateur.prenom+ "@youcode.ma";
                                Formateur.password = Login.generate_code(Formateur.cin);
                                formateur.add_info();
                                break;
                            case 2:
                                System.out.println("Afficher les Formateurs");
                                formateur.print_all_formateur();
                                break;
                            case 4:
//                                System.out.println("Quitter");
//                                System.exit(0);
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
                    System.out.println("-------------------- les Apprenants ---------------2------------------");
                    int fa;
                    boolean byy = true;
                    do {
                        System.out.println("Saisir votre choix : 1)Ajouter  Apprenants     2)Afficher les Apprenants   3)Dashboard   4)Déconnexion");
                        fa = sc.nextInt();
                        switch (fa) {
                            case 1:
                                Scanner fr = new Scanner(System.in);
                                System.out.println("-------------------- Ajouter  Apprenant --------------------");
                                System.out.println("Saisir Prenom :");
                                String prenom = fr.nextLine();
                                Apprenant.prenom = prenom;
                                System.out.println("Saisir le Nom :");
                                String nom = fr.nextLine();
                                Apprenant.nom = nom;
                                System.out.println("Saisir cin :");
                                Apprenant.cin = fr.nextLine();
                                System.out.println("Saisir module :");
                                Apprenant.module = fr.nextLine();
                                System.out.println("Saisir contry :");
                                Apprenant.contry = fr.nextLine();
                                Apprenant.username = Apprenant.nom+"."+Apprenant.prenom+ "@youcode.ma";
                                Apprenant.password = Login.generate_code(Apprenant.cin);
                                apprenant.add_info();
                                break;
                            case 2:
                                System.out.println("Afficher les Apprenants");
                                apprenant.print_all_formateur();
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
                    if (fa == 4)
                        str = 4;
                    break;
                case 3:
                    System.out.println("-------------------- Promos ---------------3------------------");
                    SessionPromo.dashboard_promo();
                    if (SessionPromo.fa == 4)
                        str = 4;
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Choix incorrect");
                    break;
            }
        }while (str != 4);

    }
}
