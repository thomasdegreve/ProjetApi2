package mvc.model;

import entreprise.Disciplines;
import entreprise.Employe;

import java.util.List;

public interface DAOSpecialDisciplines {
    List<Employe> listerEmployes(Disciplines discipline);

    List<Disciplines> getDiscipline();

    Disciplines addDiscipline(Disciplines discipline);

    boolean removeDiscipline(Disciplines discipline);

    Disciplines updateDiscipline(Disciplines discipline);

    Disciplines readDiscipline(int idDiscipline);
}
