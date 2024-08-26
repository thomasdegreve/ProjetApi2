package mvc.model;

import entreprise.Projet;
import entreprise.Employe;
import entreprise.Disciplines;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface DAOSpecialProjet  {

    Set<Employe> listerEmployes(Projet p);

    Set<Disciplines> listerDisciplines(Projet p);

    List<Projet> filtrerProjets(Predicate<Projet> pr);
}
