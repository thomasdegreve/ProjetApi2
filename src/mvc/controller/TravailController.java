package mvc.controller;

import mvc.model.DAO;
import entreprise.Travail;
import mvc.view.AbstractView;

public class TravailController extends Controller<Travail> {
    public TravailController(DAO<Travail> model, AbstractView<Travail> view) {
        super(model, view);
    }

    // Ajoutez ici des méthodes spécifiques à Travail, si nécessaire
}
