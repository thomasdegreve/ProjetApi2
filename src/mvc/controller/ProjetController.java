package mvc.controller;

import mvc.model.DAO;

import entreprise.Projet;

import mvc.view.AbstractView;

public class ProjetController extends Controller<Projet> {
    public ProjetController(DAO<Projet> model, AbstractView<Projet> view) {
        super(model, view);
    }


}



