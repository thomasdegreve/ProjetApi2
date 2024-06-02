package mvc.model;

import entreprise.Investissement;
import mvc.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ModelInvestissement extends DAO<Investissement> implements DAOSpecialInvestissement{

    private List<Investissement> ldatas = new ArrayList<>();

    @Override
    public Investissement add(Investissement elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(Investissement elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Investissement update(Investissement elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Investissement read(Investissement rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }
    public void notifyObservers(){
        List<Observer> myObservers = new ArrayList<>();
        List l =getNotification();
        for(Observer o : myObservers) o.update(l);
    }
    @Override
    public List<Investissement> getAll() {
        return ldatas;
    }

    @Override
    public int getTotalInvestissement(Investissement investissement) {
        return 0;
    }

    @Override
    public List<Investissement> getInvestissements() {
        return null;
    }

    @Override
    public Investissement addInvestissement(Investissement investissement) {
        return null;
    }

    @Override
    public boolean removeInvestissement(Investissement investissement) {
        return false;
    }

    @Override
    public Investissement updateInvestissement(Investissement investissement) {
        return null;
    }

    @Override
    public Investissement readInvestissement(int idInvestissement) {
        return null;
    }
}
