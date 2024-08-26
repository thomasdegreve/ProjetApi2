package mvc.controller;

import entreprise.Travail;
import entreprise.Employe;
import entreprise.Projet;
import mvc.model.DAO;
import mvc.model.DAOSpecialTravail;
import mvc.view.AbstractView;

import java.util.List;
import java.util.function.Predicate;

public class TravailController extends Controller<Travail> implements ControllerSpecialTravail {

    public TravailController(DAO<Travail> model, AbstractView<Travail> view) {
        super(model, view);
    }

    @Override
    public List<Travail> listerTravaux(Employe e) {
        return ((DAOSpecialTravail) model).listerTravaux(e);
    }

    @Override
    public List<Travail> listerTravaux(Projet p) {
        return ((DAOSpecialTravail) model).listerTravaux(p);
    }

    @Override
    public List<Travail> filtrerTravaux(Predicate<Travail> pr) {
        return ((DAOSpecialTravail) model).filtrerTravaux(pr);
    }
}
