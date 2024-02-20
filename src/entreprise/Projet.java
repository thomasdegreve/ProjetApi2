package entreprise;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projet {
    /**
     * id unique du projet
     */
    protected int idProjet;
    /**
     * nom unique du projet
     */
    protected String nom;
    /**
     * date du debut du projet
     */
    protected LocalDate datedebut;
    /**
     * date de fin du projet
     */
    protected LocalDate datefin;
    /**
     * cout du projet
     */
    protected DecimalFormat cout;

    /**
     * liste des investissements pour le projet
     */
    protected List<Investissement> investissements=new ArrayList<>();
    /**
     * liste des travaux du projet
     */
    protected  List<Travail> travails=new ArrayList<>();

    /**
     * constructeur paramétré
     * @param  idProjet numérique unique du produit
     * @param nom nom du projet
     * @param datedebut date debut du projet
     * @param datefin date de fin du projet
     * @param cout cout du projet/**
     * constructeur paramétré
     */
    public Projet(int idProjet,String nom,LocalDate datedebut,LocalDate datefin,DecimalFormat cout){
        this.idProjet=idProjet;
        this.nom=nom;
        this.datedebut=datedebut;
        this.datefin=datefin;
        this.cout=cout;
    }

    /**
     * getter idprojet
     * return l'id du projet
     */
    public int getIdProjet() {
        return idProjet;
    }
    /**
     * setter idprojet
     * @param idProjet id unique du projet
     */
    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }
    /**
     * getter nom
     * return nom du projet
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter nom
     * @param nom nom du projet
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter Datedebut
     * return la date du debut du projet
     */
    public LocalDate getDatedebut() {
        return datedebut;
    }
    /**
     * setter Datedebut
     * @param datedebut date debut du projet
     */
    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }
    /**
     * getter datefin
     * return la date de fin du projet
     */
    public LocalDate getDatefin() {
        return datefin;
    }
    /**
     * setter datefin
     * @param datefin date de fin du projet
     */
    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }
    /**
     * getter cout
     * return les couts du projet
     */
    public DecimalFormat getCout() {
        return cout;
    }
    /**
     * setter cout
     * @param cout cout du projet
     */
    public void setCout(DecimalFormat cout) {
        this.cout = cout;
    }
    /**
     * getter invetissements()
     * return la liste des investissements pour le projet
     */
    public List<Investissement> getInvestissements() {
        return investissements;
    }
    /**
     * setter invetissements()
     * @param investissements liste investissements du projet
     */
    public void setInvestissements(List<Investissement> investissements) {
        this.investissements = investissements;
    }

    /**
     * getter travails()
     * return la liste des travaux pour le projet
     */
    public List<Travail> getTravails() {
        return travails;
    }
    /**
     * setter travails()
     * @param travails la liste des travaux pour le projet
     */
    public void setTravails(List<Travail> travails) {
        this.travails = travails;
    }

    /**
     * fonction qui permet d'afficher la Liste des disciplines et investissements
     *
     */
    public  void ListeDisciplinesEtInvestissement(){
        for(Investissement inv : investissements){
            System.out.println("Disciplines : "+inv.specialite.getNom() +" Investissement : "+inv.quantiteJH );
        }

    }
    /**
     * fonction qui permet de caculer l'investissement total
     *return l'investissement total
     */
    public int InvestissementTotal(){
        int invesTot = 0;
        for(Investissement inv : investissements){
            invesTot+=inv.quantiteJH;
        }
        return invesTot;
    }
    /**
     * fonction qui permet d'ajouter des disciplines
     * @param disciplines discipline a ajouter
     * @param quantite quantite en JH
     */
    public void addDisciplines(Disciplines disciplines,int quantite){
        Investissement investissement = new Investissement(quantite, disciplines);
        investissements.add(investissement);
    }
    /**
     * fonction qui permet de modifier des disciplines
     * @param disciplines discipline a modifier
     * @param quantite quantite en JH
     */
    public void modifDisciplines(Disciplines disciplines,int quantite){
        for(Investissement inv : investissements){
            if(inv.getSpecialite().equals(disciplines)){
                inv.setQuantiteJH(quantite);
                return;
            }
        }
    }

    /**
     * fonction qui permet de supprimer une discipline d'un projet
     *@param disciplines discipline a supprimer
     */
    public void suppDisciplines(Disciplines disciplines){
        for(Investissement inv : investissements){
            if(inv.getSpecialite().equals(disciplines)){
                investissements.remove(inv);
                return;
            }
        }
    }
    /**
     * fonction qui permet d'afficher la liste des employés avec leur pourcentage et leur date d'engagement
     *
     */
    public void ListeEmployeEtPourcentageEtDate(){
        for(Travail trv : travails){
            System.out.println("Employe : "+trv.getEmployes() +" Pourcentage : "+trv.getPourcentage() +"Date : "+trv.getDateEngag());
        }
    }
    /**
     * fonction qui permet d'ajouter un employé dans un projet
     * @param employe employe à ajouter
     * @param pourcentage pourcentage de l'employ"
     *  @param date date d'engagement
     */
    public void addEmploye(Employe employe,int pourcentage,LocalDate date){
        Travail travail1 = new Travail(pourcentage,date,employe);
        travails.add(travail1);
    }
    /**
     * fonction qui permet de supprimer un employé dans un projet
     * @param employe employe à supprimer

     */
    public void suppEmploye(Employe employe){
        travails.removeIf(travail -> travail.getEmployes() == employe);

    }
    /**
     * fonction qui permet de modifier un employé dans un projet
     * @param employe employe à modifier
     * @param pourcentage pourcentage de travail

     */
    public void modifEmploye(Employe employe,int pourcentage){
        for(Travail trv : travails){
            if(trv.getEmployes()==employe){
                trv.setPourcentage(pourcentage);
                return;
            }
        }
    }
    /**
     * fonction qui permet de calculer le pourcentage total
     * return le total

     */
    public int totalPourcentage(){
        int total = 0;
        for(Travail travail : travails){
            total += travail.getPourcentage();
        }
        return total;

    }
    /**
     * fonction qui permet d'afficher la liste des specialités
     * return la liste

     */
    public String listeSpecialite(){
        List<String> specialites = new ArrayList<>();
        for(Investissement inv : investissements){
            specialites.add(inv.getSpecialite().getNom());
        }
        return specialites.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projet projet = (Projet) o;
        return nom.equals(projet.nom);
    }
}