public class SessionFormateur {
    public  String module ;
    public String password;
    public String username;
    public  String cin;
    public String prenom;
    public String nom, contry;
    public SessionFormateur(String nom,String prenom,String contry, String cin,String module, String username, String password) {
        this.nom = nom;
        this.prenom= prenom;
        this.contry= contry;
        this.cin= cin;
        this.module = module;
        this.username= username;
        this.password= password;
    }


    public void printlist() {
        System.out.println("nom : "+this.nom + "\nprenom : " + this.prenom  + "\nmodule : " + this.module + "\ncin : " +
                this.cin+ "\nusername : " +this.username);
    }

}
