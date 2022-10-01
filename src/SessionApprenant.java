public class SessionApprenant {
    public  String email ;
    public String password;
    public String username;
    public  String cin;
    public String prenom;
    public String nom;
    public SessionApprenant(String nom,String prenom, String cin,String email, String username, String password){
        this.nom = nom;
        this.prenom= prenom;
        this.cin= cin;
        this.email = email;
        this.username= username;
        this.password= password;
    }


    public void printlist() {
        System.out.println("nom : "+this.nom + "\nprenom : " + this.prenom  + "\nemail : " + this.email + "\ncin : " +
                this.cin+ "\nusername : " +this.username);
    }

    public void printapprenant() {
        System.out.println(" ===> " +this.nom + " " + this.prenom);
    }

}
