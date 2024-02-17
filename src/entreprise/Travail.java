package entreprise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Travail {

    /**
     * auto incrémentation
     */
    private static int nextId = 1;

    /**
     * id unique du travail
     */
    protected int idTravail;

    /**
     * pourcentage de prise en charge du travail
     */
    protected int pourcentage;

    /**
     * date d'engagement
     */
    protected Date DateEngag;

    /**
     * Employe qui travaille
     */
    protected Employe employes;


    /**
     * constructeur paramétré
     * @param pourcentage pourcentage de prise en charge
     * @param DateEngag date engagement de l'employé
     * @param employes employé qui travaille pour le projet
     * constructeur paramétré
     */
    public Travail(int pourcentage,Date DateEngag,Employe employes){
        this.idTravail=nextId++;
        this.pourcentage=pourcentage;
        this.DateEngag=DateEngag;
        this.employes=employes;

    }


    /**
     * getter idtravail
     * return l'id du travail
     */
    public int getIdTravail() {
        return idTravail;
    }

    /**
     * setter idtravail
     * @param idTravail numerique unique du travail
     */
    public void setIdTravail(int idTravail) {
        this.idTravail = idTravail;
    }

    /**
     * getter pourcentage
     * return le pourcentage de prise en charge
     */
    public int getPourcentage() {
        return pourcentage;
    }

    /**
     * setter pourcentage
     * @param pourcentage de prise en charge
     */
    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    /**
     * getter dateEngag
     * return la date d'engagement
     */
    public Date getDateEngag() {
        return DateEngag;
    }

    /**
     * setter DateEngag
     * @param dateEngag de l'employé
     */
    public void setDateEngag(Date dateEngag) {
        DateEngag = dateEngag;
    }

    /**
     * getter employes()
     * return l'employé implique dans le projet
     */
    public Employe getEmployes() {
        return employes;
    }

    /**
     * setter employes()
     * @param employes impliqués dans le projet
     */
    public void setEmployes(Employe employes) {
        this.employes = employes;
    }
}
