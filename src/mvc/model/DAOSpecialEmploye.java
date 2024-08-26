package mvc.model;

import entreprise.Employe;
import entreprise.Projet;
import entreprise.Disciplines;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface DAOSpecialEmploye  {

    Set<Projet> listerProjets(Employe e);

    Set<Disciplines> listerDisciplines(Employe e);

    List<Employe> filtrerEmployes(Predicate<Employe> pr);
}
