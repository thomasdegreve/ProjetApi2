package entreprise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Disciplines {

    /**
     * id unique de la discipline
     */
    protected int idDisciplines;

    /**
     * nom unique de la discipline
     */
    protected static String nom; // ajout static suite a l'erreur dans l'override

    /**
     * description de la discipline
     */
    protected String description;

    /**
     * liste d'employé pour la discipline
     */
    List<Employe> employes=new ArrayList<>();


    /**
     * constructeur paramétré
     * @param idDisciplines numerique unique de la discipline
     * @param nom  nom de la discipline
     * @param description descirption de la discipline
     * constructeur paramétré
     */
    public Disciplines(int idDisciplines,String nom,String description){
        this.idDisciplines=idDisciplines;
        this.nom=nom;
        this.description=description;

    }

    /**
     * getter idIDisciplines
     * return l'id de la discipline
     */
    public int getIdDisciplines() {
        return idDisciplines;
    }

    /**
     * setter idDisciplines
     * @param idDisciplines numerique unique de la discipline
     */
    public void setIdDisciplines(int idDisciplines) {
        this.idDisciplines = idDisciplines;
    }

    /**
     * getter nom
     * return le nom de la discipline
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom
     * @param nom nom de la discipline
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter description
     * return la description de la discipline
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter description
     * @param description description de la discipline
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter employes
     * return la liste des employés
     */
    public List<Employe> getEmployes() {
        return employes;
    }

    /**
     * setter employes
     * @param employes la liste des employes
     */
    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplines disciplines = (Disciplines) o;
        return nom.equals(Disciplines.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDisciplines, description, employes);
    }

    public int getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Disciplines{" +
                "idDisciplines=" + idDisciplines +
                ", description='" + description + '\'' +
                ", nom :" + nom +

                '}';
    }
}
