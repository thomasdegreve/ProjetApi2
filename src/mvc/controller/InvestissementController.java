package mvc.controller;

import mvc.model.DAO;
import entreprise.Investissement;
import mvc.view.AbstractView;

public class InvestissementController extends Controller<Investissement> {
    public InvestissementController(DAO<Investissement> model, AbstractView<Investissement> view) {
        super(model, view);
    }


}
