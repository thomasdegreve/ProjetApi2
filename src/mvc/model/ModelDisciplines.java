package mvc.model;

import entreprise.Disciplines;
import entreprise.Employe;

import java.util.ArrayList;
import java.util.List;

public class ModelDisciplines extends DAO<Disciplines> implements DAOSpecialDisciplines {

    private List<Disciplines> ldatas = new ArrayList<>();

    @Override
    public Disciplines add(Disciplines elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(Disciplines elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Disciplines update(Disciplines elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Disciplines read(Disciplines rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Disciplines> getAll() {
        return ldatas;
    }

    @Override
    public List<Employe> listerEmployes(Disciplines discipline) {
        return null;
    }

    @Override
    public List<Disciplines> getDiscipline() {
        return null;
    }

    @Override
    public Disciplines addDiscipline(Disciplines discipline) {
        return null;
    }

    @Override
    public boolean removeDiscipline(Disciplines discipline) {
        return false;
    }

    @Override
    public Disciplines updateDiscipline(Disciplines discipline) {
        return null;
    }

    @Override
    public Disciplines readDiscipline(int idDiscipline) {
        return null;
    }
}
