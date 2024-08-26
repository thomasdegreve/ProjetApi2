package mvc.controller;

import entreprise.Investissement;
import entreprise.Projet;
import entreprise.Disciplines;

import java.util.List;
import java.util.function.Predicate;

public interface ControllerSpecialInvestissement {


    public List<Investissement> listerInvestissements(Projet p);


    public List<Investissement> listerInvestissements(Disciplines d);


    List<Investissement> filtrerInvestissements(Predicate<Investissement> pr);
}
