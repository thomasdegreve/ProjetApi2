package designpattern.composite;

public abstract class ComposantProjet {
    protected String nom;

    public ComposantProjet(String nom) {
        this.nom = nom;
    }

    public abstract double getCoutTotal();
}
