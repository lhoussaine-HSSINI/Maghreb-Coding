import javax.mail.MessagingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

public class Login {
    public static boolean check = false;
    public static Administrateur Admin = new Administrateur();
    public static Formateur formateur = new Formateur();
    public static HashMap<String, String> information_user_login = new HashMap<>();
    public static Login login = new Login();
    public  static String username , password;
    public  static boolean daz = false;
    public static void administrateur_login() throws MessagingException {
        do{
            System.out.println("Saisir username :");
            Scanner sc = new Scanner(System.in);
            username = sc.nextLine();
            System.out.println("Saisir password :");
            password = sc.nextLine();
            if (username.isEmpty() || password.isEmpty()){
                System.out.println(" Réveille ne pas laisser les entries vides ");
                check=true;
            }
        }while (check);
        daz = Admin.test_admin(username, generate_code(password));
        if (daz){
            Admin.Dashboard_admin();
        }else{
            System.out.println("  login errors  ");
            Login.administrateur_login();
        }

    }
    public static void formateur_login() throws MessagingException {
        do{
            System.out.println("Saisir username :");
            Scanner sc = new Scanner(System.in);
            username = sc.nextLine();
            System.out.println("Saisir password :");
            password = sc.nextLine();
            if (username.isEmpty() || password.isEmpty()){
                System.out.println(" Réveille ne pas laisser les entries vides ");
                check=true;
            }
        }while (check);
        information_user_login = formateur.test_formateur(username, generate_code(password));
        daz = Boolean.parseBoolean(information_user_login.get("login"));
        if (daz){
              formateur.Dashboard_Formateur(information_user_login);
        }else{
            System.out.println("  login errors  ");
            Login.formateur_login();
        }
    }
    public static void apprenant_login()
    {

    }

    public static String generate_code(String input)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32)
            {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

}
