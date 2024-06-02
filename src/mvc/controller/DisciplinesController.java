package mvc.controller;

import mvc.model.DAO;
import entreprise.Disciplines;
import mvc.view.AbstractView;

public class DisciplinesController extends Controller<Disciplines> {
    public DisciplinesController(DAO<Disciplines> model, AbstractView<Disciplines> view) {
        super(model, view);
    }


}
