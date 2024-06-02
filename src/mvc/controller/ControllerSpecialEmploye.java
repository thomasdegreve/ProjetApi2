package mvc.controller;

import entreprise.Disciplines;
import entreprise.Employe;

public interface ControllerSpecialEmploye {

    void addSpecialiteToEmploye(Disciplines specialite, Employe employe);

    void removeSpecialiteFromEmploye(Disciplines specialite, Employe employe);

}
