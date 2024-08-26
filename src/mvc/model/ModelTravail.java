package mvc.model;

import entreprise.Employe;
import entreprise.Projet;
import entreprise.Travail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ModelTravail extends DAO<Travail> implements DAOSpecialTravail {

    private List<Travail> ldatas = new ArrayList<>();

    @Override
    public Travail add(Travail elt) {
        if (!ldatas.contains(elt)) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        }
        return null;
    }

    @Override
    public boolean remove(Travail elt) {
        return false;
    }


    @Override
    public Travail update(Travail elt) {
        int index = ldatas.indexOf(elt);
        if (index >= 0) {
            ldatas.set(index, elt);
            notifyObservers();
            return elt;
        }
        return null;
    }

    @Override
    public Travail read(Travail rech) {
        int index = ldatas.indexOf(rech);
        return index >= 0 ? ldatas.get(index) : null;
    }

    @Override
    public List<Travail> getAll() {
        return ldatas;
    }


    public List<Travail> filtrerTravails(Predicate<Travail> predicate) {
        List<Travail> result = new ArrayList<>();
        ldatas.stream().filter(predicate).forEach(result::add);
        return result;
    }

    @Override
    public List<Travail> listerTravaux(Employe e) {
        return null;
    }

    @Override
    public List<Travail> listerTravaux(Projet p) {
        return null;
    }

    @Override
    public List<Travail> filtrerTravaux(Predicate<Travail> pr) {
        return null;
    }
}
