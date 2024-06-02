package mvc.model;

import entreprise.Employe;
import entreprise.Travail;
import mvc.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ModelEmploye extends DAO<Employe> implements DAOSpecialEmploye{

    private List<Employe> ldatas = new ArrayList<>();

    @Override
    public Employe add(Employe elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }public void notifyObservers(){
        List<Observer> myObservers = new ArrayList<>();
        List l =getNotification();
        for(Observer o : myObservers) o.update(l);
    }

    @Override
    public boolean remove(Employe elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Employe update(Employe elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Employe read(Employe rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Employe> getAll() {
        return ldatas;
    }

    @Override
    public List<Travail> listerTravaux(Employe employe) {
        return null;
    }

    @Override
    public List<Employe> getEmployes() {
        return null;
    }

    @Override
    public Employe addEmploye(Employe employe) {
        return null;
    }

    @Override
    public boolean removeEmploye(Employe employe) {
        return false;
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        return null;
    }

    @Override
    public Employe readEmploye(int idEmploye) {
        return null;
    }
}
