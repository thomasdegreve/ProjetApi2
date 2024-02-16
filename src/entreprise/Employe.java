package entreprise;

public class Employe {
   protected int idEmploye;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected String tel;
    protected String mail;

    protected Disciplines specialite;

    public Employe(int idEmploye,String matricule,String nom,String prenom,String tel,String mail,Disciplines specialite){
        this.idEmploye=idEmploye;
        this.matricule=matricule;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
        this.mail=mail;
        this.specialite=specialite;

    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Disciplines getDisciplines() {
        return specialite;
    }

    public void setDisciplines(Disciplines specialite) {
        this.specialite = specialite;
    }
}
