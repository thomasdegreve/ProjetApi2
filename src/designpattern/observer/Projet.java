package designpattern.observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projet {
    private List<Observateur> observateurs = new ArrayList<>();
    private LocalDate dateFin;

    public void ajouterObservateur(Observateur observateur) {
        observateurs.add(observateur);
    }

    public void supprimerObservateur(Observateur observateur) {
        observateurs.remove(observateur);
    }

    public void notifierObservateurs() {
        for (Observateur observateur : observateurs) {
            observateur.actualiser(this);
        }
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
        notifierObservateurs();
    }

    public String getDateFin() {
        return null;
    }
}
