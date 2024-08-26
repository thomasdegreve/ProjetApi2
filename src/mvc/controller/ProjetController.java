package mvc.controller;

import entreprise.Projet;
import entreprise.Employe;
import entreprise.Disciplines;
import mvc.model.DAO;
import mvc.model.DAOSpecialProjet;
import mvc.view.AbstractView;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class ProjetController extends Controller<Projet> implements ControllerSpecialProjet {

    public ProjetController(DAO<Projet> model, AbstractView<Projet> view) {
        super(model, view);
    }

    @Override
    public Set<Employe> listerEmployes(Projet p) {
        return ((DAOSpecialProjet) model).listerEmployes(p);
    }

    @Override
    public Set<Disciplines> listerDisciplines(Projet p) {
        return ((DAOSpecialProjet) model).listerDisciplines(p);
    }

    @Override
    public List<Projet> filtrerProjets(Predicate<Projet> pr) {
        return ((DAOSpecialProjet) model).filtrerProjets(pr);
    }

    @Override
    public int listerTravaux(Projet p) {
        return 0;
    }

    @Override
    public int listerInvestissements(Projet p) {
        return 0;
    }
}
