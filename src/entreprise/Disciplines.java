package entreprise;

import java.util.ArrayList;
import java.util.List;

public class Disciplines {

    protected int idDisciplines;
    protected String nom;
    protected String description;
    List<Employe> employes=new ArrayList<>();


    public Disciplines(int idDisciplines,String nom,String description){
        this.idDisciplines=idDisciplines;
        this.nom=nom;
        this.description=description;

    }

    public int getIdDisciplines() {
        return idDisciplines;
    }

    public void setIdDisciplines(int idDisciplines) {
        this.idDisciplines = idDisciplines;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
}
