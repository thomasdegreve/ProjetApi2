package designpattern.observer;

public class Employe implements Observateur {
    private String nom;

    public Employe(String nom) {
        this.nom = nom;
    }

    @Override
    public void actualiser(Projet projet) {
        System.out.println("Notification pour l'employé " + nom + ": La date de fin du projet a été modifiée à " + projet.getDateFin());
    }
}
