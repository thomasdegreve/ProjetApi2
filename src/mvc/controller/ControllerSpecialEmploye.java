package mvc.controller;

import entreprise.Employe;
import entreprise.Projet;
import entreprise.Disciplines;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface ControllerSpecialEmploye {


    public Set<Projet> listerProjets(Employe e);


    public Set<Disciplines> listerDisciplines(Employe e);


    List<Employe> filtrerEmployes(Predicate<Employe> pr);

    int listerTravaux(Employe e);
}
