package mvc.controller;

import entreprise.Disciplines;
import entreprise.Projet;
import mvc.controller.Controller;
import mvc.model.DAO;

import mvc.model.DAOSpecialDisciplines;
import mvc.view.AbstractView;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class DisciplinesController extends Controller<Disciplines> implements ControllerSpecialDiscipline {

    public DisciplinesController(DAO<Disciplines> model, AbstractView<Disciplines> view) {
        super(model, view);
    }


    public Set<Projet> listerProjets(Disciplines d) {
        return ((DAOSpecialDisciplines)model).listerProjets(d);
    }


    public List<Projet> listerProjets(Disciplines d, double minBudget, double maxBudget) {
        return ((DAOSpecialDisciplines)model).listerProjets(d, minBudget, maxBudget);
    }


    @Override
    public List<Disciplines> filtrerDisciplines(Predicate<Disciplines> pr) {
        return ((DAOSpecialDisciplines)model).filtrerDisciplines(pr);
    }

    @Override
    public int listerEmployes(Disciplines d) {
        return 0;
    }
}
