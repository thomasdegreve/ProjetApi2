package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class GroupeProjet extends ComposantProjet {
    private int id;
    private List<ComposantProjet> composants = new ArrayList<>();

    public GroupeProjet(int id, String nom) {
        super(nom);
        this.id = id;
    }

    public void ajouterComposant(ComposantProjet composant) {
        composants.add(composant);
    }

    @Override
    public double getCoutTotal() {
        double coutTotal = 0;
        for (ComposantProjet composant : composants) {
            coutTotal += composant.getCoutTotal();
        }
        return coutTotal;
    }

    @Override
    public String toString() {
        return "GroupeProjet{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", coutTotal=" + getCoutTotal() +
                '}';
    }
}
