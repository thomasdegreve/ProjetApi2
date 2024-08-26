package mvc.model;

import entreprise.Disciplines;
import entreprise.Employe;
import entreprise.Projet;
import entreprise.Travail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class ModelProjet extends DAO<Projet> implements DAOSpecialProjet {

    private List<Projet> ldatas = new ArrayList<>();

    @Override
    public Projet add(Projet elt) {
        if (!ldatas.contains(elt)) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        }
        return null;
    }

    @Override
    public boolean remove(Projet elt) {
        boolean ok = ldatas.remove(elt);
        /*Iterator<Travail> it = elt.getTravails().iterator();
        while (it.hasNext()) {
            Travail t = it.next();
            it.remove();
            t.setProjet(null);
        }*/
        notifyObservers();
        return ok;
    }

    @Override
    public Projet update(Projet elt) {
        int index = ldatas.indexOf(elt);
        if (index >= 0) {
            ldatas.set(index, elt);
            notifyObservers();
            return elt;
        }
        return null;
    }

    @Override
    public Projet read(Projet rech) {
        int index = ldatas.indexOf(rech);
        return index >= 0 ? ldatas.get(index) : null;
    }

    @Override
    public List<Projet> getAll() {
        return ldatas;
    }

    @Override
    public Set<Employe> listerEmployes(Projet p) {
        return null;
    }

    @Override
    public Set<Disciplines> listerDisciplines(Projet p) {
        return null;
    }

    @Override
    public List<Projet> filtrerProjets(Predicate<Projet> predicate) {
        List<Projet> result = new ArrayList<>();
        ldatas.stream().filter(predicate).forEach(result::add);
        return result;
    }
}
