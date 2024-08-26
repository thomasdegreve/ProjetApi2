package mvc.model;

import entreprise.Investissement;
import entreprise.Projet;
import entreprise.Disciplines;

import java.util.List;
import java.util.function.Predicate;

public interface DAOSpecialInvestissement  {

    List<Investissement> listerInvestissements(Projet p);

    List<Investissement> listerInvestissements(Disciplines d);

    List<Investissement> filtrerInvestissements(Predicate<Investissement> pr);
}
