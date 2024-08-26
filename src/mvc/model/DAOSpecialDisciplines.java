package mvc.model;

import entreprise.Disciplines;
import entreprise.Employe;
import entreprise.Projet;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface DAOSpecialDisciplines  {

    Set<Employe> listerEmployes(Disciplines d);

    Set<Projet> listerProjets(Disciplines d);

    List<Projet> listerProjets(Disciplines d, double minBudget, double maxBudget);

    List<Disciplines> filtrerDisciplines(Predicate<Disciplines> pr);
}
