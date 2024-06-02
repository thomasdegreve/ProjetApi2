package mvc.controller;

import entreprise.Disciplines;
import entreprise.Projet;

import java.util.Set;

public interface ControllerSpecialProjet {

    void addDisciplineToProject(Disciplines discipline, int quantite, Projet projet);

    void removeDisciplineFromProject(Disciplines discipline, Projet projet);

    Set<Disciplines> getSpecialitesEmployesForProject(Projet projet);

}
