package mvc.controller;

import entreprise.Employe;
import entreprise.Projet;
import entreprise.Disciplines;
import mvc.model.DAO;
import mvc.model.DAOSpecialEmploye;
import mvc.view.AbstractView;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class EmployeController extends Controller<Employe> implements ControllerSpecialEmploye {

    public EmployeController(DAO<Employe> model, AbstractView<Employe> view) {
        super(model, view);
    }

    @Override
    public Set<Projet> listerProjets(Employe e) {
        return ((DAOSpecialEmploye) model).listerProjets(e);
    }

    @Override
    public Set<Disciplines> listerDisciplines(Employe e) {
        return ((DAOSpecialEmploye) model).listerDisciplines(e);
    }

    @Override
    public List<Employe> filtrerEmployes(Predicate<Employe> pr) {
        return ((DAOSpecialEmploye) model).filtrerEmployes(pr);
    }

    @Override
    public int listerTravaux(Employe e) {
        return 0;
    }
}
