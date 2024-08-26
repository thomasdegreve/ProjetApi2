package mvc.model;

import entreprise.Travail;
import entreprise.Employe;
import entreprise.Projet;

import java.util.List;
import java.util.function.Predicate;

public interface DAOSpecialTravail  {

    List<Travail> listerTravaux(Employe e);

    List<Travail> listerTravaux(Projet p);

    List<Travail> filtrerTravaux(Predicate<Travail> pr);
}
