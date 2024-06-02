package designpattern.composite;

public class Projet extends ComposantProjet {
    private double cout;

    public Projet(String nom, double cout) {
        super(nom);
        this.cout = cout;
    }

    @Override
    public double getCoutTotal() {
        return cout;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "nom='" + nom + '\'' +
                ", cout=" + cout +
                '}';
    }
}
