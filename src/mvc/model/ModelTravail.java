package mvc.model;

import entreprise.Employe;
import entreprise.Projet;
import entreprise.Travail;

import java.util.ArrayList;
import java.util.List;

public class ModelTravail extends DAO<Travail> implements DAOSpecialTravail{

    private List<Travail> ldatas = new ArrayList<>();

    @Override
    public Travail add(Travail elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(Travail elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Travail update(Travail elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Travail read(Travail rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Travail> getAll() {
        return ldatas;
    }

    @Override
    public List<Projet> listerProjets(Employe employe) {
        return null;
    }

    @Override
    public List<Employe> listerEmployes(Projet projet) {
        return null;
    }

    @Override
    public List<Travail> getTravails() {
        return null;
    }

    @Override
    public Travail addTravail(Travail travail) {
        return null;
    }

    @Override
    public boolean removeTravail(Travail travail) {
        return false;
    }

    @Override
    public Travail updateTravail(Travail travail) {
        return null;
    }

    @Override
    public Travail readTravail(int idTravail) {
        return null;
    }
}
