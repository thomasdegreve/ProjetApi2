package mvc.model;

import entreprise.Investissement;

import java.util.List;

public interface DAOSpecialInvestissement {
    int getTotalInvestissement(Investissement investissement);

    List<Investissement> getInvestissements();

    Investissement addInvestissement(Investissement investissement);

    boolean removeInvestissement(Investissement investissement);

    Investissement updateInvestissement(Investissement investissement);

    Investissement readInvestissement(int idInvestissement);
}
