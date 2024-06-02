package mvc.controller;

import entreprise.Employe;
import entreprise.Projet;
import entreprise.Travail;

import java.util.List;

public interface ControllerSpecialTravail {

    void addTravailToProject(Employe employe, int pourcentage, Projet projet);

    void removeTravailFromProject(Employe employe, Projet projet);

    void updateTravailPourcentage(Employe employe, int pourcentage, Projet projet);

    List<Travail> getAllTravailsForProject(Projet projet);

}
