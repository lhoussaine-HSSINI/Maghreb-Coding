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
//        if (info.size()>0)
//            System.out.println(info.get(0).username);
    }
}
