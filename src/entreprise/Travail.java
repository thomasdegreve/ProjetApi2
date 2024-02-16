package entreprise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Travail {
    private static int nextId = 1;
    protected int idTravail;
    protected int pourcentage;
    protected Date DateEngag;
    protected Employe employes;


    public Travail(int pourcentage,Date DateEngag,Employe employes){
        this.idTravail=nextId++;
        this.pourcentage=pourcentage;
        this.DateEngag=DateEngag;
        this.employes=employes;

    }

    public int getIdTravail() {
        return idTravail;
    }

    public void setIdTravail(int idTravail) {
        this.idTravail = idTravail;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Date getDateEngag() {
        return DateEngag;
    }

    public void setDateEngag(Date dateEngag) {
        DateEngag = dateEngag;
    }

    public Employe getEmployes() {
        return employes;
    }

    public void setEmployes(Employe employes) {
        this.employes = employes;
    }
}
