package mvc.controller;

import entreprise.Travail;
import entreprise.Employe;
import entreprise.Projet;

import java.util.List;
import java.util.function.Predicate;

public interface ControllerSpecialTravail {


    public List<Travail> listerTravaux(Employe e);


    public List<Travail> listerTravaux(Projet p);


    List<Travail> filtrerTravaux(Predicate<Travail> pr);
}
