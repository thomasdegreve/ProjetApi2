package mvc.model;

import entreprise.Employe;
import entreprise.Projet;
import entreprise.Travail;

import java.util.List;

public interface DAOSpecialTravail {
    List<Projet> listerProjets(Employe employe);
    List<Employe> listerEmployes(Projet projet);

    List<Travail> getTravails();

    Travail addTravail(Travail travail);

    boolean removeTravail(Travail travail);

    Travail updateTravail(Travail travail);

    Travail readTravail(int idTravail);
}
