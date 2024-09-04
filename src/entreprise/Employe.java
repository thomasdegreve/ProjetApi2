package entreprise;

import java.util.Objects;

public class Employe {
    /**
     * id unique de l'employé
     */
    protected int idEmploye;

    /**
     * matricule unique de l'employé
     */

    protected String matricule;

    /**
     * nom de l'employé
     */
    protected String nom;

    /**
     * prenom de l'employé
     */
    protected String prenom;

    /**
     * tel de l'employé
     */
    protected String tel;

    /**
     * mail de l'employé
     */
    protected String mail;

    /**
     * specialite de l'employé
     */
    protected Disciplines specialite;

    /**
     * constructeur paramétré
     * @param idEmploye numerique unique de l'employe
     * @param matricule matricule unique de l'employé
     * @param nom nom de l'employé
     * @param prenom de l'employé
     * @param tel de l'employé
     * @param mail de l'employé
     * @param specialite de l'employé
     * constructeur paramétré
     */

    public Employe(int idEmploye,String matricule,String nom,String prenom,String tel,String mail,Disciplines specialite){
        this.idEmploye=idEmploye;
        this.matricule=matricule;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
        this.mail=mail;
        this.specialite=specialite;

    }

    /**
     * getter idEmploye
     * return l'id de l'employé
     */
    public int getIdEmploye() {
        return idEmploye;
    }
    /**
     * setter idemploye
     * @param idEmploye id employe
     */

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }


    /**
     * getter matricule
     * return le matricule de l'employé
     */
    public String getMatricule() {
        return matricule;
    }


    /**
     * setter du matricule
     * @param matricule matricule de l'employé
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


    /**
     * getter nom
     * return nom de l'employé
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom
     * @param nom de l'employé
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter prenom
     * return le prenom de l'employé
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter prenom
     * @param prenom de l'employé
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter tel
     * return le tel de l'employé
     */
    public String getTel() {
        return tel;
    }

    /**
     * setter tel
     * @param tel de l'employe
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * getter mail
     * return le mail de l'employe
     */
    public String getMail() {
        return mail;
    }

    /**
     * setter mail
     * @param mail de l'employe
     */

    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * getter disciplines()
     * return la specialite de l'employé
     */
    public Disciplines getDisciplines() {
        return specialite;
    }

    /**
     * setter disicplines()
     * @param  specialite de l'employé
     */
    public void setDisciplines(Disciplines specialite) {
        this.specialite = specialite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return idEmploye == employe.idEmploye;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmploye);
    }

    public Iterable<Object> getTravails() {

        return null;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "idEmploye=" + idEmploye +
                ", matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", specialite=" + specialite +
                '}';
    }
}
