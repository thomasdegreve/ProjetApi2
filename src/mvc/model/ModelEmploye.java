package mvc.model;

import entreprise.Disciplines;
import entreprise.Employe;
import entreprise.Projet;
import entreprise.Travail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class ModelEmploye extends DAO<Employe> implements DAOSpecialEmploye {

    private List<Employe> ldatas = new ArrayList<>();

    @Override
    public Employe add(Employe elt) {
        if (!ldatas.contains(elt)) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        }
        return null;
    }

    @Override
    public boolean remove(Employe elt) {
        boolean ok = ldatas.remove(elt);

        return ok;
    }

    @Override
    public Employe update(Employe elt) {
        int index = ldatas.indexOf(elt);
        if (index >= 0) {
            ldatas.set(index, elt);
            notifyObservers();
            return elt;
        }
        return null;
    }

    @Override
    public Employe read(Employe rech) {
        int index = ldatas.indexOf(rech);
        return index >= 0 ? ldatas.get(index) : null;
    }

    @Override
    public List<Employe> getAll() {
        return ldatas;
    }

    @Override
    public Set<Projet> listerProjets(Employe e) {
        return null;
    }

    @Override
    public Set<Disciplines> listerDisciplines(Employe e) {
        return null;
    }

    @Override
    public List<Employe> filtrerEmployes(Predicate<Employe> predicate) {
        List<Employe> result = new ArrayList<>();
        ldatas.stream().filter(predicate).forEach(result::add);
        return result;
    }
}
