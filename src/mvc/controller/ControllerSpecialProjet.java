package mvc.controller;

import entreprise.Projet;
import entreprise.Employe;
import entreprise.Disciplines;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface ControllerSpecialProjet {


    public Set<Employe> listerEmployes(Projet p);


    public Set<Disciplines> listerDisciplines(Projet p);


    List<Projet> filtrerProjets(Predicate<Projet> pr);

    int listerTravaux(Projet p);

    int listerInvestissements(Projet p);
}
