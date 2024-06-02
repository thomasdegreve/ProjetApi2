package mvc.controller;

import mvc.model.DAO;
import entreprise.Employe;
import mvc.view.AbstractView;

public class EmployeController extends Controller<Employe> {
    public EmployeController(DAO<Employe> model, AbstractView<Employe> view) {
        super(model, view);
    }


}
