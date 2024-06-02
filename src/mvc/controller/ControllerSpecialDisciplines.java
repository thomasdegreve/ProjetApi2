package mvc.controller;

import entreprise.Disciplines;
import entreprise.Employe;

public interface ControllerSpecialDisciplines {

    void addEmployeToDiscipline(Employe employe, Disciplines discipline);

    void removeEmployeFromDiscipline(Employe employe, Disciplines discipline);

}
