package mvc.model;

import entreprise.Employe;
import entreprise.Travail;

import java.util.List;

public interface DAOSpecialEmploye {
    List<Travail> listerTravaux(Employe employe);

    List<Employe> getEmployes();

    Employe addEmploye(Employe employe);

    boolean removeEmploye(Employe employe);

    Employe updateEmploye(Employe employe);

    Employe readEmploye(int idEmploye);
}
