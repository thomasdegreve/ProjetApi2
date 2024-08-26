package mvc.controller;

import entreprise.Disciplines;
import entreprise.Projet;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface ControllerSpecialDiscipline {


    public Set<Projet> listerProjets(Disciplines d);


    public List<Projet> listerProjets(Disciplines d, double minBudget, double maxBudget);


    List<Disciplines> filtrerDisciplines(Predicate<Disciplines> pr);

    int listerEmployes(Disciplines d);
}
