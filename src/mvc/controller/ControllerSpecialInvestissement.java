package mvc.controller;

import entreprise.Disciplines;
import entreprise.Investissement;

import java.util.Set;

public interface ControllerSpecialInvestissement {

    void addDisciplineToInvestissement(Disciplines discipline, int quantite, Investissement investissement);

    void removeDisciplineFromInvestissement(Disciplines discipline, Investissement investissement);

    Set<Disciplines> getSpecialitesEmployesForInvestissement(Investissement investissement);

}
