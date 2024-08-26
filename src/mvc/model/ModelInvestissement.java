package mvc.model;

import entreprise.Disciplines;
import entreprise.Investissement;
import entreprise.Projet;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ModelInvestissement extends DAO<Investissement> implements DAOSpecialInvestissement {

    private List<Investissement> ldatas = new ArrayList<>();

    @Override
    public Investissement add(Investissement elt) {
        if (!ldatas.contains(elt)) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        }
        return null;
    }

    @Override
    public boolean remove(Investissement elt) {
        boolean ok = ldatas.remove(elt);
        if (ok) {
            Projet.removeInvestissement(elt);
        }
        notifyObservers();
        return ok;
    }

    @Override
    public Investissement update(Investissement elt) {
        int index = ldatas.indexOf(elt);
        if (index >= 0) {
            ldatas.set(index, elt);
            notifyObservers();
            return elt;
        }
        return null;
    }

    @Override
    public Investissement read(Investissement rech) {
        int index = ldatas.indexOf(rech);
        return index >= 0 ? ldatas.get(index) : null;
    }

    @Override
    public List<Investissement> getAll() {
        return ldatas;
    }

    @Override
    public List<Investissement> listerInvestissements(Projet p) {
        return null;
    }

    @Override
    public List<Investissement> listerInvestissements(Disciplines d) {
        return null;
    }

    @Override
    public List<Investissement> filtrerInvestissements(Predicate<Investissement> predicate) {
        List<Investissement> result = new ArrayList<>();
        ldatas.stream().filter(predicate).forEach(result::add);
        return result;
    }
}
