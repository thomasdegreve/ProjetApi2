package mvc.model;

import entreprise.Investissement;
import entreprise.Projet;
import entreprise.Travail;

import java.util.List;

public interface DAOSpecialProjet {
    List<Investissement> listerInvestissements(Projet projet);
    List<Travail> listerTravail(Projet projet);

    List<Projet> getProjets();

    Projet addProjet(Projet projet);

    boolean removeProjet(Projet projet);

    Projet updateProjet(Projet projet);

    Projet readProjet(int idProjet);
}
