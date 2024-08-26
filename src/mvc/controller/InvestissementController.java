package mvc.controller;

import entreprise.Investissement;
import entreprise.Projet;
import entreprise.Disciplines;
import mvc.model.DAO;
import mvc.model.DAOSpecialInvestissement;
import mvc.view.AbstractView;

import java.util.List;
import java.util.function.Predicate;

public class InvestissementController extends Controller<Investissement> implements ControllerSpecialInvestissement {

    public InvestissementController(DAO<Investissement> model, AbstractView<Investissement> view) {
        super(model, view);
    }

    @Override
    public List<Investissement> listerInvestissements(Projet p) {
        return ((DAOSpecialInvestissement) model).listerInvestissements(p);
    }

    @Override
    public List<Investissement> listerInvestissements(Disciplines d) {
        return ((DAOSpecialInvestissement) model).listerInvestissements(d);
    }

    @Override
    public List<Investissement> filtrerInvestissements(Predicate<Investissement> pr) {
        return ((DAOSpecialInvestissement) model).filtrerInvestissements(pr);
    }
}
