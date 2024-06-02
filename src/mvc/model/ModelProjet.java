package mvc.model;

import entreprise.Investissement;
import entreprise.Projet;
import entreprise.Travail;
import mvc.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ModelProjet extends DAO<Projet> implements DAOSpecialProjet{

    private List<Projet> ldatas = new ArrayList<>();

    @Override
    public Projet add(Projet elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(Projet elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Projet update(Projet elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Projet read(Projet rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Projet> getAll() {
        return ldatas;
    }

    @Override
    public List<Investissement> listerInvestissements(Projet projet) {
        return null;
    }

    @Override
    public List<Travail> listerTravail(Projet projet) {
        return null;
    }

    @Override
    public List<Projet> getProjets() {
        return null;
    }

    @Override
    public Projet addProjet(Projet projet) {
        return null;
    }
    public void notifyObservers(){
        List<Observer> myObservers = new ArrayList<>();
        List l =getNotification();
        for(Observer o : myObservers) o.update(l);
    }

    @Override
    public boolean removeProjet(Projet projet) {
        return false;
    }

    @Override
    public Projet updateProjet(Projet projet) {
        return null;
    }

    @Override
    public Projet readProjet(int idProjet) {
        return null;
    }
}
